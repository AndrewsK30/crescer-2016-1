using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaManWorld;

namespace MegamanTest
{
    [TestClass]
    public class EquipamentosTeste
    {
        [TestMethod]
        public void BotEquipa1Item()
        {
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();

            bot.EquiparUpgrade(botasDeVelocidade);

            Assert.AreEqual("Nome:Bot, Vida:100, Ataque:6, Defesa:1", bot.ToString());
        }
        [TestMethod]
        public void BotEquipa2Item()
        {
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();

            bot.EquiparUpgrade(botasDeVelocidade);
            bot.EquiparUpgrade(escudoDeEnergia);

            Assert.AreEqual("Nome:Bot, Vida:100, Ataque:6, Defesa:3", bot.ToString());
        }
        [TestMethod]
        public void BotEquipa6ItemMasSoPode3()
        {
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();
            IUpgrade canhaoDePlasma = new CanhaoDePlasma();


            bot.EquiparUpgrade(botasDeVelocidade);
            bot.EquiparUpgrade(escudoDeEnergia);
            bot.EquiparUpgrade(canhaoDePlasma);
            bot.EquiparUpgrade(botasDeVelocidade);
            bot.EquiparUpgrade(escudoDeEnergia);
            bot.EquiparUpgrade(canhaoDePlasma);

            Assert.AreEqual("Nome:Bot, Vida:100, Ataque:8, Defesa:3", bot.ToString());
        }
        
    }
}
