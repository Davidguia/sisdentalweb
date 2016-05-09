/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.beans;

import br.ufmt.ic.paw2.DAO.DentistaDAO;
import br.ufmt.ic.paw2.entities.Dentista;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DavidFrancisco
 */
@ManagedBean
@RequestScoped
public class DentistaBean {
    private Dentista dentistaSelecionado;
    private List<Dentista> listaDentista;
    /**
     * Creates a new instance of DentistaBean
     */
    public DentistaBean() {
        dentistaSelecionado = new Dentista();
    }

    public Dentista getDentistaSelecionado() {
        return dentistaSelecionado;
    }
    public String selecionarDentista(Dentista dentista){
        this.dentistaSelecionado = dentista;
        return "editaDentista";
    }

    public void setDentistaSelecionado(Dentista dentistaSelecionado) {
        this.dentistaSelecionado = dentistaSelecionado;
    }

    public List<Dentista> getListaDentista() {
        DentistaDAO dao = new DentistaDAO();
        listaDentista = dao.getListDentista();
        return listaDentista;
    }

    public void setListaDentista(List<Dentista> listaDentista) {
        this.listaDentista = listaDentista;
    }
    public void gravar() {
        DentistaDAO dao = new DentistaDAO();
        dao.gravar(this.dentistaSelecionado);
    }
    
    public void excluir() {
        DentistaDAO dao = new DentistaDAO();
        dao.excluir(dentistaSelecionado);
    }
    
}
