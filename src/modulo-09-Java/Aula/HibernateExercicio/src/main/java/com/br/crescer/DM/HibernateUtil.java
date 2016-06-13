/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.DM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;


/**
 *
 * @author Andrews
 */
public final class HibernateUtil
{
    private  static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    private static final EntityManager em = emf.createEntityManager();
    
    public static Session getSession()
    {
        return em.unwrap(Session.class);
    }
}
