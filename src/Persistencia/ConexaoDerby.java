/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.Interfaces.iConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 31686559
 */
public class ConexaoDerby implements iConexao{
    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String nomeBancoDados;
    private Connection conexao;
    
    public ConexaoDerby(String usuario, String senha, String hostname, int porta, String n){
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.nomeBancoDados = n;
    }
    
    @Override
    public Connection getConnection(){
        if (conexao == null){
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + nomeBancoDados;
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return conexao;
    }
    
    @Override
    public void close(){
        try{
            conexao.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

