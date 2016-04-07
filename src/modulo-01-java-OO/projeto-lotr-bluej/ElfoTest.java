import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void atira1flecha(){
        Elfo legolas=new Elfo("Legolas",32);
        Dwarf dwarf=new Dwarf("dwarf");
        legolas.atirarFlecha(dwarf);
        assertEquals(100,dwarf.getVida());        
    }
    @Test
    public void verificaFlechas(){
        Elfo legolas=new Elfo("Legolas",32);
        assertEquals(32,legolas.getFlechas());
    } 
    @Test
     public void verificaNome(){
        Elfo legolas=new Elfo("Legolas",32);  
        assertEquals("Legolas",legolas.getNome()); 
    }
    @Test
     public void ElfoStatusNascer(){
        Elfo legolas=new Elfo("Legolas",32); 
        assertEquals("Legolas possui 32 flechas e 0 níveis de experiência.",legolas.toString()); 
    } 
    @Test
     public void ElfoAtiraFlechaGanhaExp(){
        Elfo legolas=new Elfo("Legolas"); 
        Dwarf dwarf=new Dwarf("dwarf");
        legolas.atirarFlecha(dwarf);
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.",legolas.toString()); 
    } 
     @Test
     public void ElfoAtiraFlechaResta1Flecha(){
        Elfo legolas=new Elfo("Legolas",3); 
        Dwarf dwarf=new Dwarf("dwarf");
        legolas.atirarFlecha(dwarf);
        legolas.atirarFlecha(dwarf);
        assertEquals("Legolas possui 1 flecha e 2 níveis de experiência.",legolas.toString()); 
    } 
}
