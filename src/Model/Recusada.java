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
public class Recusada extends Estado {

    public Recusada() {
        status="Recusada";
    }
    
    @Override
    public String tratamento() {
        return "Transação Recusada";
    }
    
}
