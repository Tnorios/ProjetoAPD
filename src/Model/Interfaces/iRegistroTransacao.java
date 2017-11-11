/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Memento;

/**
 *
 * @author 31686559
 */
public interface iRegistroTransacao {

    public Memento criarMemento();

    public void setMemento(Memento m);
    
}
