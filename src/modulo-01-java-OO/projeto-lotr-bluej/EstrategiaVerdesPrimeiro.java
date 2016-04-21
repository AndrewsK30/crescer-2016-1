import java.util.*;
public class EstrategiaVerdesPrimeiro implements EstrategiaDeAtaque{   
   private ArrayList<Elfo> ordemDeAtaque = new  ArrayList<>();
   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemDeAtaque;
   }
   
   public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves){
       exercito.agruparPorStatus();
       ArrayList<Elfo> pelotao = exercito.buscar(Status.VIVO);
       int tamanhoDoPelotao= pelotao.size();
       if(dwarves.size()==0 ||tamanhoDoPelotao==0)return;
       ordenaAtaque(pelotao,tamanhoDoPelotao);
       for(Elfo elfo: pelotao){           
               podeAtacar(elfo,dwarves);
       }       
   }
   private void podeAtacar(Elfo elfo,ArrayList<Dwarf> dwarves){
      for(Dwarf dwarf : dwarves){
          elfo.atirarFlecha(dwarf);          
      }
      ordemDeAtaque.add(elfo);
   }
   private void ordenaAtaque(ArrayList<Elfo> pelotaoAhOrganizar, int tamanho){
      boolean teveTroca = true;
      while(teveTroca){
          teveTroca=false;
          for(int i=0;i<tamanho-1;i++){              
              Elfo elfoAtual=pelotaoAhOrganizar.get(i);
              Elfo elfoDepois=pelotaoAhOrganizar.get(i+1);
              if (elfoAtual instanceof ElfoNoturno && elfoDepois instanceof ElfoVerde) {
                    pelotaoAhOrganizar.set(i, elfoDepois);
                    pelotaoAhOrganizar.set(i + 1, elfoAtual);
                    teveTroca = true;
              }
          }
       }
   }
}
