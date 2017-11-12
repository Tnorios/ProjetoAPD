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
    private List<RegistroTransacao> transacoes;
    private iTransfere gateway;

    public Lote() {
        this.transacoes = new ArrayList<>();
    }
    public void transferir(){
        gateway.transferir(validar());
    }
    public List<RegistroTransacao> validar(){
        List<RegistroTransacao> validas = new ArrayList<>();
        for(RegistroTransacao r:transacoes){
            if(r.validar()){
                validas.add(r);
            }
        }
        return validas;
    }
   
}
