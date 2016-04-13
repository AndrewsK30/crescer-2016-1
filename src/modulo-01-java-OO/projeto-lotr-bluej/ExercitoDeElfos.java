import java.util.*;
public class  ExercitoDeElfos{
  private HashMap<String, Elfo> exercito = new HashMap<>();
  private HashMap<Status, Elfo> exercitoPorStatus = new HashMap<>();
  public void alistar(Elfo elfo){
      if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
         exercito.put(elfo.getNome(), elfo);      
  }
  
  public Elfo buscar(String nome){
      return exercito.get(nome);
  }
  
  public void agruparPorStatus(){
      for (Elfo elfo : exercito.values()) {
          exercitoPorStatus.put(elfo.getStatus(),elfo);
      }
  }  
  
}
