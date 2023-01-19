/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Banos
 */
public class cConexion {
    
   Connection Conexion = null;
    
    private final String user = "root";
    private final String pass = "admin";
    private final String bd = "db_inventario";
    private final String ip = "localhost";
    private final String puerto = "3306";
    
    private final String url = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    

    public Connection conexion() {      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection(url, user, pass);
            System.out. println("CONEXION EXITOSA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion de la base de datos "+e.toString());
        }
        return Conexion;
    }
    
}
