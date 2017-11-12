/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 *
 * @author 31686559
 */
public class Aplicacao extends Application<Configuracao> {

    public static void main(String[] args)
            throws Exception {
        String[] param = {"server", "config/server_config.yml"};
        new Aplicacao().run(param);
    }

    @Override
    public void run(Configuracao t, Environment e)
            throws Exception {
        final Recurso recurso = new Recurso(t.getUsuario(), t.getSenha(), t.getHostname(), t.getPorta(), t.getBanco());
        e.jersey().register(recurso);
    }
}
