
package Model;

import Model.Interfaces.iDao;
import Model.Interfaces.iValida;
import Persistencia.Dao;
import Persistencia.DaoException;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RegistroTransacao {

    private String estado;
    private int ID;
    private BigDecimal valor;
    private String data;
    private String acipiente;
    private String solvente;
    private iDao dao;
    private iValida val;
    private String metodo;
    private String banco;

    public RegistroTransacao(String estado, int ID, BigDecimal valor, String data, String acipiente, String solvente, String metodo, String banco) {
        this.estado = estado;
        this.ID = ID;
        this.valor = valor;
        this.data = data;
        this.acipiente = acipiente;
        this.solvente = solvente;
        this.metodo = metodo;
        this.banco = banco;
    }
    
    public RegistroTransacao() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public void setAcipiente(String acipiente) {
        this.acipiente = acipiente;
    }

    public String getSolvente() {
        return solvente;
    }

    public void setSolvente(String solvente) {
        this.solvente = solvente;
    }

    public iDao getDao() {
        return dao;
    }

    public void setDao(iDao dao) {
        this.dao = dao;
    }

    public iValida getVal() {
        return val;
    }

    public void setVal(iValida val) {
        this.val = val;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


    public void conectar(String usuario, String senha, String hostname, int porta, String banco) {
        dao = new Dao(usuario, senha, hostname, porta, banco);
    }

    public void persistir() throws DaoException {
        dao.adicionar(this);
    }

    public boolean validar() {
        return val.validar(this);
    }

}
