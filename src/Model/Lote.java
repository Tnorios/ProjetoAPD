/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.iTransfere;
import Persistencia.DaoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31686559
 */

public class Lote {

    private List<RegistroTransacao> transacoes;
    private iTransfere gateway;

    public Lote() {
        this.transacoes = new ArrayList<>();
        gateway = Gateway.getInstance();
    }

    public void setTransacao(RegistroTransacao rt,String usuario, String senha, String hostname, int porta, String banco) throws DaoException {
        rt.conectar(usuario, senha, hostname, porta, banco);
        transacoes.add(rt);
    }

    public List<RegistroTransacao> transferir() {
        gateway.transferir(validar());
        return transacoes;
    }

    public List<RegistroTransacao> validar() {
        List<RegistroTransacao> validas = new ArrayList<>();
        for (RegistroTransacao r : transacoes) {
            if (r.validar(r)) {
                validas.add(r);
            }
        }
        return validas;
    }

    public int setTransacaoUnica(RegistroTransacao r, String usuario, String senha, String hostname, int porta, String banco) throws DaoException {
        r.conectar(usuario, senha, hostname, porta, banco);
        transacoes.add(r);
        return transacoes.indexOf(r);
    }

}
