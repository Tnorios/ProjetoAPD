/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.iTransfere;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31686559
 */
public class Lote {
    private List<registroTransacao> transacoes;
    private iTransfere gateway;

    public Lote() {
        this.transacoes = new ArrayList<>();
    }
    public void transferir(){
        gateway.transferir(validar());
    }
    public List<registroTransacao> validar(){
        List<registroTransacao> validas = new ArrayList<>();
        for(registroTransacao r:transacoes){
            if(r.validar()){
                validas.add(r);
            }
        }
        return validas;
    }
   
}
