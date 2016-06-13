package br.com.crescer;

import java.util.SortedMap;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrews.silva
 */
public class ExercicioSeteTres {
    
    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder();  
        SortedMap<String, Estados> map = new TreeMap<String, Estados>();
        for (Estados l : Estados.values()) {
            map.put(l.getNome(), l);
        }

        for(Estados op : map.values()){
            strBuilder.append(op.getNome()+',');        
        }
        strBuilder.deleteCharAt(strBuilder.length()-1);
        System.out.println(strBuilder);
    }

}
