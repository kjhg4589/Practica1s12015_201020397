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
public class Pila {
        
    private Nodos raiz;
    
    public Pila(){ 
        raiz = null; 
    }

    public Nodos getRaiz() {
        return raiz;
    }
    
    public boolean estaVacia(){
        return raiz==null;
    }
    
    public void insertar(String imagen, String nombre, String tipo, int puntos){
        if(this.estaVacia()){
            raiz = new Nodos(imagen, nombre, tipo, puntos);
        }else{
            Nodos temp = raiz;
            while(temp.getSig()!=null){
                temp = temp.getSig();
            }
            temp.setSig(new Nodos(imagen, nombre, tipo, puntos));
        }
    }
    
    public Nodos sacar(){
        Nodos temp, sacar;
        
        temp = this.getRaiz();
        
        if(temp.getSig()==null){
            sacar = temp;
            raiz = null;
        }else{
            if(temp.getSig().getSig()==null){
                sacar = temp.getSig();
                temp.setSig(null);
            }else{
                while(temp.getSig().getSig()!=null){
                    temp = temp.getSig();
                }
                sacar = temp.getSig();
                temp.setSig(null);
            }
        }
        return sacar;
    }
    
    public void imprimir(){
        Nodos temp = this.getRaiz();
        while(temp!=null){
            System.out.println(temp.getNombre());
            temp = temp.getSig();
        }
    }
    
}
