using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public class Rush : Robo,IUpgrade
    {
        public Rush(Chip chip) : base(chip)
        {
            this.Nome = "Rush";
            this.Ataque = 4;
            this.Defesa = 3;
            this.maxEquipamentos = 2;
        }

        int IUpgrade.BonusAtaque
        {
            get
            {
                return this.ataque + this.bonusAtaque;
            }
        }

        int IUpgrade.BonusDefesa
        {
            get
            {
                return this.defesa + this.bonusDefesa;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (!(robo is MegaMan)) base.Atacar(robo);

        }
    }
}
