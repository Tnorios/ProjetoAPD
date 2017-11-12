/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Banco1;
import Model.Banco2;
import Model.RegistroTransacao;
import Model.ServicoBanco;

/**
 *
 * @author 31686559
 */
public abstract class ProcessadorDePagamentos {
    protected ServicoBanco s;
    public ProcessadorDePagamentos(String banco){
        switch(banco){
            case "Banco1":
                s = new Banco1();
            break;
            case "Banco2":
                s = new Banco2();
            break;
        }
    }
    public abstract boolean valida (RegistroTransacao rt); 
    public RegistroTransacao transferir (RegistroTransacao rt){
      return s.fluxoDeProcessamento(rt);
    }
    
    
}
