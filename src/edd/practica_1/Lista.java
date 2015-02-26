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
public class Lista {
    
    private Nodos raiz;
    private int cantidad;
    
    public Lista(){
        this.raiz = null;
        this.cantidad=0;
    }

    public Nodos getRaiz() {
        return raiz;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public boolean estaVacia(){
        return raiz == null;
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
        cantidad++;
    }
    
    public void eliminar(String nombre){
        if(this.getRaiz().getNombre().equals(nombre)){
            raiz = raiz.getSig();
        }else{
            Nodos aux = this.getRaiz();
            while(aux!=null && !aux.getSig().getNombre().equals(nombre)){
                aux = aux.getSig();
            }
            if(aux.getSig().getNombre().equals(nombre)){
                aux.setSig(aux.getSig().getSig());
            }
        }
    }
    
    public void modificar(String parametro, String imagen, String nombre, String tipo, int puntos){        
        
        if(this.getRaiz().getNombre().equals(parametro)){
            String nombre1 = this.getRaiz().getNombre();
            String imagen1 = this.getRaiz().getImagen();
            String tipo1 = this.getRaiz().getTipo();
            int puntos1 = this.getRaiz().getPuntos();
            if(!imagen.equals("")){
                imagen1 = imagen;
            }
            if(!nombre.equals("")){
                nombre1 = nombre;
            }
            if(!tipo.equals("")){
                tipo1 = tipo;
            }
            if(puntos!=0){
                puntos1 = puntos;
            } 
            raiz.setImagen(imagen1);
            raiz.setNombre(nombre1);
            raiz.setTipo(tipo1);
            raiz.setPuntos(puntos1);
        }else{
            Nodos aux = this.getRaiz();
            while(aux!=null && !aux.getNombre().equals(parametro)){
                aux = aux.getSig();
            }
            if(aux.getNombre().equals(parametro)){
                String nombre1 = aux.getNombre();
                String imagen1 = aux.getImagen();
                String tipo1 = aux.getTipo();
                int puntos1 = aux.getPuntos();
                if(!imagen.equals("")){
                    imagen1 = imagen;
                }
                if(!nombre.equals("")){
                    nombre1 = nombre;
                }
                if(!tipo.equals("")){
                    tipo1 = tipo;
                }
                if(puntos!=0){
                    puntos1 = puntos;
                } 
                aux.setImagen(imagen1);
                aux.setNombre(nombre1);
                aux.setTipo(tipo1);
                aux.setPuntos(puntos1);;
            }
        }
    }
}
