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
            MegaMan megaman = new MegaMan();
            ProtoMan protoman = new ProtoMan();

            
            for (int i = 0; i < 31; i++)
            {
                megaman.Atacar(protoman);
            }
            
            Assert.AreEqual("Nome:Proto Man, Vida:-4, Ataque:7, Defesa:2", protoman.ToString());
        }
        [TestMethod]
        public void ProtoManAtacaMegaManAteRecerberBonusMais3EMorre()
        {
            MegaMan megaman = new MegaMan();
            ProtoMan protoman = new ProtoMan();


            for (int i = 0; i < 15 ; i++)
            {
                protoman.Atacar(megaman);
            }

            for (int i = 0; i < 18 ; i++)
            {
                megaman.Atacar(protoman);
            }

            Assert.AreEqual("Nome:Proto Man, Vida:-1, Ataque:7, Defesa:2", protoman.ToString());
        }
    }
}
