public abstract class Raca{
   protected String nome;   
   protected Status status = Status.VIVO;
   protected int experiencia=0;   
   protected Inventario inventario = new Inventario();
   protected double vida;
   
   public Raca(String nome){   
        this.nome = nome;  
   }
   
   public void adicionarItem(Item item){
       inventario.adicionarItem(item);
   }
   
   public void perderItem(Item item){
       inventario.removerItem(item);
   }   
      
   public String getNome(){
       return nome;
   }
   
   public Inventario getInventario(){
       return inventario;
   }
         
   public Status getStatus(){
       return status;
   }  
   
    public int getExp(){
       return experiencia;
   }
   
   public double getVida() {
       return this.vida;
   }
   
   public abstract void tentarSorte();
}
