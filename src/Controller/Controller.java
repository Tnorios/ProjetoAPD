/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Interfaces.iController;
import Model.Lote;
import Model.RegistroTransacao;
import Persistencia.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31686559
 */
public class Controller implements iController {
    private Lote lote;
    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String banco;

    public Controller(String usuario, String senha, String hostname, int porta, String banco) {
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.banco = banco;
        lote = new Lote();
    }

    @Override
    public RegistroTransacao processar(RegistroTransacao r){
        int id;
        try {
            id = lote.setTransacaoUnica(r, usuario, senha, hostname, porta, banco);
            return lote.transferir().get(id);
        } catch (DaoException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
