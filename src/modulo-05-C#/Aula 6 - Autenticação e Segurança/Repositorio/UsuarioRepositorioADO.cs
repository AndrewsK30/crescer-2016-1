using Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            
            string connectionString = ConfigurationManager.ConnectionStrings["ExemploADODotNet"].ConnectionString;

            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT TOP 1 * FROM Usuarios WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();
                Usuario usuario = null;
                if (leitor.Read())
                {
                    usuario = new Usuario();
                    usuario.Id = leitor.ReadInt("id");
                    usuario.Email = leitor["email"].ToString();
                    usuario.Nome = leitor["nome"].ToString();
                }            
                    
                
                return usuario;


            }
        }
    }
}
