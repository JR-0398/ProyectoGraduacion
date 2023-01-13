/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import db_conexion.cConexion;
import com.modelo.categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Banos
 */
public class controlCategoria extends cConexion {
    
    /*categoria cat = new categoria();
    Connection con = conexion();
    List <categoria> datos = new ArrayList<>();
    String sql = "";
    PreparedStatement ps;
    ResultSet res;*/
   
    public List<?> mostrarCategorias() {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet res;
        List <categoria> datos = new ArrayList<>();
        
        String sql = "SELECT id_categoria, catNombre, catDescripcion FROM categoria";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()){
                datos.add(new categoria(
                        res.getInt("id_categoria"),
                        res.getString("catNombre"),
                        res.getString("catDescripcion")));
            }
           con.close();
           res.close();
        }catch (SQLException e){
            System.out.println("Excepciones controladas: "+e.getMessage());
       }
       return datos;            
    }
    
    public List<?> buscarCategoria(String Buscar) {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet res;
        List <categoria> datos = new ArrayList<>();
        
        String sql = "SELECT id_categoria, catNombre, catDescripcion FROM categoria WHERE catNombre LIKE '%"+Buscar+"%'";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                categoria cat = new categoria();
                cat.setId_categoria(res.getInt("id_categoria"));
                cat.setCatNombre(res.getString("catNombre"));
                cat.setCatDescripcion(res.getString("catDescripcion"));
                datos.add(cat);
            }
            con.close();
            res.close();
        }catch (SQLException e){
            System.out.println("Excepciones controladas: "+e.getMessage());
        }
        return datos;
    }

    public boolean ingresarCategorias(categoria cat) {
        Connection con = conexion();
        PreparedStatement ps;
        
        String sql = "INSERT INTO categoria (catNombre, catDescripcion) VALUES (?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cat.getCatNombre());
            ps.setString(2,cat.getCatDescripcion());
            ps.execute();
            con.close();
            return true;     
        } catch (SQLException e) {
            //Logger.getLogger(controlCategoria.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
    }
    
    public int existeUsuario(String catNombre) {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT count(id_categoria) FROM categoria WHERE catNombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, catNombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            con.close();
            rs.close();
            return 1;
        }catch (SQLException e){
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Excepciones controladas: "+e.getMessage());
            return 1;
        }
    }
    
   public boolean editarCategoria(categoria cat){
       Connection con = conexion();
       PreparedStatement ps;
       
       String sql = "UPDATE categoria SET catNombre=?, catDescripcion=? WHERE id_categoria=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1,cat.getCatNombre());
           ps.setString(2,cat.getCatDescripcion());
           ps.setInt(3, cat.getId_categoria());
           int filas = ps.executeUpdate();
           con.close();
           if (filas > 0){
               return true;
           }else{
               return false;
           }
       }catch (SQLException e){
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        //return false;
    }
 
   public boolean EliminarCategoria(categoria cat){
       Connection con = conexion();
       PreparedStatement ps;
       
       String sql = "DELETE FROM categoria WHERE id_categoria=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1,cat.getId_categoria());
           int filas = ps.executeUpdate();
           con.close();
           if (filas > 0){
               return true;
            }else{
               return false;
            }
       }catch (SQLException e){
           //JOptionPane.showMessageDialog(null,"" );
           System.out.println("Excepciones controladas: "+e.getMessage());
           return false;
        }
    }  
}
