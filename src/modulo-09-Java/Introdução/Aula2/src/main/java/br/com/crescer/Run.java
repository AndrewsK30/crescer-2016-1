/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.Scanner;

/**
 *
 * @author andrews.silva
 */
public class Run {
    public static void main(String[] args){
        ChatTxt chat = new ChatTxt("//10.0.100.102/cwitmp/carloshenrique/crescer.txt","Andrews");
        while(true){
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        chat.escreveMensagem(nextLine);        
        }
    }
}
