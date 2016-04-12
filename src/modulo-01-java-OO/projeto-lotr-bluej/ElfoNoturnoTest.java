import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
   @Test
   public void atirou22FlechadasEMoreu(){
        Elfo legolas = new ElfoNoturno("Legolas",32);
        Dwarf dwarf = new Dwarf("dwarf");        
        for(int i=0;i <20;i++){
        legolas.atirarFlecha(dwarf);
        }
        assertEquals(Status.MORTO,legolas.getStatus());
        assertEquals(0,legolas.getVida());        
   }   
}
