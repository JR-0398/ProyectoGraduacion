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
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Banos
 */
public class controlCategoria extends cConexion {
    
    categoria cat = new categoria();
    Connection con = conexion();
    List <categoria> datos = new ArrayList<>();
    String sql = "";
    PreparedStatement ps;
    ResultSet res;
   
    public List<?> mostrarCategorias() {
       this.sql = "SELECT * FROM categoria";
       try {
           this.ps = this.con.prepareStatement(this.sql);
           this.res = this.ps.executeQuery();
           while (this.res.next()) {
               this.datos.add(new categoria(
                       this.res.getInt("id_categoria"),
                       this.res.getString("categoria"),
                       this.res.getString("descripcionCat")
               ));
           }
           //this.con.close();
           //this.res.close();
       }catch (SQLException e){
           System.out.println("Excepciones controladas: "+e.getMessage());
       }
       return this.datos;            
    }
    
    public boolean ingresarCategorias(categoria cat) {
        this.sql = "INSERT INTO categoria (categoria, descripcionCat) VALUES(?, ?)";
        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1,cat.getCategoria());
            this.ps.setString(2,cat.getDescripcionCat());
            this.ps.executeUpdate();
            //this.con.close();
            return true;     
        } catch (SQLException e) {
            //Logger.getLogger(controlCategoria.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
    }
    
   public boolean editarCategoria(categoria cat){
       this.sql = "UPDATE categoria SET categoria=?, descripcionCat=? WHERE id_categoria=?";
        try {
            this.ps=this.con.prepareStatement(sql);
            this.ps.setString(1,cat.getCategoria());
            this.ps.setString(2,cat.getDescripcionCat());
            this.ps.setInt(3, cat.getId_categoria());
            this.ps.executeUpdate();
            //this.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        //return false;
    }
 
   public boolean EliminarCategoria(categoria cat){
        this.sql = "DELETE FROM categoria WHERE id_categoria=?";
        try {
            this.ps=this.con.prepareStatement(sql);
            this.ps.setInt(1,cat.getId_categoria());
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
