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
public abstract class ServicoBanco {
    protected String status;

    public String getStatus() {
        return status;
    }
    public void fluxoDeProcessamento(RegistroTransacao r){
        conexao();
        envioDeDados(r);
    }

    public abstract void conexao() ;

    public abstract void envioDeDados(RegistroTransacao r);
}
