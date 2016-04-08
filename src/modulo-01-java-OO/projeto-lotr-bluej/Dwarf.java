import java.util.*;
public class Dwarf {
   private String nome;
   private int vida=110;
   private int experiencia=0;
   private Status status = Status.VIVO;
   private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
   private Inventario inventario = new Inventario();
   
   public Dwarf(String nome, DataTerceiraEra dataNascimento){   
        this(nome);
        this.dataNascimento = dataNascimento;
   } 
   
   public Dwarf(String nome){   
        this.nome = nome;  
   } 
   
   public void perderVida(){
       double numeroSorte=this.getNumeroSorte();
       if(numeroSorte < 0){
           experiencia += 2;
       }else if(numeroSorte > 100){
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
       }else if(!dataNascimento.ehBissexto() &&
       this.nome!= null && 
       (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
           retorno = ( retorno * 33 ) % 100;
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
   
   public void adicionarItem(Item item){
       inventario.adicionarItem(item);
   }
   
   public void perderItem(Item item){
       inventario.removerItem(item);
   }
   
   public Inventario getInventario(){
       return inventario;
   }
   
   public int getVida(){
       return vida;
   }
   
   public DataTerceiraEra getDataNascimento(){
       return dataNascimento;
   }
   public int getExp(){
       return experiencia;
   }
 }