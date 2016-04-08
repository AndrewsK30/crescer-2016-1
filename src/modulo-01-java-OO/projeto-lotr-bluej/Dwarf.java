public class Dwarf {
    private String nome;
    private int vida=110;
    private int experiencia=0;
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
       double numeroSorte=this.getNumeroSorte();
       if( numeroSorte < 0 ){
           experiencia+=2;
       }else if(numeroSorte >= 0.0 && !(numeroSorte <= 100.0)){
           int vidaAposFlechada= this.vida - 10;
           if(vida == 0){
               status = Status.MORTO;
           }       
           if (vida > 0){
               vida = vidaAposFlechada;
           }
       }
      
      
   }
   public double getNumeroSorte(){
       double retorno = 101.0;
       if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90 ){
            retorno*=-33;
       }else if(!(dataNascimento.ehBissexto())&& (nome == "Seixas" || nome == "Meireles")){
           retorno=(retorno*33)%100;
       }
       return retorno;
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
   public int getExp(){
       return experiencia;
   }
 }