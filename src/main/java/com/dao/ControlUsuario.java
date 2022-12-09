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
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE,null,e);
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
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE,null,e);
            return 1;
        }
    }
   public void modificarInfoUsuario(usuario user) throws Exception{
        PreparedStatement ps = null;
        Connection con = conexion();

        String sql = 
        "UPDATE usuario SET  nombre=?, apellido=?,dui=?, passwd=?,telefono=?,direccion=?,cargo=? WHERE id_usuario=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getNombre());
            ps.setString(2,user.getApellido());	
            ps.setString(3,user.getDui());
            ps.setNString(4,user.getPasswd());
            ps.setString(5,user.getTelefono());
            ps.setString(6,user.getDireccion());
            ps.setInt(7,user.getId_tipoUsuario());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
   
   
   public void EliminarUsuario(usuario user) throws Exception{
        PreparedStatement ps = null;
        Connection con = conexion();

        String sql = 
        "DELETE * FROM usuario WHERE id_usuario=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,user.getId_usuario());
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            throw e;
        }
    }
   public List<?> MostrarUsuarios() {
       ResultSet res;
       List <usuario> data = new ArrayList<>();
       PreparedStatement ps =null;
       Connection con = conexion();
       String sql="SELECT nombre,apellido,dui,uLogin,telefono,direccion,cargo FROM usuario";
       try {
           ps=con.prepareStatement(sql);
           res=ps.executeQuery();
           while (res.next()) {
               usuario user = new usuario();
               user.setNombre(res.getString("nombre"));
               user.setApellido(res.getString("apellido"));
               user.setDui(res.getString("dui"));
               user.setuLogin(res.getString("uLogin"));
               user.setTelefono(res.getString("telefono"));
               user.setDireccion(res.getString("direccion"));
               user.setCargo(res.getString("cargo"));
               data.add(user);
           }
       } catch (SQLException e) {
           System.out.println("Exepciones controladas");
       }
        return data;
   }
     
}
