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
            MegaMan megaman = new MegaMan();
            
            Assert.AreEqual("Nome:Mega Man, Vida:100, Ataque:6, Defesa:0", megaman.ToString());
        }
        [TestMethod]
        public void BotEhAtacadoUmaVezPorMegaManEPerde6DeVida()
        {
            MegaMan megaman = new MegaMan();
            Bot bot = new Bot();

            megaman.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:94, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void MegaManEhAtacadoUmaVezPorBotEPerde5DeVida()
        {
            MegaMan megaman = new MegaMan();
            Bot bot = new Bot();

            bot.Atacar(megaman);

            Assert.AreEqual("Nome:Mega Man, Vida:95, Ataque:6, Defesa:0", megaman.ToString());
        }
        [TestMethod]
        public void MegaManEhAtacadoAteSuaVidaChegarIgualA30()
        {
            MegaMan megaman = new MegaMan();
            Bot bot = new Bot();
            for (int i = 0; i < 14; i++)
            {
                bot.Atacar(megaman);
            }
            

            Assert.AreEqual("Nome:Mega Man, Vida:30, Ataque:9, Defesa:0", megaman.ToString());
        }
        [TestMethod]
        public void MegaManAtcaComAvidaAbaixoDe30()
        {
            MegaMan megaman = new MegaMan();
            Bot bot = new Bot();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:91, Ataque:5, Defesa:0", bot.ToString());
        }
    }
}
