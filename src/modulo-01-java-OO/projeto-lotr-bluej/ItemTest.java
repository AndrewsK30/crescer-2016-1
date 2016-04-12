import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
 @Test
 public void itemsIguais(){
     Item item1 = new Item(1,"Espada");
     Item item2 = new Item(1,"Espada");
     assertTrue(item1.equals(item2));
 }
}