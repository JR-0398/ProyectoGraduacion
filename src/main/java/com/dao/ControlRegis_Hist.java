/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.modelo.registro_historico;
import db_conexion.cConexion;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JUANJO
 */
public class ControlRegis_Hist  extends cConexion{
    
    
    public ArrayList<registro_historico> Listar_Pdf(){ //Metodo para Listar todos los pdf
    ArrayList<registro_historico> list = new ArrayList<registro_historico>();
       Connection con = conexion();
        String sql = "SELECT * FROM registro_historico;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registro_historico vo = new registro_historico();
                vo.setId_pdf(rs.getInt(1));
                vo.setNombre_pdf(rs.getString(2));
                vo.setArchivo_pdf(rs.getBytes(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
            }
        }
        return list;
    }
    
    public void Agregar_Pdf(registro_historico vo){
    Connection con = conexion();
    String sql = "INSERT INTO registro_historico (id_pdf, nombre_pdf, archivo_pdf) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getId_pdf());
            ps.setString(2, vo.getNombre_pdf());
            ps.setBytes(3, vo.getArchivo_pdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
            }
        }
    
    }
    
    
    public  void Modificar_Pdf(registro_historico vo){ //Modificar el nombre y el archivo de un Pdf
    
        Connection con = conexion();
        String sql = "UPDATE registro_historico SET nombre_pdf = ?, archivo_pdf = ? WHERE id_pdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombre_pdf());
            ps.setBytes(2, vo.getArchivo_pdf());
            ps.setInt(3, vo.getId_pdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Modificar_Pdf2(registro_historico vo){ //Modificar solo el nombre de un archivo Pdf
        Connection con = conexion();
        
        String sql = "UPDATE registro_historico SET nombre_pdf = ? WHERE id_pdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombre_pdf());
            ps.setInt(2, vo.getId_pdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
            }
        }   
    }
    
    public void Eliminar_PdfVO(registro_historico vo) {
        Connection con = conexion();
        
        
        String sql = "DELETE FROM registro_historico WHERE id_pdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getId_pdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
            }
        }
    }
    
    
    public void ejecutar_archivoPDF(int id) { //Nos permite mostrar el contenido del PDF existente en la base de datos

        Connection con = conexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = con.prepareStatement("SELECT archivo_pdf FROM registro_historico WHERE id_pdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf"); //Se crea como archivo temporal
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            con.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
}
