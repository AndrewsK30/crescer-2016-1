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
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"verde");
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
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"verde");
   }
   @Test
   public void soNoturno(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde = new ElfoNoturno("noturno");
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
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoNoturno);
   }
}
