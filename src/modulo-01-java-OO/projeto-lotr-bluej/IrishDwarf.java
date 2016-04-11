public class IrishDwarf extends Dwarf{
   
   public IrishDwarf(String nome, DataTerceiraEra dataNascimento){   
        super(nome, dataNascimento);
   } 
   
   public IrishDwarf(String nome){
       super(nome);
   } 
   
   public void tentarSorte(){
       if(this.getNumeroSorte() == -3333.0 && !inventario.getItens().isEmpty()){
           int max;
           for(Item item : inventario.getItens()){
               max=item.getQuantidade();                         
               item.plusItens(500*(max*max+max));
           }           
        }
    }
}
