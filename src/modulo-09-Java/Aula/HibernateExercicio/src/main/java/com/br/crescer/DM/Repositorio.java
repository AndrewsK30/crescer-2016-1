/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.DM;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Andrews
 */
public class Repositorio<T>{
    private static Session sessao;
    private Transaction transacao;
    private final Class<T> tipo;
    
    public Repositorio(Class<T> type){
        this.tipo = type;
    }
    
    public void insert(Object objeto){
        sessao = HibernateUtil.getSession(); 
        transacao = sessao.beginTransaction();        
        sessao.save(objeto);
        sessao.flush();
        transacao.commit();
        sessao.close();     
    }
     
    public void update(Object objeto){
        sessao = HibernateUtil.getSession(); 
        transacao = sessao.beginTransaction();        
        sessao.update(objeto);
        sessao.flush();
        transacao.commit();
        sessao.close();     
    }
    
     public void deletar(Object objeto){
        sessao = HibernateUtil.getSession(); 
        transacao = sessao.beginTransaction();        
        sessao.delete(objeto);
        sessao.flush();
        transacao.commit();
        sessao.close();     
    }
    
    public List<T> listar(){      
        return HibernateUtil
                .getSession()
                .createCriteria(tipo)
                .list();    
    }
}
