using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public class ProtoMan : Robo
    {
        Boolean MorreuPrimeiraVez = true;

        public ProtoMan() : base("Proto Man")
        {
            this.Defesa = 2;
        }

        protected override int Defesa
        {
            get
            {
                return 2;
            }
        }

        public override void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            this.Vida -= dano;
            if (this.Vida <= 0 && MorreuPrimeiraVez)
            {
                this.Vida = 20;
                this.Ataque = 7;
                MorreuPrimeiraVez = false;                
            }
        }
    }
}
