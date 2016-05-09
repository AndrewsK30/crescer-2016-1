using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public class ProtoMan : Robo
    {
        Boolean AindaNaoMorreu = true;
        
        public ProtoMan(Chip chip = CHIP_PADRAO) : base(chip)
        {
            this.Nome = "Proto Man";
            this.Defesa = 2;

        }

        protected override int Ataque
        {
            get
            {
                return (AindaNaoMorreu ? this.ataque : this.ataque + 2) + bonusAtaque;
            }
        }

        protected override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);
            if (AindaNaoMorreu && this.Vida <= 0)
            {
                this.Vida = 20;                
                AindaNaoMorreu = false;                
            }
        }
    }
}
