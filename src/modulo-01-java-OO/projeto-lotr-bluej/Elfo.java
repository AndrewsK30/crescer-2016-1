public class Elfo extends Raca{
    protected int flechas = 42;  
    protected int vida = 100;
    public Elfo(String nome, int flechas){
        // inicializa variáveis de instância
       super(nome);
       this.flechas=flechas;       
    }    
     //Exercício 3-E a resposta para tudo é...
    public Elfo(String nome){
       super(nome);     
    }   
    
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
     
    public int getVida(){
       return vida;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia++;
        this.flechas--;
        dwarf.perderVida();
    }
}