/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Interfaces.iDao;
import java.util.List;
import Persistencia.Interfaces.iConexao;
/**
 *
 * @author 31686559
 */
public abstract class Estrategia implements iDao {
    protected final iConexao conexao;
    public Estrategia(String usuario,String senha,String ip,int porta,String banco) {
        conexao = new ConexaoDerby(usuario, senha, ip, porta, banco);
        //conexao = new ConexaoDerby("app", "app", "127.0.0.1", 1527, "sistema_bancario");
    }
    
    @Override
    public abstract List<Object> listarTudo()throws DaoException;
    
    @Override
    public abstract void adicionar(Object o) throws DaoException ;
    
    @Override
    public abstract void remover(Object o) throws DaoException ;
    
    @Override
    public abstract void atualizar(Object o) throws DaoException;
    
    @Override
    public abstract Object buscarPeloNumero(long id) throws DaoException;
    
    @Override
    public abstract Object buscarPorString(String nome) throws DaoException;
    
    @Override
    public abstract Object buscarPorString(String agencia, String conta) throws DaoException;
}
