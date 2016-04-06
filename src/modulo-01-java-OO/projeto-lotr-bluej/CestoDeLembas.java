public class CestoDeLembas{
    private int quantidadeLemdas;
    public CestoDeLembas(int quantidadeLemdas){
        this.quantidadeLemdas=quantidadeLemdas;    
    }
    public boolean podeDividirEmPares() {
        //Verificação de paes, de modo que seja dividido em pares
        return quantidadeLemdas>=1 && quantidadeLemdas<=100 && quantidadeLemdas%2==0 && quantidadeLemdas>2 ;
        //"terneiro"
        //return podeDividir ? true:false;
    }
}
