/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Exception.DaoException;
import Model.Usuario;
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
public class UsuarioRelacional extends Estrategia {

    private PreparedStatement stmObterTodos;
    private PreparedStatement stmInserir;
    private PreparedStatement stmApagar;
    private PreparedStatement stmAtualizar;
    private PreparedStatement stmObterConta;

    public UsuarioRelacional(String usuario, String senha, String ip, int porta, String banco) throws DaoException {
        super(usuario, senha, ip, porta, banco);
        String sql = "";
        Connection connection = conexao.getConnection();
        try {
            sql = "SELECT usuario, senha FROM usuarios";
            stmObterTodos = connection.prepareStatement(sql);
            sql = "INSERT INTO usuarios VALUES (?,?)";
            stmInserir = connection.prepareStatement(sql);
            sql = "DELETE FROM usuarios WHERE usuario=?";
            stmApagar = connection.prepareStatement(sql);
            sql = "UPDATE funcionarios SET senha=? WHERE usuario=?";
            stmAtualizar = connection.prepareStatement(sql);
            sql = "SELECT usuario, senha FROM usuarios WHERE usuario=?";
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
                Usuario u = new Usuario(resultados.getString("usuario"), resultados.getString("senha"));
                contas.add(u);
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmObterTodos);
        }
        return contas;

    }

    @Override
    public void adicionar(Object o) throws DaoException {
        int ret = -1;
        Usuario u = (Usuario) o;
        try {
            stmInserir.setString(1, u.getUsuario());
            stmInserir.setString(2, u.getSenha());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmInserir);
        }
    }

    @Override
    public void remover(Object o) throws DaoException {
        int ret = -1;
        Usuario u = (Usuario) o;
        try {
            stmApagar.setString(1, u.getUsuario());
            ret = stmApagar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmApagar);
        }
    }

    @Override
    public void atualizar(Object o) throws DaoException {
        int ret = -1;
        try {
            Usuario u = (Usuario) o;
            stmAtualizar.setString(1, u.getUsuario());
            stmAtualizar.setString(2, u.getSenha());
            ret = stmAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Erro ao preparar sentença SQL: " + stmAtualizar);
        }
    }

    public Object buscarPeloUsuario(String usuario) {
        Conta conta = null;
        List<Conta> contas;
        long num;

        contas = obterTodos(true);
        for (int c = 0; c < contas.size(); c++) {
            num = contas.get(c).getNumero();
            if (num == numero) {
                return contas.get(c);
            } else {
                conta = null;
            }
        }
        return null;
    }

    @Override
    public Object buscarPeloNumero(long id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
