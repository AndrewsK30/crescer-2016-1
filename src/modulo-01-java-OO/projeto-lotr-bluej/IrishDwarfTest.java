import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
  @Test
  public void tiveSorte(){     
        DataTerceiraEra nasci = new DataTerceiraEra(1,4,2016);
        IrishDwarf dwarf = new IrishDwarf("dwarf",nasci);
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        for(int i=0;i<5;i++){
            dwarf.perderVida();            
        }
        dwarf.tentarSorte();
        assertEquals(1001,dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(6003,dwarf.getInventario().getItens().get(1).getQuantidade()); 
  }
}
