/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package edd.practica_1;

/**
 *
 * @author kevin
 */
public class nodoUsuarios {
    
    private String texto;
    private nodoUsuarios sig;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public nodoUsuarios getSig() {
        return sig;
    }

    public void setSig(nodoUsuarios sig) {
        this.sig = sig;
    }
    
    public nodoUsuarios(String t){
        this.texto=t;
        this.sig=null;
    }
}
