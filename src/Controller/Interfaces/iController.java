/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Interfaces;

import Model.RegistroTransacao;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author 31686559
 */
public interface iController {
    RegistroTransacao processar(RegistroTransacao r);
    Usuario autenticar(String login, String senha);

    List<RegistroTransacao> listar(String login, String senha);
}
