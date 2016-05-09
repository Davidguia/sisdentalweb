/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.DAO;
import br.ufmt.ic.paw2.entities.Pagamento;
import br.ufmt.paw2.model.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author DavidFrancisco
 */
public class PagamentoDAO {
    
    public List<Pagamento> getListPagamento(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List listaPagamento = em.createQuery("from Pagamento a ORDER BY nome ASC").getResultList();
        em.getTransaction().commit();
        return listaPagamento;
    }
    
   public void gravar(final Pagamento pagamento) {
        
        Pagamento merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((pagamento != null) && (pagamento.getId() > 0)) {
            merge = (Pagamento)em.merge(pagamento);
            em.persist(merge);
        }            
        
        else
            em.persist(pagamento);
                
        em.getTransaction().commit();

    }
    
    public void excluir(final Pagamento pagamento) {
        
        Pagamento merge;

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        
        if ((pagamento != null) && (pagamento.getId() > 0)) {
            merge = (Pagamento)em.merge(pagamento);
            em.remove(merge);
        }
                
        em.getTransaction().commit();

    }
        
    
}
