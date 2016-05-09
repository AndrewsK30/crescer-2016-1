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
             ProtoMan protoMan = new ProtoMan();

             Assert.AreEqual("Nome:Proto Man, Vida:100, Ataque:5, Defesa:2", protoMan.ToString());
         }
         [TestMethod]
         public void BotEhAtacadoUmaVezPorProtoManEPerde5DeVida()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();

             protoMan.Atacar(bot);

             Assert.AreEqual("Nome:Bot, Vida:95, Ataque:5, Defesa:0", bot.ToString());
         }
         [TestMethod]
         public void ProtoManEhAtacadoUmaVezPorBotEPerde5DeVida()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();

             bot.Atacar(protoMan);

             Assert.AreEqual("Nome:Proto Man, Vida:97, Ataque:5, Defesa:2", protoMan.ToString());
         }
         [TestMethod]
         public void ProtoManEhAtacadoAteMorrerEntaoRevive()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();
             for (int i = 0; i < 34; i++)
             {
                 bot.Atacar(protoMan);
             }

             Assert.AreEqual("Nome:Proto Man, Vida:20, Ataque:7, Defesa:2", protoMan.ToString());
         }
         [TestMethod]
         public void ProtoManMorreDuasVezes()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();
             for (int i = 0; i < 41; i++)
             {
                 bot.Atacar(protoMan);
             }


             Assert.AreEqual("Nome:Proto Man, Vida:-1, Ataque:7, Defesa:2", protoMan.ToString());
         }
         [TestMethod]
         public void ProtoManReviveEAtaca()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();
             for (int i = 0; i < 34; i++)
             {
                 bot.Atacar(protoMan);
             }

             protoMan.Atacar(bot);

             Assert.AreEqual("Nome:Bot, Vida:93, Ataque:5, Defesa:0", bot.ToString());
         }

         [TestMethod]
         public void ProtoManVSMegaman()
         {
             ProtoMan protoMan = new ProtoMan();
             Bot bot = new Bot();
             for (int i = 0; i < 34; i++)
             {
                 bot.Atacar(protoMan);
             }

             protoMan.Atacar(bot);

             Assert.AreEqual("Nome:Bot, Vida:93, Ataque:5, Defesa:0", bot.ToString());
         }
        [TestMethod]
        public void ProtoManEquipa1ItemEAtacaBot()
        {
            ProtoMan protoMan = new ProtoMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();

            protoMan.EquiparUpgrade(botasDeVelocidade);

            protoMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:94, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void ProtoManEquipa3ItemEAtacaBot()
        {
            ProtoMan protoMan = new ProtoMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();
            IUpgrade canhaoDePlasma = new CanhaoDePlasma();


            protoMan.EquiparUpgrade(botasDeVelocidade);
            protoMan.EquiparUpgrade(escudoDeEnergia);
            protoMan.EquiparUpgrade(canhaoDePlasma);

            protoMan.Atacar(bot);

            Assert.AreEqual("Nome:Bot, Vida:92, Ataque:5, Defesa:0", bot.ToString());
        }
        [TestMethod]
        public void ProtoMannEquipa3ItemETemDefesaIqualADanoDoBot()
        {
            ProtoMan protoMan = new ProtoMan();
            Bot bot = new Bot();
            IUpgrade botasDeVelocidade = new BotasDeSuperVelocidade();
            IUpgrade escudoDeEnergia = new EscudoDeEnergia();
            IUpgrade canhaoDePlasma = new CanhaoDePlasma();

            protoMan.EquiparUpgrade(botasDeVelocidade);
            protoMan.EquiparUpgrade(escudoDeEnergia);
            protoMan.EquiparUpgrade(canhaoDePlasma);

            for (int i = 0; i < 48; i++)
            {
                bot.Atacar(protoMan);
            }

            Assert.AreEqual("Nome:Proto Man, Vida:100, Ataque:8, Defesa:5", protoMan.ToString());
        }
    }
}

