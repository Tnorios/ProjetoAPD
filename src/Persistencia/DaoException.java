/*DAO EXCEPTION
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author gabrieltenorio
 */
public class DaoException extends Exception {
    private String mensagem;

    public DaoException(){
    }

    public DaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
      
   
}
