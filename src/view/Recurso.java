/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.Controller;
import Controller.Interfaces.iController;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Model.RegistroTransacao;

/**
 *
 * @author 31686559
 */
@Path("/webservice")
public class Recurso {
    private iController ctrl;
    private String usuario;
    private String senha;
    private String hostname;
    private int porta; 
    private String banco;

    public Recurso(String usuario, String senha, String hostname, int porta, String banco) {
        this.ctrl= new Controller();
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.banco = banco;
    }

    @POST
    @Path("/pagar")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response processar(RegistroTransacao r) {
        return Response.ok(ctrl.processar(r)).build();
    }
}
