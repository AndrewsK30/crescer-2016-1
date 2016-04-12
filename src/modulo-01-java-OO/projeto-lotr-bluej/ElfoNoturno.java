public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno (String nome, int flechas){        
       super(nome ,flechas);          
    }    
     
    public ElfoNoturno(String nome){
       super(nome);          
    }    
   /*Caso o elfo perca 5% da vida ele nunca morrera, por exemplo se ele tiver 1 de vida ele perdera
    * 0.05 e dps 5% de 0.95 e assim por diante.
    * 
    */
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia+=3;
        this.flechas--;
        this.perdeVidaFlechada();
        dwarf.perderVida();
    }
    
    private void perdeVidaFlechada(){
        this.vida -= vida*0.05;
        if(this.vida<1) this.status=Status.MORTO;
    }
}