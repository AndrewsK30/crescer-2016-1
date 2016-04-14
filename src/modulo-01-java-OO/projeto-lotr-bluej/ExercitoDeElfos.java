import java.util.*;
public class  ExercitoDeElfos{
  private HashMap<String, Elfo> exercito = new HashMap<>();  
  private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus = new HashMap<Status, ArrayList<Elfo>>() {
  {
     put(Status.MORTO, new ArrayList<Elfo>());
     put(Status.VIVO, new ArrayList<Elfo>());
  }
  };
  public void alistar(Elfo elfo){
      if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
         exercito.put(elfo.getNome(), elfo);      
  }
  
  public Elfo buscarPorNome(String nome){
      return exercito.get(nome);
  }
  
  public void agruparPorStatus(){
      Status auxStatus;
      for (Elfo elfo : exercito.values()) {
          auxStatus = elfo.getStatus();
          if(!Arrays.asList(exercitoPorStatus.get(auxStatus)).contains(elfo))
             exercitoPorStatus.get(auxStatus).add(elfo);
      }
  }  
  
  public ArrayList<Elfo> buscarPorStatus(Status status){      
      return exercitoPorStatus.get(status);
  }  
}
