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
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2025);
        Dwarf dwarf=new Dwarf("dwarf",meuAniversario);
        dwarf.perderVida();
        assertEquals(100,dwarf.getVida());
    }
     @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf=new Dwarf("Balin");
        assertEquals(Status.VIVO,dwarf.getStatus());
    }
      @Test
    public void TomeiFlechadaEMorri(){
        Dwarf dwarf = new Dwarf("Batman");
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida();      
        assertEquals(Status.MORTO,dwarf.getStatus());
    }
       @Test
    public void perdeuMaisDoQueDevia(){
        Dwarf dwarf=new Dwarf("Robin");
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 

        assertEquals(Status.MORTO,dwarf.getStatus());
        assertEquals(0,dwarf.getVida());
    }  
       @Test
    public void recebiExpPorTomar3Flechada(){
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2016);
        Dwarf dwarf=new Dwarf("dwarf",meuAniversario);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(2,dwarf.getExp());
        assertEquals(90,dwarf.getVida());
    }
       @Test
    public void godMod(){
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2015);
        Dwarf dwarf=new Dwarf("Seixas",meuAniversario);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(110,dwarf.getVida());
        assertEquals(0,dwarf.getExp());
    }
}
