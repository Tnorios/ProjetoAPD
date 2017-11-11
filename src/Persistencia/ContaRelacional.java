/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Conta;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31686559
 */
public class ContaRelacional extends Estrategia {

    private PreparedStatement stmObterTodos;
    private PreparedStatement stmInserir;
    private PreparedStatement stmApagar;
    private PreparedStatement stmAtualizar;
    private PreparedStatement stmObterConta;

    public ContaRelacional(String usuario, String senha, String ip, int porta, String banco) throws DaoException {
        super(usuario, senha, ip, porta, banco);
        Connection connection = conexao.getConnection();
        String sql = "";

        try {
            sql = "SELECT agencia nro_conta, saldo, usuario FROM contas ORDER BY nro_conta";
            stmObterTodos = connection.prepareStatement(sql);
            sql = "INSERT INTO contas VALUES (?,?,?,?)";
            stmInserir = connection.prepareStatement(sql);
            sql = "DELETE FROM contas WHERE nro_conta=? AND WHERE agencia = ?";
            stmApagar = connection.prepareStatement(sql);
            sql = "UPDATE contas SET saldo=? WHERE nro_conta=? AND WHERE agencia = ?";
            stmAtualizar = connection.prepareStatement(sql);
            sql = "SELECT agencia, nro_conta, saldo FROM contas WHERE nro_conta=? AND WHERE agencia = ?";
            stmObterConta = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + sql);
        }

    }

    @Override
    public List<Object> listarTudo() throws DaoException {
        List<Object> contas = new ArrayList<>();
        try {
            ResultSet resultados = stmObterTodos.executeQuery();
            while (resultados.next()) {
                Conta c new Conta(resultados.getString("agencia"),
                        resultados.getString("nro_conta"),
                        resultados.getString("usuario"),
                        resultados.getBigDecimal("saldo"));
                contas.add(c);
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro ao executar a consulta dos dados");
        }
        return contas;
    }

    @Override
    public void adicionar(Object o) throws DaoException {
        o = (Conta) o;
        int ret = -1;
        try {
            stmInserir.setString(1, o.getAgencia());
            stmInserir.setString(2, o.getNumero());
            stmInserir.setString(2, o.getUsuario);
            stmInserir.setBigDecimal(4, o.getSaldo());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro na operação de inserir nova conta");
        }
    }

    @Override
    public void remover(Object o) throws DaoException {
        Conta conta = (Conta) o;
        int ret = -1;
        try {
            stmApagar.setString(1, o.GetNumero);
            stmApagar.setString(2, o.getAgencia);
            ret = stmApagar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao Apagar");
        }
    }

    @Override
    public void atualizar(Object o) throws DaoException {
        o = (Conta) o;
        int ret = -1;
        try {
            stmAtualizar.setBigDecimal(1, o.getSaldo());
            stmAtualizar.setString(2, o.getNumero());
            stmInserir.setString(3, o.getAgencia());
            ret = stmAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao Atualizar!");
        }
    }
    
    @Override
    public Object buscarPorString(String agencia, String conta ) throws DaoException {
        try {
            stmObterTodos.setString(1, conta);
            stmObterTodos.setString(2, agencia);
            ResultSet resultado = stmObterTodos.executeQuery();
            Conta c new Conta(resultado.getString("agencia"),
                    resultado.getString("nro_conta"),
                    resultado.getBigDecimal("saldo"));

        } catch (SQLException ex) {
            throw new DaoException("Erro ao buscar conta!");
        }
        return c;
    }

}
