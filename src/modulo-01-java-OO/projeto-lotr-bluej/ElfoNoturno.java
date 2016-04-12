public class ElfoNoturno extends Elfo{
   public ElfoNoturno(String nome){
      super(nome);          
   }    
   /*Caso o elfo perca 5% da vida ele nunca morrera, por exemplo se ele tiver 1 de vida ele perdera
    * 0.05 e dps 5% de 0.95 e assim por diante.
    * 
    */  
   public void atirarFlecha(Dwarf dwarf){
       super.atirarFlecha(dwarf);
       this.experiencia += 2; 
       this.vida *= 0.95;
       if(this.vida<1) this.status=Status.MORTO;
   }
}