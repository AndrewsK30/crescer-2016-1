import java.util.*;
public class  ExercitoDeElfos{
    private HashMap<String, Elfo> exercito = new HashMap<>();  
    private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus = new HashMap<Status, ArrayList<Elfo>>() {
        {
            put(Status.MORTO, new ArrayList<Elfo>());
            put(Status.VIVO, new ArrayList<Elfo>());
        }
    };
    private EstrategiaDeAtaque estrategia = new Estrategia30CentoNoturno();
    
    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            exercito.put(elfo.getNome(), elfo);      
    }
    
    public HashMap<String, Elfo> getExercito() {
        return exercito;
    }
    
    public Elfo buscar(String nome){
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
    
    public ArrayList<Elfo> buscar(Status status){      
        return exercitoPorStatus.get(status);
    }  
    
    public void atacar(ArrayList<Dwarf> alvos) {       
        this.estrategia.atacar(this,
            alvos
        );
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
    
    public void mudarEstrategia(EstrategiaDeAtaque estrategia) {
        this.estrategia = estrategia;
    }
}
