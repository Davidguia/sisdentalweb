/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.DAO;


import br.ufmt.ic.paw2.entities.Dentista;
import br.ufmt.paw2.model.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author DavidFrancisco
 */
public class DentistaDAO {
    
     public List<Dentista> getListDentista(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List listaDentista = em.createQuery("from Dentista a ORDER BY nome ASC").getResultList();
        em.getTransaction().commit();
        return listaDentista;
    }
    
   public void gravar(final Dentista dentista) {
        
        Dentista merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((dentista != null) && (dentista.getId() > 0)) {
            merge = (Dentista)em.merge(dentista);
            em.persist(merge);
        }            
        
        else
            em.persist(dentista);
                
        em.getTransaction().commit();

    }
    
    public void excluir(final Dentista dentista) {
        
        Dentista merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((dentista != null) && (dentista.getId() > 0)) {
            merge = (Dentista)em.merge(dentista);
            em.remove(merge);
        }
                
        em.getTransaction().commit();

    }
        
    
    
}
