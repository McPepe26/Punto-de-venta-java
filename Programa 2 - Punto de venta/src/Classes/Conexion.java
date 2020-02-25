/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ja-za
 */
public class Conexion {
    public static Connection conexion;

    public static Connection getConexion() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=DBSales;integratedSecurity=true");
            //JOptionPane.showMessageDialog(null, "Conectado");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado");
        }
        return conexion;
    }
}
