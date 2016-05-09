using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaManWorld
{
    public abstract class Robo
    {
        public String Nome { get; protected set; }
        protected int Vida { get; set; }
        private Chip _chip;
        private int ataque = 5,
                      defesa;

        protected List<IUpgrade> Equipamentos = new List<IUpgrade>();
        protected const Chip CHIP_PADRAO = Chip.Nivel2;

        public Robo(Chip chip = CHIP_PADRAO)
        {
            Vida = 100;
            _chip = chip;
        }

        protected virtual int Defesa
        {
            get
            {
                return defesa + 
                       BonusDeDefesaPorChip +
                       BonusDeDefesaPorUpgrades;
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
                return ataque + 
                       BonusDeAtaquePorChip + 
                       BonusDeAtaquePorUpgrades;
            }
            set
            {
                ataque = value;
            }
        }

        protected int BonusDeAtaquePorUpgrades
        {
            get
            {
                int bonus = 0;

                foreach (IUpgrade upgrade in Equipamentos)
                    bonus += upgrade.BonusAtaque;

                return bonus;
            }
        }

        protected int BonusDeDefesaPorUpgrades
        {
            get
            {
                int bonus = 0;

                foreach (IUpgrade upgrade in Equipamentos)
                    bonus += upgrade.BonusDefesa;

                return bonus;
            }
        }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            if(dano > 0)
                this.Vida -= dano;
        }

        public override string ToString()
        {
            return "Nome:"+this.Nome+", Vida:"+this.Vida+", Ataque:"+this.Ataque+", Defesa:"+this.Defesa;
        }

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (this.MaxEquipamentos)
            {
                Equipamentos.Add(upgrade);
            }
            
        }

        protected virtual Boolean MaxEquipamentos
        {
            get
            {
                return Equipamentos.Count < 3;
            }
        }

        private int BonusDeDefesaPorChip
        {
            get
            {
                switch (_chip)
                {
                    case Chip.Nivel3:
                        return 1;
                    default:
                        return 0;
                }
            }
        }

        private int BonusDeAtaquePorChip
        {
            get
            {
                switch (_chip)
                {
                    case Chip.Nivel1:
                        return -1;
                    case Chip.Nivel3:
                        return 2;
                    default:
                        return 0;
                }
            }
        }
    }
}
