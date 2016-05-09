/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.paw2.beans;

import br.ufmt.ic.paw2.DAO.PacienteDAO;
import br.ufmt.ic.paw2.entities.Paciente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DavidFrancisco
 */
@ManagedBean
@RequestScoped
public class PacienteBean {
    private Paciente pacienteSelecionado;
    private List<Paciente> listaPaciente;

    /**
     * Creates a new instance of PacienteBean
     */
    public PacienteBean() {
        pacienteSelecionado = new Paciente();
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }
    public String selecionarPaciente(Paciente paciente){
        this.pacienteSelecionado = paciente;
        return "editaPaciente";
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    public List<Paciente> getListaPaciente() {
        PacienteDAO dao = new PacienteDAO();
        listaPaciente = dao.getListPaciente();
        return listaPaciente;
    }

    public void setListaPaciente(List<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }
    
    public void gravar() {
        PacienteDAO dao = new PacienteDAO();
        dao.gravar(this.pacienteSelecionado);
    }
    
    public void excluir() {
        PacienteDAO dao = new PacienteDAO();
        dao.excluir(pacienteSelecionado);
    }
    
}
