import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class HobbitContadorTest
{
   @Test
   public void qualDiferenca3(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));    
       HobbitContador contador = new HobbitContador();
       assertEquals(840,contador.calcularDiferenca(arrayDePares));
   }
   @Test
    public void qualDiferenca6(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(31, 33)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(3, 4)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(4, 64)));  
       HobbitContador contador = new HobbitContador();
       assertEquals(1032,contador.calcularDiferenca(arrayDePares));
   }
}
