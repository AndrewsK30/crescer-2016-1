import java.util.*;
public class Estrategia50Por50 implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves){
       exercito.agruparPorStatus();
       ArrayList<Elfo> pelotao = exercito.buscar(Status.VIVO);
       int tamanhoExercitoElfos=pelotao.size();
       if(dwarves.size()==0 || tamanhoExercitoElfos==0 || naoAhMesmaProporcao(pelotao))
            return;
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
               colocaNoturnoPosArray+=2;
           }else{
               ordenaElfos.set(colocaVerdePosArray,elfo);
               colocaVerdePosArray+=2;
           }
       }
           
       for(Elfo elfo : ordenaElfos){
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
            ordemDeAtaque.add(elfo);
       }      
       
   }
   private boolean naoAhMesmaProporcao(ArrayList<Elfo> arrayElfos){
    int noturnos=0,verdes=0;
    for(Elfo elfo:arrayElfos){
        if(elfo instanceof ElfoVerde){
            verdes++;
        }else{
            noturnos++;
        }    
    }
    return  verdes!=noturnos;
   }
}
