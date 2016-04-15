import java.util.*;
public class Estrategia30CentoNoturno implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves){
       if(dwarves.size()==0 || pelotao.size()==0)return;
       int totalElfos = pelotao.size(),
           numDwarfs = dwarves.size(),        
           ataquesNoturnos,
           aux=0;
       boolean ehNoturno;
       Elfo ElfoAtualDoAtaque = null;
           
       ataquesNoturnos=(int)(totalElfos*0.3*numDwarfs);
       for(int i=0;i<totalElfos;i++ ){
           ElfoAtualDoAtaque =  pelotao.get(i);
           ehNoturno=ElfoAtualDoAtaque instanceof ElfoNoturno;
           if(ehNoturno && aux == ataquesNoturnos)continue;
           ordemDeAtaque.add(ElfoAtualDoAtaque);
           for(Dwarf dwarf : dwarves){
               if(ehNoturno && aux == ataquesNoturnos)break;
               ElfoAtualDoAtaque.atirarFlecha(dwarf);
               if(ehNoturno)aux++;               
           }           
       }
   }
}
