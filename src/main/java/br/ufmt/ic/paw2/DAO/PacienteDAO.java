/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.DAO;

import br.ufmt.ic.paw2.entities.Paciente;
import br.ufmt.paw2.model.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author DavidFrancisco
 */
public class PacienteDAO {
    
    public List<Paciente> getListPaciente(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List listaPaciente = em.createQuery("from Paciente a ORDER BY nome ASC").getResultList();
        em.getTransaction().commit();
        return listaPaciente;
    }
    
   public void gravar(final Paciente paciente) {
        
        Paciente merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((paciente != null) && (paciente.getId() > 0)) {
            merge = (Paciente)em.merge(paciente);
            em.persist(merge);
        }            
        
        else
            em.persist(paciente);
                
        em.getTransaction().commit();

    }
    
    public void excluir(final Paciente paciente) {
        
        Paciente merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((paciente != null) && (paciente.getId() > 0)) {
            merge = (Paciente)em.merge(paciente);
            em.remove(merge);
        }
                
        em.getTransaction().commit();

    }
        
    
    
}
