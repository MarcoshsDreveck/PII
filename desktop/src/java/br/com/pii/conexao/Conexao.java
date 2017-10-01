/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pii.conexao;

/**
 *
 * @author Juliana
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost/pii?user=root&password=");
        return con;
    }
}
