/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Interfaces.iDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31686559
 */
public class Dao implements iDao {
    private TransacaoRelacional tr;

    public Dao(String usuario, String senha, String hostname, int porta, String banco) throws DaoException {
        tr = new TransacaoRelacional(usuario, senha, hostname, porta, banco);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Object> listarTudo() throws DaoException {
        return tr.listarTudo() ;
    }
    
    @Override
    public void adicionar(Object o) throws DaoException {
        tr.adicionar(o);
    }
    
    @Override
    public void remover(Object o) throws DaoException {
        tr.remover(o);
    }
    
    @Override
    public void atualizar(Object o) throws DaoException {
        tr.atualizar(o);
    }
    
    @Override
    public Object buscarPeloNumero(long id) throws DaoException {
        return tr.buscarPeloNumero(id);
    }    


    @Override
    public String getBanco(String login) {
        try {
            return tr.getBanco(login);
        } catch (DaoException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getSenha(String login) {
        try {
            return tr.getSenha(login);
        } catch (DaoException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getConta(String login) {
        try {
            return tr.getConta(login);
        } catch (DaoException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public int getID(String login) {
        try {
            return tr.getID(login);
        } catch (DaoException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public String getNome(String login) {
        try {
            return tr.getNome(login);
        } catch (DaoException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Erro!";
    }
}
