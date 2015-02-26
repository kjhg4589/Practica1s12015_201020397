package edd.practica_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */

/**
 *
 * @author kevin
 */
public class Nodos {
    
    private String imagen;
    private String nombre;
    private String tipo;
    private int puntos;
    private Nodos sig;

    public Nodos(String imagen, String nombre, String tipo, int puntos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntos = puntos;
        this.sig = null;
    }

    public Nodos getSig() {
        return sig;
    }

    public void setSig(Nodos sig) {
        this.sig = sig;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
