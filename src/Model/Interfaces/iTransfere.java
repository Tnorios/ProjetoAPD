/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.RegistroTransacao;
import java.util.List;

/**
 *
 * @author 31686559
 */
public interface iTransfere {

    public List<RegistroTransacao> transferir(List<RegistroTransacao> validar);
    
}
