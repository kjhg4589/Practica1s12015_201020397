/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.practica_1;

/**
 *
 * @author kevin
 */
public class Cabecera {
    
    private NodoMatriz primero;
    private Cabecera sig;
    private int cabecera;

    public Cabecera(int cabecera) {
        this.sig = null;
        this.primero = null;
        this.cabecera = cabecera;
    }

    public NodoMatriz getPrimero() {
        return primero;
    }

    public void setPrimero(NodoMatriz primero) {
        this.primero = primero;
    }

    public Cabecera getSig() {
        return sig;
    }

    public void setSig(Cabecera sig) {
        this.sig = sig;
    }

    public int getCabecera() {
        return cabecera;
    }

    public void setCabecera(int cabecera) {
        this.cabecera = cabecera;
    }  
    
}
