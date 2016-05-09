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

        public override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);
            if (this.Vida <= 0  && AindaNaoMorreu)
            {
                this.Ataque = 7;
                this.Vida = 20;                
                AindaNaoMorreu = false;                
            }
        }
    }
}
