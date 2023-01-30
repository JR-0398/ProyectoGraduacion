/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.modelo.articulo;
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
 * @author Banos
 */
public class controlArticulo extends cConexion {
    /*articulo art = new articulo();
    Connection con = conexion();
    List <articulo> datos = new ArrayList<>();
    String sql = "";
    PreparedStatement ps;
    ResultSet res;*/
   
    public List<?> mostrarArticulos() {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet res;
        List <articulo> datos = new ArrayList<>();
        
        String sql = "SELECT articulo.id_articulo, articulo.artCodigo, articulo.artNombre, articulo.artCantidad, articulo.artEstado, articulo.artComentario, articulo.id_usuario, usuario.usDui, articulo.id_categoria, categoria.catNombre FROM articulo LEFT JOIN categoria ON articulo.id_categoria = categoria.id_categoria LEFT JOIN usuario ON articulo.id_usuario = usuario.id_usuario";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                datos.add(new articulo (
                        res.getInt("id_articulo"),
                        res.getString("artCodigo"),
                        res.getString("artNombre"),
                        res.getInt("artCantidad"),
                        res.getString("artEstado"),
                        res.getString("artComentario"),
                        res.getInt("id_usuario"),
                        res.getInt("id_categoria"),
                        res.getString("usDui"),
                        res.getString("catNombre")));
            }
            con.close();
            res.close();
        }catch (SQLException e){
            System.out.println("Excepciones controladas: "+e.getMessage());
        }
        return datos;
    }
    
    public List<?> buscarArticulo(String Buscar) {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet res;
        List <articulo> datos = new ArrayList<>();
        
        String sql = "SELECT articulo.id_articulo, articulo.artCodigo, articulo.artNombre, articulo.artCantidad, articulo.artEstado, articulo.artComentario, articulo.id_usuario, usuario.usDui, articulo.id_categoria, categoria.catNombre FROM articulo LEFT JOIN categoria ON articulo.id_categoria = categoria.id_categoria LEFT JOIN usuario ON articulo.id_usuario = usuario.id_usuario WHERE articulo.artCodigo LIKE '%"+Buscar+"%' OR articulo.artNombre LIKE '%"+Buscar+"%' OR articulo.artCantidad LIKE '%"+Buscar+"%' OR articulo.artEstado LIKE '%"+Buscar+"%'";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                articulo art = new articulo();
                art.setId_articulo(res.getInt("id_articulo"));
                art.setArtCodigo(res.getString("artCodigo"));
                art.setArtNombre(res.getString("artNombre"));
                art.setArtCantidad(res.getInt("artCantidad"));
                art.setArtEstado(res.getString("artEstado"));
                art.setArtComentario(res.getString("artComentario"));
                art.setId_usuario(res.getInt("id_usuario"));
                art.setId_categoria(res.getInt("id_categoria"));
                art.setUsDui(res.getString("usDui"));
                art.setCatNombre(res.getString("catNombre"));
                datos.add(art);
            }
            con.close();
            res.close();
        }catch (SQLException e){
            System.out.println("Excepciones controladas: "+e.getMessage());
        }
        return datos;
    }
    
    public boolean ingresarArticulos(articulo art) {
        Connection con = conexion();
        PreparedStatement ps;
        
        String sql = "INSERT INTO articulo (artCodigo, artNombre, artCantidad, artEstado, artComentario, id_usuario, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,art.getArtCodigo());
            ps.setString(2,art.getArtNombre());
            ps.setInt(3,art.getArtCantidad());
            ps.setString(4,art.getArtEstado());
            ps.setString(5,art.getArtComentario());
            ps.setInt(6,art.getId_usuario());
            ps.setInt(7,art.getId_categoria());
            ps.execute();
            con.close();
            return true;     
        } catch (SQLException e) {
            //Logger.getLogger(controlCategoria.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
    }
    
    public int existeArticulo(String artCodigo) {
        Connection con = conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT count(id_articulo) FROM articulo WHERE artCodigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artCodigo);
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
    
   public boolean editarArticulo(articulo art){
       Connection con = conexion();
       PreparedStatement ps;
       
       String sql = "UPDATE articulo SET artCodigo=?, artNombre=?, artCantidad=?, artEstado=?, artComentario=?, id_usuario=?, id_categoria=? WHERE id_articulo=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1,art.getArtCodigo());
           ps.setString(2,art.getArtNombre());
           ps.setInt(3, art.getArtCantidad());
           ps.setString(4,art.getArtEstado());
           ps.setString(5,art.getArtComentario());
           ps.setInt(6,art.getId_usuario());
           ps.setInt(7, art.getId_categoria());
           ps.setInt(8, art.getId_articulo());
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
 
   public boolean EliminarArticulo(articulo art){
       Connection con = conexion();
       PreparedStatement ps;
       
        String sql = "DELETE FROM articulo WHERE id_articulo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,art.getId_articulo());
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
