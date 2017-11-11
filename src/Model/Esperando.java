/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 31686559
 */
public class Esperando extends Estado {

    public Esperando() {
        status="Esperando";
    }
    
    @Override
    public String tratamento() {
        return "Transação em Espera";
    }
    
}
