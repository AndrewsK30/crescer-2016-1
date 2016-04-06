import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void verificaVida(){
        Dwarf dwarf=new Dwarf("dwarf");
        assertEquals(110,dwarf.getVida());
    } 
    @Test
    public void verificaNome(){
        Dwarf dwarf=new Dwarf("dwarf");
        assertEquals("dwarf",dwarf.getNome());
    } 
    @Test
    public void perdeVida(){
        Dwarf dwarf=new Dwarf("dwarf");
        dwarf.perderVida();
        assertEquals(100,dwarf.getVida());
    }
}
