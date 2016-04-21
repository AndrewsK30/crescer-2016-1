import java.util.ArrayList;

public interface EstrategiaDeAtaque {
   public ArrayList<Elfo> getOrdemDoUltimoAtaque();
   public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves);
} 