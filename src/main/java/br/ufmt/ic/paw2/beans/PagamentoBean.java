/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.beans;

import br.ufmt.ic.paw2.DAO.PagamentoDAO;
import br.ufmt.ic.paw2.entities.Pagamento;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author DavidFrancisco
 */
@ManagedBean
@RequestScoped
public class PagamentoBean {

     private Pagamento pagamentoSelecionado;
    private List<Pagamento> listaPagamento;

    /**
     * Creates a new instance of PacienteBean
     */
    public PagamentoBean() {
        pagamentoSelecionado = new Pagamento();
    }

    public Pagamento getPagamentoSelecionado() {
        return pagamentoSelecionado;
    }
    public String selecionarPaciente(Pagamento pagamento){
        this.pagamentoSelecionado = pagamento;
        return "editaPagamento";
    }

    public void setPacienteSelecionado(Pagamento pagamentoSelecionado) {
        this.pagamentoSelecionado = pagamentoSelecionado;
    }

    public List<Pagamento> getListaPagamento() {
        PagamentoDAO dao = new PagamentoDAO();
        listaPagamento = dao.getListPagamento();
        return listaPagamento;
    }

    public void setListaPagamento(List<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }
    
    public void gravar() {
        PagamentoDAO dao = new PagamentoDAO();
        dao.gravar(this.pagamentoSelecionado);
    }
    
    public void excluir() {
        PagamentoDAO dao = new PagamentoDAO();
        dao.excluir(pagamentoSelecionado);
    }
    
    
}
