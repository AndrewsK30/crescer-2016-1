import java.util.*;
public class Estrategia30CentoNoturno implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> OrdemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return OrdemDeAtaque;
   }
   
   public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves){
       if(dwarves.size()==0 || pelotao.size()==0)return;
       int totalElfos = 0,
           numDwarfs = dwarves.size(),
           numElfosNoturnos = 0,           
           ataquesNoturnos,
           aux=0;
       boolean ehNoturno;
       Elfo ElfoAtualDoAtaque = null;
           
       for(Elfo elfo : pelotao){
           if(elfo instanceof ElfoNoturno)
               numElfosNoturnos++;           
           totalElfos++;
       }
       ataquesNoturnos=(int)(totalElfos*0.3*numDwarfs);
       for(int i=0;i<totalElfos;i++ ){
           ElfoAtualDoAtaque =  pelotao.get(i);
           ehNoturno=ElfoAtualDoAtaque instanceof ElfoNoturno;
           if(ehNoturno && aux == ataquesNoturnos)continue;
           OrdemDeAtaque.add(ElfoAtualDoAtaque);
           for(Dwarf dwarf : dwarves){
               if(ehNoturno && aux == ataquesNoturnos)break;
               ElfoAtualDoAtaque.atirarFlecha(dwarf);
               if(ehNoturno)aux++;               
           }           
       }
   }
}
