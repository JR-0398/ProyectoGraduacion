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
    private String catNombre;
    private String catDescripcion;

    public categoria() {
    }

    public categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public categoria(int id_categoria, String catNombre, String catDescripcion) {
        this.id_categoria = id_categoria;
        this.catNombre = catNombre;
        this.catDescripcion = catDescripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }
}
