/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.paw2.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author DavidFrancisco
 */
public class HibernateUtil {

    private static EntityManagerFactory entityFactory;
    
    public static EntityManager getEntityManager() {

        if (entityFactory == null) {
            entityFactory = Persistence.createEntityManagerFactory("SisDentalWEB");
        }
    
        EntityManager em = entityFactory.createEntityManager();
        return em;     
     
    }

}
