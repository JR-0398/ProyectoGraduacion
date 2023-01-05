/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author JUANJO
 */
public class registro_historico {

  
    int id_pdf;
    String nombre_pdf;
    byte [] archivo_pdf;
    
    
    public registro_historico(){
    }
    
    
  /* todos los set y get de la clase*/
      public int getId_pdf() {
        return id_pdf;
    }

    public void setId_pdf(int id_pdf) {
        this.id_pdf = id_pdf;
    }

    public String getNombre_pdf() {
        return nombre_pdf;
    }

    public void setNombre_pdf(String nombre_pdf) {
        this.nombre_pdf = nombre_pdf;
    }

    public byte[] getArchivo_pdf() {
        return archivo_pdf;
    }

    public void setArchivo_pdf(byte[] archivo_pdf) {
        this.archivo_pdf = archivo_pdf;
    }
}
