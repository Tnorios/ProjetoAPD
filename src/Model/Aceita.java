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
public class Aceita extends Estado {

    public Aceita() {
        status="Aceita";
    }
    
    @Override
    public String tratamento() {
        return "Transação Aceita";
    }
}
