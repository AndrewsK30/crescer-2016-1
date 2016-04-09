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
   @Test
   public void DiferencaParesVazio() {
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       HobbitContador contador = new HobbitContador();
       assertEquals(0, contador.calcularDiferenca(arrayDePares));
   }
   @Test
   public void semDiferenca() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(11, 19)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(99, 37)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5))); 
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
   }    
   @Test
   public void calcularDiferencaComZeroEUm() {
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0))); 
       HobbitContador contador = new HobbitContador();
       assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }     
}