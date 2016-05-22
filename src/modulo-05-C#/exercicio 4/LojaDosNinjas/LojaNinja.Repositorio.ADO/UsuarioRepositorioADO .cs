using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace LojaNinja.Repositorio.ADO
{
    public class UsuarioRepositorioADO : RepositorioBase, IUsuarioRepositorio
    {
            public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    string sql = "SELECT TOP 1 * FROM Usuario WHERE Email=@p_email AND Senha=@p_senha";
                    var comando = new SqlCommand(sql, conexao);
                    comando.Parameters.Add(new SqlParameter("p_email", email));
                    comando.Parameters.Add(new SqlParameter("p_senha", senha));

                    conexao.Open();

                    SqlDataReader leitor = comando.ExecuteReader();
                    Usuario usuarioEncontrado = null;

                    if (leitor.Read())
                    {
                        usuarioEncontrado = LerUsuarioDoBanco(leitor);
                        leitor.Close();
                    }

                    if (usuarioEncontrado != null)
                    {
                        CarregarPermissoesDoUsuario(usuarioEncontrado, conexao);
                    }

                    return usuarioEncontrado;
                }
            }

            public void CadastraNovoUsuario(Usuario usuario)
            {
            
                using (var transaction = new TransactionScope())
                using (var conexao = new SqlConnection(ConnectionString))
                 {
                    string sql =
                        @"INSERT INTO [dbo].[Usuario]
                                   ([Email]
                                   ,[Senha]
                                   ,[Nome])
                             VALUES
                                   (@p_email
                                   ,@p_senha
                                   ,@p_nome)
                    
                          SELECT MAX(Id) as LastId FROM [dbo].[Usuario]";

                    var comando = new SqlCommand(sql, conexao);
                    comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                    comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));
                    comando.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                    conexao.Open();
                    SqlDataReader leitor = comando.ExecuteReader();
                    leitor.Read();

                    int lastId = Convert.ToInt32(leitor["LastId"]);

                    leitor.Close();

                    if (usuario.Permissoes != null)
                    {
                        foreach (Permissao permissao in usuario.Permissoes)
                        {
                            sql =
                                @"INSERT INTO [dbo].[UsuarioPermissao]
                                           ([IdUsuario]
                                           ,[IdPermissao])
                                     VALUES
                                           (@p_usuario_Id
                                           ,@p_permissao_Id)";

                            comando = new SqlCommand(sql, conexao);
                            comando.Parameters.Add(new SqlParameter("p_usuario_Id", lastId));
                            comando.Parameters.Add(new SqlParameter("p_permissao_Id", permissao.Id));

                            comando.ExecuteNonQuery();
                        }
                    }

              
                    transaction.Complete();
                }
            }

            private Usuario LerUsuarioDoBanco(SqlDataReader reader)
            {
                return new Usuario(
                        id: Convert.ToInt32(reader["Id"]),
                        email: reader["Email"].ToString(),
                        nome: reader["Nome"].ToString(),
                        senha: reader["Senha"].ToString(),
                        permissoes: null);
            }

            private void CarregarPermissoesDoUsuario(Usuario usuario, SqlConnection conexaoAtual)
            {
                var comando = new SqlCommand(
                            @"SELECT p.* FROM Permissao p 
                              INNER JOIN UsuarioPermissao up ON up.IdPermissao = p.Id
                              WHERE up.IdUsuario = @p_idUsuario", conexaoAtual);

                comando.Parameters.Add(new SqlParameter("p_idUsuario", usuario.Id));

                SqlDataReader leitor = comando.ExecuteReader();

                while (leitor.Read())
                {
                    Permissao permissao = LerPermissaoDoBanco(leitor);
                    usuario.AtribuirPermissao(permissao);
                }

                leitor.Close();
            }

            private Permissao LerPermissaoDoBanco(SqlDataReader leitor)
            {
                return new Permissao(
                    id: Convert.ToInt32(leitor["Id"]),
                    nome: leitor["Nome"].ToString());
            }

            public List<Usuario> BuscarTodosUsuarios()
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    string sql = "SELECT Nome,Email,Permissoes FROM Usuario";
                    var comando = new SqlCommand(sql, conexao);
                
                    conexao.Open();

                    SqlDataReader leitor = comando.ExecuteReader();
                    List<Usuario> usuariosList = new List<Usuario>();

                    if (leitor.Read())
                    {
                        usuariosList.Add (LerUsuarioDoBanco(leitor));
                        leitor.Close();
                    }

                    if (usuariosList != null)
                    {
                        foreach (var usuario in usuariosList)
                        {
                            CarregarPermissoesDoUsuario(usuario, conexao);
                        }                    
                    }

                    return usuariosList;
                }
            }
        }
    
}
