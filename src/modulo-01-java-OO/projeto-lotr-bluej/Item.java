public class Item{
   private int quantidade; 
   private String descricao;
   
   public Item(int quantidade, String descricao){
       this.quantidade = quantidade;
       this.descricao = descricao;       
   }
   
   public int getQuantidade(){
       return quantidade;
   }
   
   public void plus1000(){
       this.quantidade += 1000;
   }
   
   public String getDescricao(){
       return descricao;
   }
}
