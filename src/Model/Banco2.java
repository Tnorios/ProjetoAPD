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
    public void envioDeDados(RegistroTransacao r) {
        switch(r.getEstado().getMetodo()){
            case "Moeda Virtual":
                //r.setEstado("Recusada");
                r.setEstado(new Recusada());
            break;
            case "Transferencia":
                //r.setEstado("Aceita");
                r.setEstado(new Aceita());
            break;
            case "Debito":
                //r.setEstado("Recusada");
                r.setEstado(new Recusada());
            break;
            case "Credito":
                //r.setEstado("Aceita");
                r.setEstado(new Aceita());
            break;
            case "Boleto":
                //r.setEstado("Aceita");
                r.setEstado(new Aceita());
            break;
        }
    }
    
}
