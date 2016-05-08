using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace MegaManWorld
{
    public class MegaMan : Robo
    {
        public MegaMan() : base("Mega Man")
        {
            this.Ataque = 6;
        }

        protected override int Ataque
        {
            get
            {
                return this.Vida <= 30 ? this.ataque + 3 : this.ataque ;
            }
        }

    }
}
