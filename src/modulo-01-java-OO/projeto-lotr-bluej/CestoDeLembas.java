public class CestoDeLembas{
    private int quantidadeLemdas;
    public CestoDeLembas(int quantidadeLemdas){
        this.quantidadeLemdas=quantidadeLemdas;    
    }
    public boolean podeDividirEmPares() {
        if(quantidadeLemdas>=1 && quantidadeLemdas<=100 && (Elfo.numElfos*2)>=quantidadeLemdas && quantidadeLemdas%2==0 && Elfo.numElfos!=0){
           return true; 
        }
        return false;
    }
}
