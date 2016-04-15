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
}
