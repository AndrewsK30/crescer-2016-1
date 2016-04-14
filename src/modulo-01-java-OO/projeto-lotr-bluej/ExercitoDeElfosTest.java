import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
public class ExercitoDeElfosTest
{
    @After
    public void tearDown(){
        System.gc();
    }
    @Test
    public void  elfoMortoEUmVivo(){
       Elfo legolasNoturno = new ElfoNoturno("legolas noturno");
       Elfo legolasVerde = new ElfoVerde("legolas verde");
       Dwarf dwarf = new Dwarf("dwarf"); 
       for(int i=0;i<=90;i++){
            legolasNoturno.atirarFlecha(dwarf);            
       }
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(legolasNoturno);
       exercito.alistar(legolasVerde);
       exercito.agruparPorStatus();
       assertTrue("legolas noturno"==exercito.buscar(Status.MORTO).get(0).getNome());
       
    }
    @Test
    public void checkSeAlistou() {
        Elfo elfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEspero = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(elfo);
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEspero, obtido);
    }
    @Test
    public void estesElfosNaoPodemSeAlisatr() {
        Elfo legolas = new Elfo("legolas");
        Elfo irin = new Elfo("irin");
        HashMap<String, Elfo> exercitoEspero = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(legolas);
        exercito.alistar(irin);
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEspero, obtido);
    }
    @Test
    public void alistarElfoVerde() {
       Elfo legolas = new ElfoVerde("legolas verde");
       HashMap<String, Elfo> exercitoEspero = new HashMap<>();
       exercitoEspero.put(legolas.getNome(), legolas);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(legolas);
       HashMap<String, Elfo> obtido = exercito.getExercito();
       assertEquals(exercitoEspero, obtido);
    }
    @Test
    public void alistarElfoNoturno() {
       Elfo legolas = new ElfoNoturno("legolas noturno");
       HashMap<String, Elfo> exercitoEspero = new HashMap<>();
       exercitoEspero.put(legolas.getNome(), legolas);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistar(legolas);
       HashMap<String, Elfo> obtido = exercito.getExercito();
       assertEquals(exercitoEspero, obtido);
    }
    @Test
    public void buscaNomeElfo() {
        Elfo legolas = new ElfoNoturno("legolas noturno");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(legolas);
        assertEquals(legolas, exercito.buscar("legolas noturno"));
    }
    @Test
    public void buscaNomeElfoNaoExiste() {
        Elfo elfo = new ElfoNoturno("legolas noturno");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(elfo);
        assertNull(exercito.buscar("Legolas1"));
    }
    @Test
    public void exercitoVazioEBuscaNome() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        assertNull(exercito.buscar("legolas"));
    }
}
