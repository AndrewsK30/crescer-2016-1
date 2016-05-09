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
        protected int ataque = 5,
                      defesa,
                      bonusAtaque,
                      bonusDefesa,
                      maxEquipamentos = 3;
        protected List<IUpgrade> equipamentos = new List<IUpgrade>();
        protected const Chip CHIP_PADRAO = Chip.Nivel2;

        public Robo(Chip chip = CHIP_PADRAO)
        {
            Vida = 100;
            CalculaBonusChips(chip);
        }

        private void CalculaBonusChips(Chip chip)
        {
            switch (chip)
            {
                case Chip.Nivel1:
                    bonusAtaque--;
                    break;
                case Chip.Nivel3:
                    bonusAtaque += 2;
                    bonusDefesa++;
                    break;
            }
        }

        protected virtual int Defesa
        {
            get
            {
                return defesa + this.bonusDefesa;
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
                return ataque + this.bonusAtaque;
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

        protected virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            this.Vida -= dano;
        }

        public override string ToString()
        {
            return "Nome:"+this.Nome+", Vida:"+this.Vida+", Ataque:"+this.Ataque+", Defesa:"+this.Defesa;
        }

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (equipamentos.Count < this.maxEquipamentos)
            {
                this.bonusAtaque += upgrade.BonusAtaque;
                this.bonusDefesa += upgrade.BonusDefesa;
                equipamentos.Add(upgrade);
            }
            
        }
    }
}
