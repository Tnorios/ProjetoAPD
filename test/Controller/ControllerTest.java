/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RegistroTransacao;
import Model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheusdevasconcelos
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of listar method, of class Controller.
     */
    @Test
    public void testListar() {
        String login = "666";
        String senha = "admin";
        Controller instance = null;
        instance = new Controller("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        boolean res = true;
        Usuario result = instance.autenticar(login, senha);
        assertEquals(res, result.listar().size()>0);
    }

    /**
     * Test of autenticar method, of class Controller.
     */
    @Test
    public void testAutenticar() {
        String login = "666";
        String senha = "admin";
        Controller instance = null;
        instance = new Controller("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        String res ="666";
        Usuario result = instance.autenticar(login, senha);
        assertEquals(res, result.getConta());
    }

    /**
     * Test of processar method, of class Controller.
     */
    @Test
    public void testProcessar() {
        RegistroTransacao r = null;
        r = new RegistroTransacao();
        r.setAcipiente("123");
        r.setBanco("Banco1");
        r.setData("11/11/1111");
        r.setEstado("Inicial");
        r.setMetodo("Debito");
        r.setSolvente("666");
        r.setValor(BigDecimal.ZERO);
        Controller instance = null;
        instance = new Controller("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        String expResult = "Recusada";
        RegistroTransacao result = instance.processar(r);
        assertEquals(expResult, result.getEstado());
    }
    
    
}
