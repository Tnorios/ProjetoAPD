/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistencia.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31686559
 */
public abstract class ServicoBanco {
    protected String status;

    public String getStatus() {
        return status;
    }
    public RegistroTransacao fluxoDeProcessamento(RegistroTransacao r){
        conexao();
        envioDeDados(r);
        try {
            r.persistir();
        } catch (DaoException ex) {
            Logger.getLogger(ServicoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public abstract void conexao() ;

    public abstract void envioDeDados(RegistroTransacao r);
}
