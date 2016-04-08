public class Dwarf {
    private String nome;
    private int vida=110;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
   public Dwarf(String nome, DataTerceiraEra dataNascimento){   
        this.vida=110;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
   } 
   public Dwarf(String nome){   
        this.vida=110;
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
   } 
   public void perderVida(){
       int vidaAposFlechada= this.vida - 10;
       if(vida == 0){
           status = Status.MORTO;
       }       
       if (vida > 0){
           vida = vidaAposFlechada;
       }
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