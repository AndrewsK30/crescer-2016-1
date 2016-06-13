/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Andrews
 */
public class Parcelator {
    public void Parcela(double valor,double taxa,int parcelas,Calendar data){   
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        double PagarPorMes = (valor*(1+taxa/100))/parcelas;
        for(int i=1;i!=parcelas;i++){
           System.out.println(i+". "+format1.format(data.getTime())+" - R$ "+String.valueOf(PagarPorMes));
           data.add(Calendar.MONTH,+1);
        }       
    }
}
