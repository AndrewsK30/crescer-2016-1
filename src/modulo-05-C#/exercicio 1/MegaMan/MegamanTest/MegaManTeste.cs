using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaManWorld;

namespace MegamanTest
{
    [TestClass]
    public class MegaManTeste
    {
        [TestMethod]
        public void MegamanTem6DeAtaqueE0DeDefesa()
        {
            MegaMan megaMan = new MegaMan();
            
            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:6, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void BotEhAtacadoUmaVezPorMegaManEPerde6DeVida()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();

            megaMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:94, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegaManEhAtacadoUmaVezPorBotEPerde5DeVida()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();

            bot.Atacar(megaMan);

            Assert.AreEqual("Nome:Mega Man, Vida:95, Ataque:6, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegaManEhAtacadoAteSuaVidaChegarIgualA30()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            for (int i = 0; i < 14; i++)
            {
                bot.Atacar(megaMan);
            }
            

            Assert.AreEqual("Nome:Mega Man, Vida:30, Ataque:9, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegaManAtcaComAvidaAbaixoDe30()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaMan);
            }
            megaMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:91, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegamanEquipa1ItemEAtacaBot()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();

            megaMan.EquiparUpgrade(botasDeVelocidade);

            megaMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:93, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegamanEquipa3ItemEAtacaBot()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();
            IUpgrade canhaoDePlasma = new CanhaoDePlasma();


            megaMan.EquiparUpgrade(botasDeVelocidade);
            megaMan.EquiparUpgrade(escudoDeEnergia);
            megaMan.EquiparUpgrade(canhaoDePlasma);

            megaMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:91, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegamanEquipa3ItemETemVidaMenorQue30()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();
            IUpgrade canhaoDePlasma = new CanhaoDePlasma();

            megaMan.EquiparUpgrade(botasDeVelocidade);
            megaMan.EquiparUpgrade(escudoDeEnergia);
            megaMan.EquiparUpgrade(canhaoDePlasma);

            for (int i = 0; i < 48; i++)
            {
                bot.Atacar(megaMan);
            }

            Assert.AreEqual("Nome:Mega Man, Vida:4, Ataque:12, Defesa:3", megaMan.ToString());
        }
        [TestMethod]
        public void MegamanEhAtacadoPorRushENaoAconteceNada()
        {
            MegaMan megaMan = new MegaMan();
            Rush rush = new Rush();

            rush.Atacar(megaMan);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:6, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegamanComChipNivel1()
        {
            MegaMan megaMan = new MegaMan(Chip.Nivel1);            

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:5, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegamanComChipNivel3()
        {
            MegaMan megaMan = new MegaMan(Chip.Nivel3);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:8, Defesa:1", megaMan.ToString());
        }
    }
}
