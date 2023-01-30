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
    private String artCodigo;
    private String artNombre;
    private int artCantidad ;
    private String artEstado;
    private String artComentario;
    private int id_usuario;
    private int id_categoria;
    private String usDui;
    private String catNombre;

    public articulo() {
    }

    public articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public articulo(int id_articulo, String artCodigo, String artNombre, int artCantidad, String artEstado, String artComentario, int id_usuario, int id_categoria, String usDui, String catNombre) {
        this.id_articulo = id_articulo;
        this.artCodigo = artCodigo;
        this.artNombre = artNombre;
        this.artCantidad = artCantidad;
        this.artEstado = artEstado;
        this.artComentario = artComentario;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
        this.usDui = usDui;
        this.catNombre = catNombre;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getArtCodigo() {
        return artCodigo;
    }

    public void setArtCodigo(String artCodigo) {
        this.artCodigo = artCodigo;
    }

    public String getArtNombre() {
        return artNombre;
    }

    public void setArtNombre(String artNombre) {
        this.artNombre = artNombre;
    }

    public int getArtCantidad() {
        return artCantidad;
    }

    public void setArtCantidad(int artCantidad) {
        this.artCantidad = artCantidad;
    }

    public String getArtEstado() {
        return artEstado;
    }

    public void setArtEstado(String artEstado) {
        this.artEstado = artEstado;
    }

    public String getArtComentario() {
        return artComentario;
    }

    public void setArtComentario(String artComentario) {
        this.artComentario = artComentario;
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

    public String getUsDui() {
        return usDui;
    }
    
    public void setUsDui(String usDui) {
        this.usDui = usDui;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }
    
}
