/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.iRegistroTransacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31686559
 */
public class Responsavel {
    private List<Memento> momentos;
    private iRegistroTransacao transacao;

    public Responsavel(iRegistroTransacao transacao) {
        this.transacao = transacao;
        this.momentos=new ArrayList<>();
    }
    public void GuardarMomento(){
        momentos.add(transacao.criarMemento());
    }
    public void RecuperarMomento(){
        transacao.setMemento(momentos.get(momentos.size()-1));
    }
    
}
