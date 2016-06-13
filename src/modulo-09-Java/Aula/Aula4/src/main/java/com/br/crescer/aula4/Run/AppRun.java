/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.aula4.Run;

import com.br.crescer.aula4.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andrews.silva
 */
public class AppRun {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args){
        
        
        em.getTransaction().begin();        
        Pessoa pessoa = new Pessoa("Gustavo");        
        em.persist(pessoa);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
