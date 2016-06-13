/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;
import java.util.Scanner;
/**
 *
 * @author andrews.silva
 */
public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Informe o numero:");
        Scanner scanner =null;
        try{
            scanner = new Scanner(System.in);
            System.out.println(scanner.nextInt() % 2 == 0 ? "Par": "Impar");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(scanner!=null){
                scanner.close();
            }
        }
    }    
}
