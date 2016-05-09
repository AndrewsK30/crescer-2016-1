using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace MegaManWorld
{
    public class MegaMan : Robo
    {
        public MegaMan(Chip chip = CHIP_PADRAO) : base(chip)
        {
            this.Nome = "Mega Man";
            this.Ataque = 6;

        }

        public override void Atacar(Robo robo)
        {
            int ataqueFinal = this.Vida < 30 ?
                                this.Ataque + 3 :
                                this.Ataque;           

            robo.ReceberAtaque(ataqueFinal);
        }

    }
}
