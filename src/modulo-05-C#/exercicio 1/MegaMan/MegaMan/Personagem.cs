using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan
{
    public abstract class Personagem
    {

        public abstract string Nome { get; set;}

        public Personagem(String nome)
        {
            Nome = nome;
        }
    }
}
