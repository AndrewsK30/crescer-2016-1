using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public class Rush : Robo,IUpgrade
    {
        public Rush(Chip chip = CHIP_PADRAO) : base(chip)
        {
            this.Nome = "Rush";
            this.Ataque = 4;
            this.Defesa = 3;           
        }

        int IUpgrade.BonusAtaque
        {
            get
            {
                return this.Ataque;
            }
        }

        int IUpgrade.BonusDefesa
        {
            get
            {
                return this.Defesa;
            }
        }

        protected override Boolean MaxEquipamentos
        {
            get
            {
                return Equipamentos.Count < 2;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (!(robo is MegaMan))
                base.Atacar(robo);

        }
    }
}
