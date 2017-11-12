/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Interfaces.ProcessadorDePagamentos;
import Model.Interfaces.iTransfere;
import Model.Interfaces.iValida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31686559
 */
public class Gateway implements iValida, iTransfere {

    private static Gateway instance = null;

    private Gateway() {

    }

    public static Gateway getInstance() {
        if (instance == null) {
            instance = new Gateway();
        }
        return instance;
    }

    private ProcessadorDePagamentos delegar(RegistroTransacao rt) {
        ProcessadorDePagamentos p = null;
        switch (rt.getMetodo()) {
            case "Moeda Virtual":
                p = new MoedaVirtual(rt.getBanco());
                break;
            case "Transferencia":
                p = new Transferencia(rt.getBanco());
                break;
            case "Debito":
                p = new Debito(rt.getBanco());
                break;
            case "Credito":
                p = new Credito(rt.getBanco());
                break;
            case "Boleto":
                p = new Boleto(rt.getBanco());
                break;

        }
        return p;

    }
    
    @Override
    public boolean validar(RegistroTransacao rt) {
        ProcessadorDePagamentos p = delegar(rt);
        return p.valida(rt);
    }

    @Override
    public List<RegistroTransacao>  transferir(List<RegistroTransacao> validar) {
    List<RegistroTransacao> rt = new ArrayList<>();
    for(RegistroTransacao r : validar){
        ProcessadorDePagamentos p = delegar(r);
        rt.add(p.transferir(r));
    }
     return rt;
    }

}
