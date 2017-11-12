/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Interfaces.iController;
import Model.RegistroTransacao;

/**
 *
 * @author 31686559
 */
public class Controller implements iController {
    @Override
    public String processar(RegistroTransacao r){
        return "Foi";
    }
}
