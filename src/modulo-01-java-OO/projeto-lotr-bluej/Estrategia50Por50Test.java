import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia50Por50Test{
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
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(verde);       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"noturno");
   }
   @Test
   public void tresVerdes1Noturnos(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde1 = new ElfoVerde("verwdwdde");
       Elfo verde2 = new ElfoVerde("wddw");
       Elfo verde3 = new ElfoVerde("vewdrde");
       Elfo verde4 = new ElfoVerde("vedwwdrde");
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
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
}