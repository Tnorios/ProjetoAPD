/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Interfaces.iController;
import Model.Lote;
import Model.RegistroTransacao;

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
    public String processar(RegistroTransacao r){
        lote.setTransacao(r, usuario, senha, hostname, porta, banco);
        return "Foi";
    }
}
