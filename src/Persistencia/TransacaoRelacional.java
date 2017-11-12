/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.RegistroTransacao;
import Persistencia.Interfaces.iConexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31686559
 */
public class TransacaoRelacional {

    private PreparedStatement stmObterTodos;
    private PreparedStatement stmInserir;
    private PreparedStatement stmApagar;
    private PreparedStatement stmAtualizar;
    private PreparedStatement stmObterConta;
    private iConexao conexao;

    public TransacaoRelacional(String usuario, String senha, String ip, int porta, String banco) throws DaoException {
        conexao = new ConexaoDerby(usuario, senha, ip, porta, banco);
        Connection connection = conexao.getConnection();
        String sql = "";

        try {
            sql = "SELECT ID estado data solvente acipiente  FROM transferencia ORDER BY ID";
            stmObterTodos = connection.prepareStatement(sql);
            sql = "INSERT INTO transferencia VALUES (?,?,?,?,?,?,?,?)";
            stmInserir = connection.prepareStatement(sql);
            sql = "DELETE FROM transferencia WHERE ID=? ";
            stmApagar = connection.prepareStatement(sql);
            sql = "UPDATE transferencia SET estado=? WHERE ID=?";
            stmAtualizar = connection.prepareStatement(sql);
            sql = "SELECT ID estado data solvente acipiente  FROM transferencia WHERE ID=? ";
            stmObterConta = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + sql);
        }
    }

    public List<Object> listarTudo() throws DaoException {
        List<Object> RegistroTransacao = new ArrayList<>();
        try {
            ResultSet resultados = stmObterTodos.executeQuery();
            while (resultados.next()) {
                RegistroTransacao c = new RegistroTransacao(resultados.getString("estado"),
                        resultados.getInt("ID"),
                        resultados.getBigDecimal("valor"),
                        resultados.getString("data"),
                        resultados.getString("acipiente"),
                        resultados.getString("solvente"),
                        resultados.getString("metodo"),
                        resultados.getString("banco"));
                        
                RegistroTransacao.add(c);
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro ao executar a consulta dos dados");
        }
        return RegistroTransacao;
    }

    public void adicionar(Object o) throws DaoException {
        RegistroTransacao rt = (RegistroTransacao) o;
        int ret = -1;
        try {
            stmInserir.setString(1, rt.getEstado()); // NUN SEI SE ISSO VAI FUNFAR
            stmInserir.setInt(2, rt.getID());
            stmInserir.setBigDecimal(3, rt.getValor());
            stmInserir.setString(4, rt.getData());
            stmInserir.setString(5, rt.getAcipiente());
            stmInserir.setString(6, rt.getSolvente());
            stmInserir.setString(7, rt.getMetodo());
            stmInserir.setString(6, rt.getBanco());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro na operação de inserir nova conta");
        }
    }

    public void remover(Object o) throws DaoException {
        int ret = -1;
        RegistroTransacao rt = (RegistroTransacao) o;
        try {
            stmApagar.setInt(1, rt.getID());
            ret = stmApagar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmApagar);
        }
    }

    public void atualizar(Object o) throws DaoException {
        int ret = -1;
        try {
            RegistroTransacao rt = (RegistroTransacao) o;
            stmAtualizar.setString(1, rt.getEstado());
            stmAtualizar.setInt(2, rt.getID());
            ret = stmAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmAtualizar);
        }
    }

    public Object buscarPeloNumero(long id) throws DaoException{ 
        RegistroTransacao registro = null;
        try {
            stmObterConta.setLong(1, id);
            ResultSet resultados = stmObterConta.executeQuery();
            RegistroTransacao c = new RegistroTransacao(resultados.getString("estado"),
                        resultados.getInt("ID"),
                        resultados.getBigDecimal("valor"),
                        resultados.getString("data"),
                        resultados.getString("acipiente"),
                        resultados.getString("solvente"),
                        resultados.getString("metodo"),
                        resultados.getString("banco"));
            
        } catch (SQLException ex) {
            throw new DaoException("Erro ao executar a consulta dos dados");
        }
        return registro;
    }
    
}
