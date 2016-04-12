import java.util.*;
public class Dwarf extends Raca{   
   private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
   protected int vida=110;  
   public Dwarf(String nome){   
        super(nome);       
   } 
    
   public Dwarf(String nome, DataTerceiraEra dataNascimento){   
        super(nome);
        this.dataNascimento = dataNascimento;        
   }   
   
   public void tentarSorte(){
       if(this.getNumeroSorte() == -3333.0){
           for(Item item : inventario.getItens()){
               item.plusItens(1000);
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
    
   public int getVida(){
       return vida;
   }
   
   public DataTerceiraEra getDataNascimento(){
       return dataNascimento;
   }  
 }