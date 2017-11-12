/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.iDao;
import Model.Interfaces.iValida;
import Persistencia.Dao;
import Persistencia.DaoException;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellias Matheus
 */
@XmlRootElement
public class RegistroTransacao {

    private Estado estado;
    private int ID;
    private BigDecimal valor;
    private String data;
    private String acipiente;
    private String solvente;
    private iDao dao;
    private iValida val;

    public RegistroTransacao() {
        estado=new Inicial();
    }

    public RegistroTransacao(String estado, int ID, BigDecimal valor, String data, String acipiente, String solvente) {
        switch (estado) {
            case "Esperando":
                this.estado = new Esperando();
                break;

            case "Aceito":
                this.estado = new Aceita();
                break;

            case "Recusada":
                this.estado = new Recusada();
                break;

            case "Cancelada":
                this.estado = new Cancelada();
                break;

        }
        this.ID = ID;
        this.valor = valor;
        this.data = data;
        this.acipiente = acipiente;
        this.solvente = solvente;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAcipiente() {
        return acipiente;
    }

    public void setAcipiente(String receptor) {
        this.acipiente = receptor;
    }

    public String getSolvente() {
        return solvente;
    }

    public void setSolvente(String Pagante) {
        this.solvente = Pagante;
    }

    public void setEstado(String estado) {
        switch (estado) {
            case "Esperando":
                this.estado = new Esperando();
                break;

            case "Aceito":
                this.estado = new Aceita();
                break;

            case "Recusada":
                this.estado = new Recusada();
                break;

            case "Cancelada":
                this.estado = new Cancelada();
                break;

        }

    }

    boolean validar() {
        return val.validar(this);
    }

    public Estado pegaEstado() {
        return estado; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getEstado(){
        return estado.getStatus();
    }

    void conectar(String usuario, String senha, String hostname, int porta, String banco) {
        dao = new Dao(usuario, senha, hostname, porta, banco);
    }

    void persistir() throws DaoException {
        dao.adicionar(this);
    }

}
