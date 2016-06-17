/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author andrews.silva
 */
public class ChatTxt {
    private String dirTxt,
                   nickName;
    BufferedReader bufferReader = null;
    BufferedWriter bufferWriter = null;
    
    public static BufferedReader getReader(String file) throws FileNotFoundException {
       return new BufferedReader(new FileReader(file));
    }
   
    public static BufferedWriter getWrite(String file) throws FileNotFoundException, IOException {
        return new BufferedWriter(new FileWriter(file, true));
    }
    ChatTxt(String dir,String apelido){
        this.dirTxt= dir;
        this.nickName = apelido;        
        startReader();
    }
    private String dataAtual(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return format1.format(cal.getTime());
    }
    public void escreveMensagem(String string){
        try{            
            bufferWriter = ChatTxt.getWrite(dirTxt);
            bufferWriter.write(dataAtual()+" "+nickName+" "+string);
            bufferWriter.newLine();
            bufferWriter.flush();        
        }catch(Exception e){
            System.out.println("Erro ao recuperar linhas de arquivo.Erro: "+e.getMessage());
        }finally{
            try{
                if(bufferWriter != null) 
                    bufferWriter.close();
            }catch(IOException ex){
                System.out.println("Erro ao de IO.Erro: "+ex.getMessage());    
            }
        }
    }
    
    private void startReader(){
        new Thread( new Runnable(){
            @Override
            public void run() {
                try{
                    bufferReader = ChatTxt.getReader(dirTxt);
                    while(true){
                        String readLine = bufferReader.readLine();
                        if(readLine != null){
                            System.out.println(readLine);
                        }
                        Thread.sleep(100l);
                    }
                }catch(Exception e){
                    System.out.println("Erro ao recuperar linhas de arquivo.Erro: "+e.toString());
                    System.out.println(dirTxt);
                }finally{
                    try{
                       if(bufferReader != null) 
                           bufferReader.close();
                    }catch(IOException ex){
                      System.out.println("Erro ao de IO.Erro: "+ex.getMessage());    
                    }

                }

            }

        }).start();     
    }
                   
}
