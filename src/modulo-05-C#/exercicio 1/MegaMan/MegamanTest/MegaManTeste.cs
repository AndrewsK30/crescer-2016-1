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
        public void MegaManEhAtacadoAteSuaVidaChegarIgualA25()
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
        public void MegaManSoTemMais3QuandoAtaca()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaMan);
            }
           

            Assert.AreEqual("Nome:Mega Man, Vida:25, Ataque:6, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegaManEquipa1ItemEAtacaBot()
        {
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();

            megaMan.EquiparUpgrade(botasDeVelocidade);

            megaMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:93, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegaManEquipa3ItemEAtacaBot()
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
        public void MegaManEquipa3ItemETemVidaMenorQue30()
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
            megaMan.Atacar(bot);
            Assert.AreEqual("Nome:Bot, Vida:88, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegaManEhAtacadoPorRushENaoAconteceNada()
        {
            MegaMan megaMan = new MegaMan();
            Rush rush = new Rush();

            rush.Atacar(megaMan);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:6, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegaManComChipNivel1()
        {
            MegaMan megaMan = new MegaMan(Chip.Nivel1);            

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:5, Defesa:0", megaMan.ToString());
        }
        [TestMethod]
        public void MegaManComChipNivel3()
        {
            MegaMan megaMan = new MegaMan(Chip.Nivel3);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:8, Defesa:1", megaMan.ToString());
        }
        [TestMethod]
        public void MegamTemDefesaMaiorQueAtaqueDeBot()
        {
            Rush rush = new Rush();
            MegaMan megaMan = new MegaMan();
            Bot bot = new Bot();
            EscudoDeEnergia escudo = new EscudoDeEnergia();
            BotasDeSuperVelocidade botasDeVelocidade = new BotasDeSuperVelocidade();

            rush.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(botasDeVelocidade);

            megaMan.EquiparUpgrade(rush);

            bot.Atacar(megaMan);

            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:11, Defesa:6", megaMan.ToString());
        }
    }
}
