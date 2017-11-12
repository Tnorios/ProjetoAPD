/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.iDao;
import Persistencia.Dao;
import Persistencia.DaoException;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ellias Matheus
 */
public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String banco;
    private String conta;
    @JsonIgnore
    private int id;
    @JsonIgnore
    private iDao dao;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void autenticar(String usuario, String senha, String hostname, int porta, String banco) throws DaoException {
        dao = new Dao(usuario,senha,hostname,porta,banco);
        if(dao.getSenha(this.login).equals(this.senha)){
            this.banco=dao.getBanco(this.login);
            this.conta=dao.getConta(this.login);
            this.id=dao.getID(this.login);
            this.nome=dao.getNome(this.login);
        }else{
            this.nome="Erro!";
        }
    }
    
}
