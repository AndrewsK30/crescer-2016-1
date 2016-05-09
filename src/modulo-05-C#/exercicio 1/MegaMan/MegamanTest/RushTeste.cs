using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaManWorld;

namespace MegamanTest
{
    [TestClass]
    public class RushTeste
    {
        [TestMethod]
        public void RushTem4DeAtaqueE3DeDefesa()
        {
            Rush rush = new Rush();

            Assert.AreEqual("Nome:Rush, Vida:100, Ataque:4, Defesa:3", rush.ToString());
        }
        [TestMethod]
        public void RushAtacaBotETira4DeVida()
        {
            Rush rush = new Rush();
            Bot bot = new Bot();

            rush.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:96, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void RushEquipaCanhaoDePlasmaEAtacaBotTirando6DeVida()
        {
            Rush rush = new Rush();
            Bot bot = new Bot();
            CanhaoDePlasma canhaoDePlasma = new CanhaoDePlasma();
            
            rush.EquiparUpgrade(canhaoDePlasma);
            rush.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:94, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void RushEquipa5ItensMasSoPode2()
        {
            Rush rush = new Rush();
            CanhaoDePlasma canhaoDePlasma = new CanhaoDePlasma();
            BotasDeSuperVelocidade botasDeVelocidade = new BotasDeSuperVelocidade();
            EscudoDeEnergia escudoDeEnergia = new EscudoDeEnergia();

            rush.EquiparUpgrade(canhaoDePlasma);
            rush.EquiparUpgrade(botasDeVelocidade);
            rush.EquiparUpgrade(escudoDeEnergia);
            rush.EquiparUpgrade(canhaoDePlasma);
            rush.EquiparUpgrade(escudoDeEnergia);

            Assert.AreEqual("Nome:Rush, Vida:100, Ataque:7, Defesa:4", rush.ToString());
        }
        [TestMethod]
        public void RushViraUpgradeDeMegaMan()
        {
            Rush rush = new Rush();
            MegaMan megaMan = new MegaMan();

            megaMan.EquiparUpgrade(rush);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:10, Defesa:3", megaMan.ToString());
        }
        [TestMethod]
        public void RushTem2UpgradesEViraUpgradeDeMegaMan()
        {
            Rush rush = new Rush();
            MegaMan megaMan = new MegaMan();
            CanhaoDePlasma canhaoDePlasma = new CanhaoDePlasma();
            BotasDeSuperVelocidade botasDeVelocidade = new BotasDeSuperVelocidade();

            rush.EquiparUpgrade(canhaoDePlasma);
            rush.EquiparUpgrade(botasDeVelocidade);

            megaMan.EquiparUpgrade(rush);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:13, Defesa:4", megaMan.ToString());
        }
    }
}
