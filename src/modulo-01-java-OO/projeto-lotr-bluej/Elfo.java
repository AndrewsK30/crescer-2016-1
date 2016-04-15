public class Elfo extends Raca{
    protected int flechas = 42;  
    protected static int contador=0;
    private EstrategiaDeAtaque estrategia = new Estrategia30CentoNoturno();
    public Elfo(String nome){
       super(nome);
       this.vida=100;
       this.contador++;
    }   
    public Elfo(String nome, int flechas){
        // inicializa variáveis de instância
       this(nome);
       this.flechas=flechas;       
    }    
     //Exercício 3-E a resposta para tudo é...  
    public int getFlechas(){
       return flechas;
    }
    
    public String toString(){
       boolean flechaNoSingular = Math.abs(this.flechas) == 1;
       boolean experienciaNoSingular = Math.abs(this.experiencia) == 1;
       
       return String.format("%s possui %d %s e %d %s de experiência.",
       this.nome,
       this.flechas,
       flechaNoSingular ? "flecha" : "flechas",
       this.experiencia,
       experienciaNoSingular ? "nível" : "níveis");
    }
    // "Destrutor" http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#finalize%28%29
    protected void finalize() throws Throwable {
       Elfo.contador--;
       super.finalize();
    }   
    
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia++;
        this.flechas--;
        dwarf.perderVida();
    }   
    
    public void tentarSorte(){
    
    }
}