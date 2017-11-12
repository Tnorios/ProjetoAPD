/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.ProcessadorDePagamentos;


/**
 *
 * @author 31686559
 */
public class Debito extends  ProcessadorDePagamentos{

    public Debito(String banco) {
        super(banco);
    }

    @Override
    public boolean valida(RegistroTransacao rt) {
        return true;
    }
    
}
