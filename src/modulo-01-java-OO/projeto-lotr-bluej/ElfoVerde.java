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
       if(item.getDescricao()=="Espada de Aço valiriano" ||
          item.getDescricao()=="Arco e Flecha de Vidro")
          inventario.adicionarItem(item);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        this.experiencia+=2;
        this.flechas--;
        dwarf.perderVida();
    }
}
