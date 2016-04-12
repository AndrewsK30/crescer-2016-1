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
        int i=0;        
        while(legolas.getVida()>=1){
            legolas.atirarFlecha(dwarf);
            i++;
        }
        assertEquals(45,i);      
        assertEquals(0,legolas.getVida());        
   }   
}
