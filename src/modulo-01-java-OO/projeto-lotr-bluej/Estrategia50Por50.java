import java.util.*;
public class Estrategia50Por50 implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves){
       int tamanhoExercitoElfos=pelotao.size();
       if(dwarves.size()==0 || tamanhoExercitoElfos==0)return;
       ArrayList<Elfo> ordenaElfos = new ArrayList<>(tamanhoExercitoElfos);
       for (int i = 0; i < tamanhoExercitoElfos; i++) ordenaElfos.add(null);
       int colocaVerdePosArray=0,
           colocaNoturnoPosArray=0;
       if(pelotao.get(0) instanceof ElfoVerde){
           colocaNoturnoPosArray++;
       }else{ 
           colocaVerdePosArray++;
       }
       for(Elfo elfo : pelotao){           
           if(elfo instanceof ElfoNoturno){
               ordenaElfos.set(colocaNoturnoPosArray,elfo);
               //ordenaElfos.add(setArrayNoturno, elfo);
               colocaNoturnoPosArray++;
           }else{
               ordenaElfos.set(colocaVerdePosArray,elfo);
               colocaVerdePosArray++;
           }
       }
       if(colocaVerdePosArray%2 == 0 && colocaNoturnoPosArray%2 == 0 ||
          colocaVerdePosArray%2 != 0 && colocaNoturnoPosArray%2 != 0) return;       
       for(Elfo elfo : ordenaElfos){
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
            ordemDeAtaque.add(elfo);
       }      
       
   }
}
