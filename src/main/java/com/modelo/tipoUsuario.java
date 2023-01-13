/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Banos
 */
public class tipoUsuario {
    private int id_tipoUsuario;
    private String tuNombre;

    public tipoUsuario(int id_tipoUsuario, String tuNombre) {
        this.id_tipoUsuario = id_tipoUsuario;
        this.tuNombre = tuNombre;
    }

    public int getId_tipoUsuario() {
        return id_tipoUsuario;
    }

    public void setId_tipoUsuario(int id_tipoUsuario) {
        this.id_tipoUsuario = id_tipoUsuario;
    }

    public String getTuNombre() {
        return tuNombre;
    }

    public void setTuNombre(String tuNombre) {
        this.tuNombre = tuNombre;
    }
    
    @Override
    public String toString() {
        return tuNombre;
    }
    
}
