using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    
    public class UsuarioServico
    {
        private IUsuarioRepositorio _usuarioRepositorio;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            _usuarioRepositorio = usuarioRepositorio;
        }

        public bool regraDeSenhaOK(string senha)
        {
               return senha.Length > 7 &&
                      senha.Any(x => char.IsUpper(x)) &&
                      senha.Any(x => char.IsLower(x)) &&
                      senha.Any(char.IsDigit);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {

            string senhaCriptografada = Criptografar(senha);

            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);

            return usuarioEncontrado;
        }

        public void CadastrarUsuario(string email, string senha, string nome)
        {

            _usuarioRepositorio.CadastraNovoUsuario(new Usuario(0,email, Criptografar(senha), nome,new List<Permissao>(){new Permissao(1,"COMUM")}));


        }

        public List<Usuario> BuscarTodosUsuarios()
        {
            return _usuarioRepositorio.BuscarTodosUsuarios();
        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();

                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                return sBuilder.ToString();
            }
        }
    }
    
}
