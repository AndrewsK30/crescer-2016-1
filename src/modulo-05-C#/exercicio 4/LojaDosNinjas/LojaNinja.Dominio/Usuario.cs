
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{   
    public class Usuario
    {
        public int Id { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; internal set; }
        public string Nome { get; private set; }
        public IList<Permissao> Permissoes { get; private set; }

        private Usuario()
        {

        }

        public Usuario(int id, string email, string senha, string nome, IList<Permissao> permissoes)
        {
            this.Id = id;
            this.Email = email;
            this.Senha = senha;
            this.Nome = nome;
            this.Permissoes = permissoes;
        }      

        public void AtribuirPermissao(Permissao permissao)
        {
            if (this.Permissoes == null)
            {
                this.Permissoes = new List<Permissao>();
            }

            this.Permissoes.Add(permissao);
        }
    }    
}
