import java.util.*;
public class Estrategia30CentoNoturno implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves){
       exercito.agruparPorStatus();
       ArrayList<Elfo> pelotao = exercito.buscar(Status.VIVO);
       if(dwarves.size()==0 || pelotao.size()==0)return;
       int totalElfos = pelotao.size(),
           numDwarfs = dwarves.size(),        
           ataquesNoturnos,
           maxAtqueNoturnos=0;
       boolean ehNoturno;
       Elfo elfoAtualDoAtaque = null;
           
       ataquesNoturnos=(int)(totalElfos*0.3*numDwarfs);
       for(int i=0;i<totalElfos;i++ ){
           elfoAtualDoAtaque =  pelotao.get(i);
           ehNoturno=elfoAtualDoAtaque instanceof ElfoNoturno;
           if(ehNoturno && maxAtqueNoturnos == ataquesNoturnos)continue;
           ordemDeAtaque.add(elfoAtualDoAtaque);
           for(Dwarf dwarf : dwarves){
               if(ehNoturno && maxAtqueNoturnos == ataquesNoturnos)break;
               elfoAtualDoAtaque.atirarFlecha(dwarf);
               if(ehNoturno)maxAtqueNoturnos++;               
           }           
       }
   }
}
