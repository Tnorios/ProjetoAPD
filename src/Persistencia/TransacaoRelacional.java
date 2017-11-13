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
    private PreparedStatement stmGetConta;
    private PreparedStatement stmGetSenha;
    private PreparedStatement stmGetBanco;
    private PreparedStatement stmGetID;
    private PreparedStatement stmGetNome;
    private PreparedStatement stmObterTrans;
    
    private iConexao conexao;

    public TransacaoRelacional(String usuario, String senha, String ip, int porta, String banco) throws DaoException {
        conexao = new ConexaoDerby(usuario, senha, ip, porta, banco);
        Connection connection = conexao.getConnection();
        String sql = "";

        try {
            sql = "SELECT * FROM transferencia ORDER BY ID";
            stmObterTodos = connection.prepareStatement(sql);
            sql = "INSERT INTO transferencia (estado,valor,datat,acipiente,solvente,metodo,banco) VALUES(?,?,?,?,?,?,?)";
            stmInserir = connection.prepareStatement(sql);
            sql = "DELETE FROM transferencia WHERE ID=? ";
            stmApagar = connection.prepareStatement(sql);
            sql = "UPDATE transferencia SET estado=? WHERE ID=?";
            stmAtualizar = connection.prepareStatement(sql);
            sql = "SELECT * FROM transferencia WHERE ID=? ";
            stmObterConta = connection.prepareStatement(sql);
            sql = "SELECT * FROM transferencia WHERE acipiente=? OR solvente=? ";
            stmObterTrans = connection.prepareStatement(sql);
            sql = "SELECT senha FROM usuario WHERE login=? ";
            stmGetSenha = connection.prepareStatement(sql);
            sql = "SELECT conta FROM usuario WHERE login=? ";
            stmGetConta = connection.prepareStatement(sql);
            sql = "SELECT banco FROM usuario WHERE login=? ";
            stmGetBanco = connection.prepareStatement(sql);
            sql = "SELECT id FROM usuario WHERE login=? ";
            stmGetID = connection.prepareStatement(sql);
            sql = "SELECT nome FROM usuario WHERE login=? ";
            stmGetNome = connection.prepareStatement(sql);
            
        } catch (SQLException ex) {
            System.out.println("Erro sentença" + sql +" "+ ex.getMessage());
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
            stmInserir.setBigDecimal(2, rt.getValor());
            stmInserir.setString(3, rt.getData());
            stmInserir.setString(4, rt.getAcipiente());
            stmInserir.setString(5, rt.getSolvente());
            stmInserir.setString(6, rt.getMetodo());
            stmInserir.setString(7, rt.getBanco());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na insercao" + ex.getMessage());
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

    String getConta(String login) throws DaoException {
        String res ="";
        try {
            stmGetConta.setString(1, login);
            ResultSet resultados = stmGetConta.executeQuery();
            if(resultados.next()){
            res = resultados.getString("conta");
            }else{return res;}
        } catch (SQLException ex) {
            System.out.println("Erro aqui "+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }finally{
        return res;
        }
    }

    int getID(String login) throws DaoException {
        int res =0;
        try {
            stmGetID.setString(1, login);
            ResultSet resultados = stmGetID.executeQuery();
            if(resultados.next()){
            res = resultados.getInt("id");
            }else{return res;}
        } catch (SQLException ex) {
            System.out.println("Erro aqui 1"+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }finally{
        return res;
        }
    }

    String getNome(String login) throws DaoException {
                String res ="";
        try {
            stmGetNome.setString(1, login);
            ResultSet resultados = stmGetNome.executeQuery();
            if(resultados.next()){
            res = resultados.getString("nome");
            }else{return res;}
        } catch (SQLException ex) {
            System.out.println("Erro aqui 2"+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }finally{
        return res;
        }
    }

    String getBanco(String login) throws DaoException {
                String res ="";
        try {
            stmGetBanco.setString(1, login);
            ResultSet resultados = stmGetBanco.executeQuery();
            if(resultados.next()){
            res = resultados.getString("Banco");
            }else{return res;}
        } catch (SQLException ex) {
            System.out.println("Erro aqui "+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }finally{
        return res;
        }
    }

    String getSenha(String login) throws DaoException {
        String res ="";
        try {
            stmGetSenha.setString(1, login);
            ResultSet resultados = stmGetSenha.executeQuery();
            if(resultados.next()){
            res = resultados.getString("Senha");
            }else{return res;}
        } catch (SQLException ex) {
            System.out.println("Erro aqui "+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }finally{
        return res;
        }
    }

    List<RegistroTransacao> buscarPorString(String s) throws DaoException {
        List<RegistroTransacao> RegistroTransacao = new ArrayList<>();
        try {
            stmObterTrans.setString(1, s);
            stmObterTrans.setString(2, s);
            ResultSet resultados = stmObterTrans.executeQuery();
            while (resultados.next()) {
                RegistroTransacao c = new RegistroTransacao(resultados.getString("estado"),
                        resultados.getInt("ID"),
                        resultados.getBigDecimal("valor"),
                        resultados.getString("datat"),
                        resultados.getString("acipiente"),
                        resultados.getString("solvente"),
                        resultados.getString("metodo"),
                        resultados.getString("banco"));
                        
                RegistroTransacao.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro aqui "+ ex.getMessage());
            throw new DaoException("Erro ao executar a consulta dos dados");
        }
        return RegistroTransacao;
    }
    
}
