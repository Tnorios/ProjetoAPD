
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
import javax.ws.rs.FormParam;


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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response autenticar(@FormParam("login") String login,@FormParam("senha") String senha) {
        Usuario u = ctrl.autenticar(login, senha);
        if(u.getNome().equals("Erro!")){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(u).build();
    }
}
