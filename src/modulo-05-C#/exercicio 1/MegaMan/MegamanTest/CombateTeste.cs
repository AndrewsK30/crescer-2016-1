using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaManWorld;

namespace MegamanTest
{
    [TestClass]
    public class CombateTeste
    {
        [TestMethod]
        public void MegaManAtacaProtomanAteMorrer2vezes()
        {
            MegaMan megaMan = new MegaMan();
            ProtoMan protoMan = new ProtoMan();

            
            for (int i = 0; i < 31; i++)
            {
                megaMan.Atacar(protoMan);
            }
            
            Assert.AreEqual("Nome:Proto Man, Vida:-4, Ataque:7, Defesa:2", protoMan.ToString());
        }
        [TestMethod]
        public void ProtoManAtacaMegaManAteRecerberBonusMais3EMorre()
        {
            MegaMan megaMan = new MegaMan();
            ProtoMan protoMan = new ProtoMan();


            for (int i = 0; i < 15 ; i++)
            {
                protoMan.Atacar(megaMan);
            }

            for (int i = 0; i < 18 ; i++)
            {
                megaMan.Atacar(protoMan);
            }

            Assert.AreEqual("Nome:Proto Man, Vida:-1, Ataque:7, Defesa:2", protoMan.ToString());
        } 
    }
}
