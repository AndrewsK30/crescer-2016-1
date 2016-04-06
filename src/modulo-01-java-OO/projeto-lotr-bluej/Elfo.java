public class Elfo {
    private String nome;
    private int experiencia=0, flechas = 42;
    public Elfo(String nome, int flechas){
        // inicializa variáveis de instância
       this.nome = nome;
       this.flechas=flechas;
    }    
     //Exercício 3-E a resposta para tudo é...
    public Elfo(String nome){
       this.nome = nome;
    }   
    public String getNome(){
       return nome;
    }
    public int getFlechas(){
       return flechas;
    }
    public String toString(){
       return this.nome+" possui "+ this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia++;
        this.flechas--;
        dwarf.perderVida();
    }
}