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
public class Usuarios {

    private nodoUsuarios raiz;
        
    public Usuarios(){
        raiz = null;
    }
        
    public nodoUsuarios getRaiz() {
        return raiz;
    }
    
    public boolean estaVacia(){
        return raiz==null;
    }
    
    public void insertar(String texto){
        if(this.estaVacia()){
            raiz = new nodoUsuarios(texto);
        }else{
            nodoUsuarios temp = raiz;
            while(temp.getSig()!=null){
                temp = temp.getSig();
            }
            temp.setSig(new nodoUsuarios(texto));
        }
    }
    
    public void imprimir(){
        nodoUsuarios temp = raiz;
        while(temp!=null){
            System.out.println(temp.getTexto());    
            temp = temp.getSig();
        }
    }
    
    public void borrar(){
        raiz = null;
    }
}
