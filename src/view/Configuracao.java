/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 31686559
 */
public class Configuracao extends
        io.dropwizard.Configuration {

    @JsonProperty
    private String usuario;
    @JsonProperty
    private String senha;
    @JsonProperty
    private String hostname;
    @JsonProperty
    private int porta;
    @JsonProperty
    private String banco;

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPorta() {
        return porta;
    }

    public String getBanco() {
        return banco;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


}
