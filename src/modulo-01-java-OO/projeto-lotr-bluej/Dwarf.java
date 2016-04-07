public class Dwarf {
    private String nome;
    private int vida=110;
    private Status status = Status.VIVO;
   public Dwarf(String nome){   
        this.vida=110;
        this.nome = nome; 
   }         
   public void perderVida(){
       this.vida-=10;
       if(vida==0)
        this.status=Status.MORTO;    
   }
   public void setName(String nome){
        this.nome = nome;  
   }
   public String getNome(){
       return nome;
   }
    public Status getStatus(){
       return status;
   }
   public int getVida(){
       return vida;
    }
 }