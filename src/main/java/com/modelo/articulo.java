/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Banos
 */
public class articulo {
    private int id_articulo;
    private String codigo;
    private String nombreArt;
    private int cantidad ;
    private String estado;
    private int id_usuario;
    private int id_categoria;

    public articulo() {
    }

    public articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public articulo(int id_articulo, String codigo, String nombreArt, int cantidad, String estado, int id_usuario, int id_categoria) {
        this.id_articulo = id_articulo;
        this.codigo = codigo;
        this.nombreArt = nombreArt;
        this.cantidad = cantidad;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
    }
    
    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
