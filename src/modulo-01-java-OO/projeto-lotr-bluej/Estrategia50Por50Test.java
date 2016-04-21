import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia50Por50Test{
   @After
   public void tearDown(){
       System.gc();
   }
   @Test
   public void elfoNoturnoPrimeiro(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde = new ElfoVerde("verde");
       Elfo noturno = new ElfoNoturno("noturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(verde);       
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(0).getNome(),"noturno");
       assertEquals(exercito.getOrdemDoUltimoAtaque().get(1).getNome(),"verde");
   }
   @Test
   public void so1Verde(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde = new ElfoVerde("verde");       
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(verde);             
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void tresVerdes1Noturnos(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde1 = new ElfoVerde("verwdwdde");
       Elfo verde2 = new ElfoVerde("wddw");
       Elfo verde3 = new ElfoVerde("vewdrde");
       Elfo verde4 = new ElfoVerde("vedwwdrde");
       Elfo noturno = new ElfoNoturno("noturno");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void semExercitoElfos(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();     
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());      
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void atacarNada(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde1 = new ElfoVerde("verwdwdde");
       Elfo verde2 = new ElfoVerde("wddw");
       Elfo verde3 = new ElfoVerde("vewdrde");
       Elfo verde4 = new ElfoVerde("vedwwdrde");
       Elfo noturno = new ElfoNoturno("saddw");
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void soNoturno(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo noturno1 = new ElfoNoturno("vsrwdwdde");
       Elfo noturno2 = new ElfoNoturno("wddw");
       Elfo noturno3 = new ElfoNoturno("vewdrde");
       Elfo noturno4 = new ElfoNoturno("vedwwdrde");
       Elfo noturno = new ElfoNoturno("wfa2dw");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(noturno);
       exercito.alistar(noturno1); 
       exercito.alistar(noturno2);
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void soVerde(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Elfo verde1 = new ElfoVerde("vsrwdwdde");
       Elfo verde2 = new ElfoVerde("wddw");
       Elfo verde3 = new ElfoVerde("vewdrde");
       Elfo verde4 = new ElfoVerde("vedwwdrde");
       Elfo verde = new ElfoVerde("verrdeas");
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(verde);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void doisNoturnosMortosEntaoNaoEh50e50(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Dwarf alvoDwarf = new Dwarf("boneco alvo");
       
       Elfo verde1 = new ElfoVerde("aefawef");
       Elfo verde2 = new ElfoVerde("feaw bdsab");
       Elfo verde3 = new ElfoVerde("adbsasb");
       Elfo verde4 = new ElfoVerde("adbsabs");
       Elfo verde5 = new ElfoVerde("sadfasf");
       
       Elfo noturno1 = new ElfoNoturno("haadfvb ");
       Elfo noturno2 = new ElfoNoturno("gasbsavfg");
       Elfo noturno3 = new ElfoNoturno("ahbasb");
       Elfo noturno4 = new ElfoNoturno("asdhragr");
       Elfo noturno5 = new ElfoNoturno("ahasgasg");
       
       for(int i=0;i<91;i++){
           noturno1.atirarFlecha(alvoDwarf);
           noturno2.atirarFlecha(alvoDwarf);
       }
       
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(verde5);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void todosNoturnosMortos(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();
       Dwarf alvoDwarf = new Dwarf("boneco alvo");
       
       Elfo verde1 = new ElfoVerde("vswrwrrwdwdde");
       Elfo verde2 = new ElfoVerde("wddwrw");
       Elfo verde3 = new ElfoVerde("vewwrwrdrde");
       Elfo verde4 = new ElfoVerde("vedwrwwdrde");
       Elfo verde5 = new ElfoVerde("wagwwrwrgag");
       
       Elfo noturno1 = new ElfoNoturno("cawc");
       Elfo noturno2 = new ElfoNoturno("wdwwragdw");
       Elfo noturno3 = new ElfoNoturno("wgarwrgwag");
       Elfo noturno4 = new ElfoNoturno("wfaw");
       Elfo noturno5 = new ElfoNoturno("sawvwffasfw");
       
       for(int i=0;i<91;i++){
           noturno1.atirarFlecha(alvoDwarf);
           noturno2.atirarFlecha(alvoDwarf);
           noturno3.atirarFlecha(alvoDwarf);
           noturno4.atirarFlecha(alvoDwarf);
           noturno5.atirarFlecha(alvoDwarf);
       }
       
       Dwarf dwarf1 = new Dwarf("vwdwe");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("vwsafdwe");
       Dwarf dwarf2 = new Dwarf("vwdasfasfwe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(verde5);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),0);
   }
   @Test
   public void ataqueCompleto(){
       ArrayList<Dwarf> pelotaoDwarf = new  ArrayList<>();   
       
       Elfo verde1 = new ElfoVerde("savav ");
       Elfo verde2 = new ElfoVerde("cfsvrw");
       Elfo verde3 = new ElfoVerde("mjhk");
       Elfo verde4 = new ElfoVerde("mjgf");
       Elfo verde5 = new ElfoVerde("hrhsg");
       
       Elfo noturno1 = new ElfoNoturno("trhyj");
       Elfo noturno2 = new ElfoNoturno("gsfghsh");
       Elfo noturno3 = new ElfoNoturno("hrs");
       Elfo noturno4 = new ElfoNoturno("srhs");
       Elfo noturno5 = new ElfoNoturno("vesgrhsrhrde");     
       
       
       Dwarf dwarf1 = new Dwarf("avsvas");
       Dwarf dwarf4 = new Dwarf("fsf");
       Dwarf dwarf3 = new Dwarf("fdsfde");
       Dwarf dwarf2 = new Dwarf("cefe");
       pelotaoDwarf.add(dwarf1);
       pelotaoDwarf.add(dwarf2);
       pelotaoDwarf.add(dwarf3);
       pelotaoDwarf.add(dwarf4);
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.mudarEstrategia(new Estrategia50Por50());
       exercito.alistar(verde5);
       exercito.alistar(verde1); 
       exercito.alistar(verde2);
       exercito.alistar(verde3);
       exercito.alistar(verde4);
       exercito.alistar(noturno1);
       exercito.alistar(noturno2); 
       exercito.alistar(noturno3);
       exercito.alistar(noturno4);
       exercito.alistar(noturno5);
       exercito.atacar(pelotaoDwarf);
       assertEquals(exercito.getOrdemDoUltimoAtaque().size(),10);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(1)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(2)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(3)instanceof ElfoNoturno);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(4)instanceof ElfoVerde);
       assertTrue(exercito.getOrdemDoUltimoAtaque().get(5)instanceof ElfoNoturno);
   }
}