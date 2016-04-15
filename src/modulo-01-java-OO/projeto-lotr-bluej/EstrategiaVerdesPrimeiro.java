import java.util.*;
public class EstrategiaVerdesPrimeiro implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves){
       if(dwarves.size()==0 || pelotao.size()==0)return;
       for(Elfo elfo: pelotao){
           if(elfo instanceof ElfoVerde){
               podeAtacar(elfo,dwarves);
           }
       }
       for(Elfo elfo: pelotao){
           if(elfo instanceof ElfoNoturno){
               podeAtacar(elfo,dwarves);
           }
       }
   }
   private void podeAtacar(Elfo elfo,ArrayList<Dwarf> dwarves){
      for(Dwarf dwarf : dwarves){
          elfo.atirarFlecha(dwarf);          
      }
      ordemDeAtaque.add(elfo);
   }
}
