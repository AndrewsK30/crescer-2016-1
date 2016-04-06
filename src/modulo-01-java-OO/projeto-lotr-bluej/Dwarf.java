public class Dwarf {
    private String nome;
    private int vida=110;
   public Dwarf(String nome){   
        this.vida=110;
        this.nome = nome; 
   }         
   public void perderVida(){
        this.vida-=10;
   }
   public void setName(String nome){
        this.nome = nome;  
   }
   public String getNome(){
       return nome;
   }
 }