public class Elfo {
    private String nome;
    private int experiencia=0, flechas = 42;
    public static int numElfos=0;
    public Elfo(String nome, int flechas){
        // inicializa variáveis de instância
       this.nome = nome;
       this.flechas=flechas;
       numElfos++;
    }    
     //Exercício 3-E a resposta para tudo é...
    public Elfo(String nome){
       this.nome = nome;
       numElfos++;
    }
    
    public void atirarFlecha(Dwarf Obj) {
        Obj.vida-=10;
        experiencia++;
        flechas--;
    }
}