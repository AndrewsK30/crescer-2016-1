using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaManWorld;

namespace MegamanTest
{
    [TestClass]
    public class ProtoManTeste
    {
        [TestMethod]
        public void ProtoManTem5DeAtaqueE2DeDefesa()
        {
            ProtoMan protoman = new ProtoMan();

            Assert.AreEqual("Nome:Proto Man, Vida:100, Ataque:5, Defesa:2", protoman.ToString());
        }
        [TestMethod]
        public void BotEhAtacadoUmaVezPorProtoManEPerde5DeVida()
        {
            ProtoMan protoman = new ProtoMan();
            Bot bot = new Bot();

            protoman.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:95, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void ProtoManEhAtacadoUmaVezPorBotEPerde5DeVida()
        {
            ProtoMan protoman = new ProtoMan();
            Bot bot = new Bot();

            bot.Atacar(protoman);

            Assert.AreEqual("Nome:Proto Man, Vida:97, Ataque:5, Defesa:2", protoman.ToString());
        }
        [TestMethod]
        public void ProtoManEhAtacadoAteMorrerEntaoRevive()
        {
            ProtoMan protoman = new ProtoMan();
            Bot bot = new Bot();
            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }

            Assert.AreEqual("Nome:Proto Man, Vida:20, Ataque:7, Defesa:2", protoman.ToString());
        }
        [TestMethod]
        public void ProtoManMorreDuasVezes()
        {
            ProtoMan protoman = new ProtoMan();
            Bot bot = new Bot();
            for (int i = 0; i < 41; i++)
            {
                bot.Atacar(protoman);
            }
            

            Assert.AreEqual("Nome:Proto Man, Vida:-1, Ataque:7, Defesa:2", protoman.ToString());
        }
        [TestMethod]
        public void ProtoManReviveEAtaca()
        {
            ProtoMan protoman = new ProtoMan();
            Bot bot = new Bot();
            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }

            protoman.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:93, Ataque:5, Defesa:0", bot.ToString());
        }
    }
}

