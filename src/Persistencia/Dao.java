/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Interfaces.iDao;
import java.util.List;

/**
 *
 * @author 31686559
 */
public class Dao implements iDao {
    private TransacaoRelacional tr;
    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String banco;

    public Dao(String usuario, String senha, String hostname, int porta, String banco) {
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.banco = banco;
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
}
