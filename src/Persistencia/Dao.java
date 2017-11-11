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
public abstract class Dao implements iDao {
    private Estrategia tipoImplementacao;

    public Dao(Estrategia tipoImplementacao) {
        this.tipoImplementacao = tipoImplementacao;
    }

    public Estrategia getTipoImplementacao() {
        return tipoImplementacao;
    }

    public void setTipoImplementacao(Estrategia tipoImplementacao) {
        this.tipoImplementacao = tipoImplementacao;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Object> listarTudo() throws DaoException {
        return tipoImplementacao.listarTudo() ;
    }
    
    @Override
    public void adicionar(Object o) throws DaoException {
        tipoImplementacao.adicionar(o);
    }
    
    @Override
    public void remover(Object o) throws DaoException {
        tipoImplementacao.remover(o);
    }
    
    @Override
    public void atualizar(Object o) throws DaoException {
        tipoImplementacao.atualizar(o);
    }
    
    @Override
    public Object buscarPeloNumero(long id) throws DaoException {
        return tipoImplementacao.buscarPeloNumero(id);
    }
    
    @Override
    public Object buscarPorString(String nome) throws DaoException {
        return tipoImplementacao.buscarPorString(nome);
    }
    
    @Override
    public Object buscarPorString(String agencia, String conta) throws DaoException {
        return tipoImplementacao.buscarPorString(agencia,conta);
    }
    
}
