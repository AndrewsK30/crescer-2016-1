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
       assertTrue(exercito.getOrdemDoUltimoAtaque().size() == 2);
   }
}
