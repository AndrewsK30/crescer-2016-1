import java.util.*;
public class HobbitContador{
  public int calcularDiferenca (ArrayList<ArrayList<Integer>>  array){
      int res=0,mmc,a,b;
      for(ArrayList<Integer> auxArray : array){
        a=mmc=auxArray.get(0);
        b=auxArray.get(1);
        if(!(a==0|| b==0)){
          while ((mmc%a!=0)||(mmc%b!=0)) mmc++;
          res += a*b-mmc;
        }
      }
      return res;
  }
  /*1-Uso desnecessário de arrayList--->subtitui por um int.
   * 2-Uso de for com inicio em 1--->uso do i= ao numero para melhor uso do for.
   * 3-Uso de break e atribuição a variavel maiorMutiplo.
   */
  public int obterMaiorMultiploDeTresAte(int numero) {
      int maiorMultiplo=0;    
      for (int i = numero; i >= 0; i--) {
          if (i % 3 == 0) {
              maiorMultiplo=i;
              break;
          }
      }    
      return maiorMultiplo;
  }
  public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
      ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));    
      for (int i = 1; i <= numero; i++) {
          if (i % 3 == 0) multiplos.add(i);          
      }    
      return multiplos;
    }
}
