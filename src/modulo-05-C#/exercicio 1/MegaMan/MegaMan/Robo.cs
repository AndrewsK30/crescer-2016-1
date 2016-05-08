using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public class Robo
    {
        public String Nome { get; protected set; }
        public int Vida { get; protected set; }
        protected int ataque = 5;
        protected int defesa = 0;

        public Robo(String nome)
        {
            Vida = 100;           
            Nome = nome;
        }

        protected virtual int Defesa
        {
            get
            {
                return defesa;
            }
            set
            {
                defesa = value;
            }
        }

        protected virtual int Ataque
        {
            get
            {
                return ataque;
            }
            set
            {
                ataque = value;
            }
        }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            this.Vida -= dano;
        }

        public override string ToString()
        {
            return "Nome:"+this.Nome+", Vida:"+this.Vida+", Ataque:"+this.Ataque+", Defesa:"+this.Defesa;
        }
    }
}
