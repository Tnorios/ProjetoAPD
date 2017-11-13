
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
import Model.Usuario;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;


@Path("/ibanking")
public class Recurso {
    private iController ctrl;

    public Recurso(String usuario, String senha, String hostname, int porta, String banco) {
        this.ctrl= new Controller(usuario, senha, hostname, porta, banco);
    }

    @POST
    @Path("/pagar")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response processar(RegistroTransacao r) {
        return Response.ok(ctrl.processar(r)).build();
    }

    @POST
    @Path("/autenticar")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response autenticar(Usuario u) {
        Usuario us = ctrl.autenticar(u.getLogin(), u.getSenha());
        if(us.getNome().equals("Erro!")){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(us).build();
    }
    @POST
    @Path("/buscar")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response listar(Usuario u) {
        List<RegistroTransacao> us = ctrl.listar(u.getLogin(), u.getSenha());
        return Response.ok(us).build();
    }
}
