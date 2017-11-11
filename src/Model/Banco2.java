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
public class Banco2 extends ServicoBanco{

    @Override
    public void conexao() {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void envioDeDados(registroTransacao r) {
        switch(r.getEstado().getMetodo()){
            case "Moeda Virtual":
                r.setEstado(new Recusada());
            break;
            case "Transferencia":
                r.setEstado(new Aceita());
            break;
            case "Debito":
                r.setEstado(new Recusada());
            break;
            case "Credito":
                r.setEstado(new Recusada());
            break;
            case "Boleto":
                r.setEstado(new Aceita());
            break;
        }
    }
    
}
