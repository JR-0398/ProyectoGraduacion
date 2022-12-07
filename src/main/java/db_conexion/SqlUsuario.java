/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conexion;

import com.modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUANJO
 */
public class SqlUsuario extends cConexion {

    public boolean registrar(usuario usr) {
        PreparedStatement ps = null;
        Connection con = conexion();

        String sql = 
        "INSERT INTO usuario (nombre, apellido, uLogin,passwd,id_tipoUsuario) VALUES(?,?,?,?,?)";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1,usr.getNombre());
            ps.setString(2,usr.getApellido());
            ps.setString(3,usr.getuLogin());
            ps.setString(4,usr.getPasswd());
            ps.setInt(5,usr.getId_tipoUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }
    }
    
   public int existeUsuario(String uLogin) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();

        String sql = 
        "SELECT count(id_usuario) FROM usuario WHERE uLogin=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, uLogin);
            rs=ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException e) {
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE,null,e);
            return 1;
        }
    }
     
}
