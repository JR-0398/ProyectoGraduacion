/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.modelo.usuario;
import db_conexion.cConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUANJO
 */
public class ControlUsuario extends cConexion {

    public boolean registrar(usuario usr) {
        PreparedStatement ps = null;
        Connection con = conexion();

        String sql
                = "INSERT INTO usuario (usNombre, usApellido, usPasswd, id_tipoUsuario, usDui, usTelefono, usCargo, usPregunta, usRespuesta) VALUES(?,?,?,?,?,?,?,?,?)";  //enviar informacion de dui nula
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsNombre());
            ps.setString(2, usr.getUsApellido());
            ps.setString(3, usr.getUsPasswd());
            ps.setInt(4, usr.getId_tipoUsuario());
            ps.setString(5, usr.getUsDui());
            ps.setString(6, usr.getUsTelefono());
            ps.setString(7, usr.getUsCargo());
            ps.setString(8, usr.getUsPregunta());
            ps.setString(9, usr.getUsRespuesta());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public int existeUsuario(String usDui) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion();

        String sql
                = "SELECT count(id_usuario) FROM usuario WHERE usDui=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usDui);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            con.close();
            rs.close();
            return 1;
        } catch (SQLException e) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
    }

    public boolean modificarInfoUsuario(usuario user) {
        PreparedStatement ps = null;
        Connection con = conexion();
        
        //String sql = "UPDATE usuario SET usNombre=?, id_tipoUsuario=? WHERE id_usuario=?";
        String sql = "UPDATE usuario SET usNombre=?, usApellido=?, usDui=?, usPasswd=?, usTelefono=?, usCargo=?, usPregunta=?, usRespuesta=?, id_tipoUsuario=? WHERE id_usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsNombre());
            ps.setString(2, user.getUsApellido());
            ps.setString(3, user.getUsDui());
            ps.setString(4, user.getUsPasswd());
            ps.setString(5, user.getUsTelefono());
            ps.setString(6, user.getUsCargo());
            ps.setString(7, user.getUsPregunta());
            ps.setString(8, user.getUsRespuesta());
            ps.setInt(9, user.getId_tipoUsuario());
            ps.setInt(10, user.getId_usuario());

            int filas = ps.executeUpdate();
            con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Exepciones Controladas" + e.getMessage());
            return false;
        }
    }

    public boolean EliminarUsuario(usuario user) {
        PreparedStatement ps = null;
        Connection con = conexion();

        String sql
                = "DELETE FROM usuario WHERE id_usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId_usuario());

            int filas = ps.executeUpdate();
            con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exepciones controladas" + e.getMessage());
            return false;
        }
    }

    public List<?> MostrarUsuarios() {
        ResultSet res;
        List<usuario> data = new ArrayList<>();
        PreparedStatement ps = null;
        Connection con = conexion();
        String sql = "SELECT id_usuario, usNombre, usApellido, usDui, usPasswd, usTelefono, usCargo, usPregunta, usRespuesta FROM usuario";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                usuario user = new usuario();
                user.setId_usuario(res.getInt("id_usuario"));
                user.setUsNombre(res.getString("usNombre"));
                user.setUsApellido(res.getString("usApellido"));
                user.setUsDui(res.getString("usDui"));
                user.setUsPasswd(res.getString("usPasswd"));
                user.setUsTelefono(res.getString("usTelefono"));
                user.setUsCargo(res.getString("usCargo"));
                user.setUsPregunta(res.getString("usPregunta"));
                user.setUsRespuesta(res.getString("usRespuesta"));
                data.add(user);
            }
            con.close();
            res.close();
        } catch (SQLException e) {
            System.out.println("Exepciones controladas");
        }
        return data;
    }

    public List<?> CargarFiltrar(String Buscar) {
        ResultSet res;
        List<usuario> data = new ArrayList<>();
        PreparedStatement ps = null;
        Connection con = conexion();
        String sql = 
        "SELECT id_usuario, usNombre, usApellido, usDui, usPasswd, usTelefono, usCargo, usPregunta, usRespuesta FROM usuario WHERE usNombre LIKE '"+Buscar+"%' OR usApellido LIKE '"+Buscar+"%' OR usCargo LIKE '"+Buscar+"%' OR usTelefono LIKE '"+Buscar+"%' OR usDui LIKE '"+Buscar+"%'";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                usuario user = new usuario();
                user.setId_usuario(res.getInt("id_usuario"));
                user.setUsNombre(res.getString("usNombre"));
                user.setUsApellido(res.getString("usApellido"));
                user.setUsDui(res.getString("usDui"));
                user.setUsPasswd(res.getString("usPasswd"));
                user.setUsTelefono(res.getString("usTelefono"));
                user.setUsCargo(res.getString("usCargo"));
                user.setUsPregunta(res.getString("usPregunta"));
                user.setUsRespuesta(res.getString("usRespuesta"));
                data.add(user);
            }
            con.close();
            res.close();
        } catch (SQLException e) {
            System.out.println("Exepciones controladas");
        }
        return data;
    }
    
    public boolean modificarContraUsuario(usuario user) {
        PreparedStatement ps = null;
        Connection con = conexion();
        
        //String sql = "UPDATE usuario SET usNombre=?, id_tipoUsuario=? WHERE id_usuario=?";
        String sql = "UPDATE usuario SET usPasswd=?  WHERE id_usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsPasswd());
            ps.setInt(2, user.getId_usuario());
            int filas = ps.executeUpdate();
            con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Exepciones Controladas" + e.getMessage());
            return false;
        }
    }
}
