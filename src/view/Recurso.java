/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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

    private String at1;
    private String at2;

    public Recurso(String at1, String at2) {
        this.at1 = at1;
        this.at2 = at2;
    }

    @POST
    @Path("/pagar")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response processar(RegistroTransacao r) {
        return Response.ok("{funcionou:tudo}").build();
    }
}
