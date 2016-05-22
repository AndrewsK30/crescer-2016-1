using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio.EF
{
    public class UsuarioRepositorioEF : IUsuarioRepositorio
    {
        public List<Usuario> BuscarTodosUsuarios()
        {
            using (var db = new ContextoDeDados())
            {

                var usuario = db.Usuario.Include("Permissoes").ToList();

                return usuario;
            }
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var db = new ContextoDeDados())
            {
          
                Usuario usuario = db.Usuario.Include("Permissoes").FirstOrDefault(
                    u =>
                        u.Email.Equals(email)
                        && u.Senha.Equals(senha));

                return usuario;
            }
        }


        public void CadastraNovoUsuario(Usuario usuario)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Usuario>(usuario).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
            }
        }

    }
}