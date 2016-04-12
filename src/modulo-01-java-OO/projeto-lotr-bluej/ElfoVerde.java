public class ElfoVerde extends Elfo{
    
    public ElfoVerde (String nome, int flechas){        
       super(nome ,flechas);   
       this.vida = 100;
    }    
     
    public ElfoVerde(String nome){
       super(nome);   
       this.vida = 100;
    }
    
    public void adicionarItem(Item item){
        String nome = item.getDescricao() ;
        
       if(item != null &&
          nome=="Espada de Aço valiriano" ||
          nome=="Arco e Flecha de Vidro") 
          super.adicionarItem(item);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia+=2;
        this.flechas--;
        dwarf.perderVida();
    }
}
