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

/**
 *
 * @author Banos
 */
public class controlArticulo extends cConexion {
    articulo art = new articulo();
    Connection con = conexion();
    List <articulo> datos = new ArrayList<>();
    String sql = "";
    PreparedStatement ps;
    ResultSet res;
   
    public List<?> mostrarArticulos() {
       this.sql = "SELECT * FROM articulo";
       try {
           this.ps = this.con.prepareStatement(this.sql);
           this.res = this.ps.executeQuery();
           while (this.res.next()) {
               this.datos.add(new articulo(
                       this.res.getInt("id_articulo"),
                       this.res.getString("codigo"),
                       this.res.getString("nombreArt"),
                       this.res.getInt("cantidad"),
                       this.res.getString("estado"),
                       this.res.getInt("id_usuario"),
                       this.res.getInt("id_categoria")
               ));
           }
           //this.con.close();
           //this.res.close();
       }catch (SQLException e){
           System.out.println("Excepciones controladas: "+e.getMessage());
       }
       return this.datos;            
    }
    
    public boolean ingresarArticulos(articulo art) {
        this.sql = "INSERT INTO articulo (codigo, nombreArt, cantidad, estado, id_usuario, id_categoria) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1,art.getCodigo());
            this.ps.setString(2,art.getNombreArt());
            this.ps.setInt(3,art.getCantidad());
            this.ps.setString(4,art.getEstado());
            this.ps.setInt(5,art.getId_usuario());
            this.ps.setInt(6,art.getId_categoria());
            this.ps.executeUpdate();
            //this.con.close();
            return true;     
        } catch (SQLException e) {
            //Logger.getLogger(controlCategoria.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
    }
    
   public boolean editarArticulo(articulo art){
       this.sql = "UPDATE articulo SET codigo=?, nombreArt=?, cantidad=?, estado=?, id_usuario=?, id_categoria=? WHERE id_articulo=?";
        try {
            this.ps=this.con.prepareStatement(sql);
            this.ps.setString(1,art.getCodigo());
            this.ps.setString(2,art.getNombreArt());
            this.ps.setInt(3, art.getCantidad());
            this.ps.setString(4,art.getEstado());
            this.ps.setInt(5,art.getId_usuario());
            this.ps.setInt(6, art.getId_categoria());
            this.ps.setInt(7, art.getId_articulo());
            this.ps.executeUpdate();
            //this.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        //return false;
    }
 
   public boolean EliminarArticulo(articulo art){
        this.sql = "DELETE FROM articulo WHERE id_articulo=?";
        try {
            this.ps=this.con.prepareStatement(sql);
            this.ps.setInt(1,art.getId_articulo());
            this.ps.executeUpdate();
            //this.con.close();
            return true; 
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null,"" );
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
    }  
}
