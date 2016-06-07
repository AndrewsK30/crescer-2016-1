/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author andrews.silva
 */
public class ExercicioOitoTres {
    public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello World! - " + scanner.nextLine());
        } catch (Exception e) {
            println("erro");
        }
    
    }   
    public void DataAtual(){ 
    System.out.println("Data atual:"+ new Date());
    }
}
