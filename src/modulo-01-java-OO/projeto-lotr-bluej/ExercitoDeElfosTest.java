import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest
{
    @After
    public void tearDown(){
        System.gc();
    }
    @Test
    public void  elfoMortoeUmVivo(){
       Elfo legolasNoturno = new ElfoNoturno("legolas noturno");
       Elfo legolasVerde = new ElfoVerde("legolas noturno");
       Dwarf dwarf = new Dwarf("dwarf"); 
       for(int i=0;i<=90;i++){
            legolasNoturno.atirarFlecha(dwarf);            
       }
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(legolasNoturno);
       exercito.alistar(legolasVerde);
       exercito.agruparPorStatus();
       assertTrue("legolas noturno"==exercito.buscarPorStatus(Status.MORTO).get(0).getNome());
       
    }
}
