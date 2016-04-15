import java.util.*;
public class Estrategia30CentoNoturno implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> OrdemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return OrdemDeAtaque;
   }
   
   public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves){
       
       int intencoes = 0,
           numDwarfs = dwarves.size(),
           numElfosNoturnos = 0,           
           ataquesNoturnos,
           aux=0;
       boolean ehNoturno;
       Elfo ElfoAtualDoAtaque = null;
           
       for(Elfo elfo : pelotao){
           if(elfo instanceof ElfoNoturno){
               numElfosNoturnos++;
           }else if(!(elfo instanceof ElfoVerde)){
               return;
           }              
           intencoes++;
       }
       intencoes*=numDwarfs;
       ataquesNoturnos=(int)(intencoes*0.3);
       for(int i=0;i<intencoes-ataquesNoturnos;i++ ){
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
