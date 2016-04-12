import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{
   private final double DELTA = 0.0;
   @Test
   public void atirou22FlechadasEMoreu(){
        Elfo legolas = new ElfoNoturno("Legolas");
        Dwarf dwarf = new Dwarf("dwarf");
        int i=0;        
        while(legolas.getVida()>=1){
            legolas.atirarFlecha(dwarf);
            i++;
        }
        assertEquals(90,i);      
        assertTrue(1>legolas.getVida());        
   }
   @Test
   public void umaFlecha3DeExperiencia() {
       Elfo legolas = new ElfoNoturno("Legolas");
       Dwarf dwarf = new Dwarf("dwarf");
       legolas.atirarFlecha(dwarf);
       assertEquals(3, legolas.getExp());
   }
   @Test
   public void doisFlecha6DeExperiencia() {
       Elfo legolas = new ElfoNoturno("Legolas");
       Dwarf dwarf = new Dwarf("dwarf");
       legolas.atirarFlecha(dwarf);
       legolas.atirarFlecha(dwarf);
       assertEquals(6, legolas.getExp());
   }
   @Test
   public void quandoatirarFlechaPerde5DeVida() {
       Elfo legolas = new ElfoNoturno("Legolas");
       Dwarf dwarf = new Dwarf("dwarf");
       legolas.atirarFlecha(dwarf);
       assertEquals(95, legolas.getVida(), DELTA); 
   }
   @Test
   public void quandoAtirarDuasFlechasPerde9ponto75DeVida() {
       Elfo legolas = new ElfoNoturno("Legolas");
       Dwarf dwarf = new Dwarf("dwarf");
       legolas.atirarFlecha(dwarf);
       legolas.atirarFlecha(dwarf);
       assertEquals(90.25, legolas.getVida(), DELTA); 
   }
   @Test
   public void quandoAtirarTresFlechasPerde14pontos() {
       Elfo legolas = new ElfoNoturno("Legolas");
       Dwarf dwarf = new Dwarf("dwarf");
       legolas.atirarFlecha(dwarf);
       legolas.atirarFlecha(dwarf);
       legolas.atirarFlecha(dwarf);
       assertEquals(85.7375, legolas.getVida(), DELTA); 
    }  
}
