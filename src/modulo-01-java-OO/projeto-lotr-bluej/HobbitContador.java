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
}
