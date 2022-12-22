/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Banos
 */
public class categoria {
    private int id_categoria;
    private String categoria;
    private String descripcionCat;

    public categoria() {
    }

    public categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public categoria(int id_categoria, String categoria, String descripcionCat) {
        this.id_categoria = id_categoria;
        this.categoria = categoria;
        this.descripcionCat = descripcionCat;
    }
    
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }
}
