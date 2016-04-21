import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia30CentoNoturnoTest
{
   @After
   public void tearDown(){
       System.gc();
   }
   @Test
   public void umNoturnoEUmVerde(){
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
       exercito.alistar(verde);
       exercito.alistar(noturno);       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),2);     
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"noturno");
   }
   @Test
   public void seisNoturnosNoAtaqueESemVerde(){
     ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo noturno2 = new ElfoNoturno("noturno2");
       Elfo noturno5 = new ElfoNoturno("noturno");
       Elfo noturno4 = new ElfoNoturno("noturaano2");
       Elfo noturno6 = new ElfoNoturno("notuaasssasrno");
       Elfo noturno8 = new ElfoNoturno("notasasasurno2");
       Elfo noturno9 = new ElfoNoturno("noasasturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(noturno2);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5); 
       exercito.alistar(noturno6);
       exercito.alistar(noturno8);
       exercito.alistar(noturno9); 
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),2);       
   }
   @Test
   public void seisVerdesNoAtaqueESemNoturnos(){
     ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde2 = new ElfoVerde("noturno2");
       Elfo verde5 = new ElfoVerde("noturno");
       Elfo verde4 = new ElfoVerde("noturaano2");
       Elfo verde6 = new ElfoVerde("notuaasssasrno");
       Elfo verde8 = new ElfoVerde("notasasasurno2");
       Elfo verde9 = new ElfoVerde("noasasturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(verde2);
       exercito.alistar(verde4);
       exercito.alistar(verde5); 
       exercito.alistar(verde6);
       exercito.alistar(verde8);
       exercito.alistar(verde9); 
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),6);       
   }
    @Test
   public void atacarNada(){
     ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde2 = new ElfoVerde("noturno2");
       Elfo verde5 = new ElfoVerde("noturno");
       Elfo verde4 = new ElfoVerde("noturaano2");
       Elfo verde6 = new ElfoVerde("notuaasssasrno");
       Elfo verde8 = new ElfoVerde("notasasasurno2");
       Elfo verde9 = new ElfoVerde("noasasturno");       
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(verde2);
       exercito.alistar(verde4);
       exercito.alistar(verde5); 
       exercito.alistar(verde6);
       exercito.alistar(verde8);
       exercito.alistar(verde9); 
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);       
   }
   @Test
   public void semExercito(){
     ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       
       ExercitoDeElfos exercito = new ExercitoDeElfos();
        
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);       
   }
   @Test
   public void umNoturno(){
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
       
       exercito.alistar(noturno);       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),1);     
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"noturno");
   }
   @Test
   public void umVerde(){
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
       
       exercito.alistar(verde);       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),1);     
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"verde");
   }
    @Test
   public void ataqueEmMassa(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde1 = new ElfoVerde("verde1");
       Elfo verde2 = new ElfoVerde("verde2");
       Elfo verde3 = new ElfoVerde("verde3");
       Elfo verde4 = new ElfoVerde("verde4");
       Elfo verde5 = new ElfoVerde("verde5");
       Elfo verde6 = new ElfoVerde("verde6");
       Elfo verde7 = new ElfoVerde("verde7");
       Elfo verde8 = new ElfoVerde("verde8");
       Elfo verde9 = new ElfoVerde("verde9");
       
       Elfo noturno1 = new ElfoNoturno("noturno1");
       Elfo noturno2 = new ElfoNoturno("noturno2");
       Elfo noturno3 = new ElfoNoturno("noturno3");
       Elfo noturno4 = new ElfoNoturno("noturno4");
       Elfo noturno5 = new ElfoNoturno("noturno5");
       Elfo noturno6 = new ElfoNoturno("noturno6");
       Elfo noturno7 = new ElfoNoturno("noturno7");
      
       
       Dwarf dwarf1 = new Dwarf("gs");
       Dwarf dwarf2 = new Dwarf("gsdhsdh");
       Dwarf dwarf3 = new Dwarf("gshshg");
       Dwarf dwarf4 = new Dwarf("shsehshn");
       Dwarf dwarf5 = new Dwarf("hesgs");
       Dwarf dwarf6 = new Dwarf("ghgsh");
       Dwarf dwarf7 = new Dwarf("egsrhh");
       Dwarf dwarf8 = new Dwarf("gege");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       pelotaoDwarf.add(dwarf5);
       pelotaoDwarf.add(dwarf6);
       pelotaoDwarf.add(dwarf7);
       pelotaoDwarf.add(dwarf8);
       
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       
       exercito.alistar(verde1);
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(verde5);
       exercito.alistar(verde6);
       exercito.alistar(verde7);
       exercito.alistar(verde8);
       exercito.alistar(verde9);
       
       exercito.alistar(noturno1);
       exercito.alistar(noturno2);
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.alistar(noturno6);
       exercito.alistar(noturno7);
      
       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),14);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(4)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(5)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(6) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(7)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(8)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(9)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(10)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(11)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(12)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(13)instanceof ElfoVerde);
   }
   
   
}
