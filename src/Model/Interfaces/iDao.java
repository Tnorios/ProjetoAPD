/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Persistencia.DaoException;
import java.util.List;

/**
 *
 * @author 31686559
 */
public interface iDao {
    List<Object> listarTudo() throws DaoException;
    
    void adicionar(Object o) throws DaoException;
    
    void remover(Object o) throws DaoException;
    
    void atualizar(Object o) throws DaoException;
    
    Object buscarPeloNumero(long id) throws DaoException;

    public String getBanco(String login);

    public String getSenha(String login);

    public String getConta(String login);

    public int getID(String login);

    public String getNome(String login);

}
