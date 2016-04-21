import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class EstrategiaVerdesPrimeiroTest{
   @After
   public void tearDown(){
       System.gc();
   }
   @Test
   public void elfoNoturnoPrimeiro(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde = new ElfoVerde("verde");
       Elfo noturno = new ElfoNoturno("noturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(noturno);
       exercito.alistar(verde);       
       exercito.atacar(pelotaoDwarf);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1) instanceof ElfoNoturno);       
   }
   @Test
   public void UmNoturno(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();       
       Elfo noturno = new ElfoNoturno("noturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(noturno);             
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),1);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoNoturno);       
   }
   @Test
   public void UmVerde(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();       
       Elfo verde = new ElfoVerde("verde");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(verde);             
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),1);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);       
   }
   @Test
   public void umElfoVerdeE4Noturno(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde = new ElfoVerde("verde");
       Elfo noturno1 = new ElfoNoturno("notufwfkirno");
       Elfo noturno2= new ElfoNoturno("notwfwfwfwfurno");
       Elfo noturno3 = new ElfoNoturno("notdwdwwfwwfwurno");
       Elfo noturno4 = new ElfoNoturno("notwwwurno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(noturno1);
       exercito.alistar(noturno2);
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(verde);       
       exercito.atacar(pelotaoDwarf);       
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3) instanceof ElfoNoturno);       
   }
   @Test
   public void soNoturno(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo noturno5 = new ElfoNoturno("noturno");
       Elfo noturno1 = new ElfoNoturno("notufwfkirno");
       Elfo noturno2= new ElfoNoturno("notwfwfwfwfurno");
       Elfo noturno3 = new ElfoNoturno("notdwdwwfwwfwurno");
       Elfo noturno4 = new ElfoNoturno("notwwwurno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(noturno1);
       exercito.alistar(noturno2);
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);       
       exercito.atacar(pelotaoDwarf);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(4) instanceof ElfoNoturno);
   }
   @Test
   public void tresVerdes6Noturnos2NoturnosMortos(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Dwarf alvoDwarf = new Dwarf("boneco alvo");
       
       Elfo verde1 = new ElfoVerde("fgas");
       Elfo verde2 = new ElfoVerde("fefa");
       Elfo verde3 = new ElfoVerde("ewe");
      
       Elfo noturno1 = new ElfoNoturno("erfa ");
       Elfo noturno2 = new ElfoNoturno("wega");
       Elfo noturno3 = new ElfoNoturno("fefs");
       Elfo noturno4 = new ElfoNoturno("fase");
       Elfo noturno5 = new ElfoNoturno("cadr");
       
       for(int i=0;i<91;i++){
           noturno1.atirarFlecha(alvoDwarf);
           noturno2.atirarFlecha(alvoDwarf);
       }
       
       Dwarf dwarf1 = new Dwarf("sffw");
       Dwarf dwarf4 = new Dwarf("fsc");
       Dwarf dwarf3 = new Dwarf("sade");
       Dwarf dwarf2 = new Dwarf("sdfa");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),6);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(4)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(5)instanceof ElfoNoturno);
   }
   @Test
   public void ataqueNada(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();       
       Elfo verde1 = new ElfoVerde("vswrwrrwdwdde");
       Elfo verde2 = new ElfoVerde("wddwrw");
       Elfo verde3 = new ElfoVerde("vewwrwrdrde");
       Elfo verde4 = new ElfoVerde("vedwrwwdrde");
       Elfo verde5 = new ElfoVerde("wagwwrwrgag");
       
       Elfo noturno1 = new ElfoNoturno("cawc");
       Elfo noturno2 = new ElfoNoturno("wdwwragdw");
       Elfo noturno3 = new ElfoNoturno("wgarwrgwag");
    
      
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       exercito.alistar(verde5);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);

       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void semExercito(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();   
      
       
       Dwarf dwarf1 = new Dwarf("avsvas");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("fdsfde");
       Dwarf dwarf2 = new Dwarf("cefe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
      
       exercito.atacar(pelotaoDwarf);
      assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void ataqueEmMassa(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       
       
       Elfo verde1 = new ElfoVerde("fgas");
       Elfo verde2 = new ElfoVerde("fefa");
       Elfo verde3 = new ElfoVerde("ewe");
       Elfo verde4 = new ElfoVerde("ewfafwe");
       Elfo verde5 = new ElfoVerde("ewfwawe");
       Elfo verde6 = new ElfoVerde("ewdwe");
      
       Elfo noturno1 = new ElfoNoturno("erfa ");
       Elfo noturno2 = new ElfoNoturno("wega");
       Elfo noturno3 = new ElfoNoturno("fefs");
       Elfo noturno4 = new ElfoNoturno("fase");
       Elfo noturno5 = new ElfoNoturno("casafdr");       
       Elfo noturno6 = new ElfoNoturno("csfwadr"); 
      
       Dwarf dwarf1 = new Dwarf("sffw");
       Dwarf dwarf2 = new Dwarf("fsc");
       Dwarf dwarf3 = new Dwarf("sade");
       Dwarf dwarf4 = new Dwarf("sgagdfa");
       Dwarf dwarf5 = new Dwarf("sdgaffa");
       Dwarf dwarf6 = new Dwarf("fsrga");
       Dwarf dwarf7 = new Dwarf("gesgfa");
       
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       pelotaoDwarf.add(dwarf5);
       pelotaoDwarf.add(dwarf6);
       pelotaoDwarf.add(dwarf7);
 
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new EstrategiaVerdesPrimeiro());
       
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(verde5);
       exercito.alistar(verde6);
       
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.alistar(noturno6);
       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),12);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(4)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(5)instanceof ElfoVerde);
       
        assertTrue(exercito.getOrdemDoUltimoAtaque().get(6) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(7)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(8)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(9)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(10)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(11)instanceof ElfoNoturno);
   }
}
