/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package edd.practica_1;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author kevin
 */
public class Matriz {
    
    private Cabecera columnas, filas;
    
    public Matriz(){
        this.columnas = this.filas = null;
    }

    public Cabecera getCabecera() {
        return columnas;
    }
    
    public Cabecera getFila(){
        return filas;
    }

    public void setCabecera(Cabecera columnas) {
        this.columnas = columnas;
    }
    
    public void insertarColumnas(int columna, int fila){
        for(int i=0; i<columna; i++){ 
            columnas = insertarCabecera(i+1, columnas);
        }
        for(int i=0; i<fila; i++){
            filas = insertarCabecera(i+1, filas);
        }
        for(int i=0; i<columna; i++){
            for(int j=0; j<fila; j++){
                this.crearNodos(i+1, j+1);
            }
        }
    }
    
    private void crearNodos(int columna, int fila){
        Cabecera columna_actual = cabeceraActual(columna, columnas);
        Cabecera fila_actual = cabeceraActual(fila, filas);
        
        NodoMatriz nodo = new NodoMatriz(fila, columna);
        if (columna_actual.getPrimero() == null){
            columna_actual.setPrimero(nodo);
            nodo.setCcolumna(columna_actual);
        }else{
            if (columna_actual.getPrimero().getFila()> nodo.getFila()){
                nodo.setAbj(columna_actual.getPrimero());
                columna_actual.getPrimero().setArr(nodo);
                nodo.setCcolumna(columna_actual);
                columna_actual.getPrimero().setCcolumna(null);
                columna_actual.setPrimero(nodo);
            }else{
                NodoMatriz anterior, p;
                anterior = p = columna_actual.getPrimero();

                while ((p.getAbj() != null) && (nodo.getFila()> p.getFila())){
                    anterior = p;
                    p = p.getAbj();
                }
                if (nodo.getFila()> p.getFila())
                    anterior = p;

                if (anterior.getAbj() == null){
                    nodo.setAbj(anterior.getAbj());
                    nodo.setArr(anterior);
                    anterior.setAbj(nodo);
                }else{
                    nodo.setAbj(anterior.getAbj());
                    nodo.setArr(anterior);
                    anterior.getAbj().setArr(nodo);
                    anterior.setAbj(nodo);
                }
            }
        }
        if (fila_actual.getPrimero() == null){
            fila_actual.setPrimero(nodo);
            nodo.setCfila(fila_actual);
        }else{
                if (fila_actual.getPrimero().getColumna()> nodo.getColumna())
                {
                    nodo.setDer(fila_actual.getPrimero());
                    fila_actual.getPrimero().setIzq(nodo);
                    nodo.setCfila(fila_actual);
                    fila_actual.getPrimero().setCfila(null);
                    fila_actual.setPrimero(nodo);
                }
                else
                {
                    NodoMatriz anterior, p;
                    anterior = p = fila_actual.getPrimero();

                    while ((p.getDer() != null) && (nodo.getColumna()> p.getColumna()))
                    {
                        anterior = p;
                        p = p.getDer();
                    }

                    if (nodo.getColumna()> p.getColumna())
                        anterior = p;
                    if (anterior.getDer() == null)
                    {
                        nodo.setDer(anterior.getDer());
                        nodo.setIzq(anterior);
                        anterior.setDer(nodo);
                    }
                    else
                    {
                        nodo.setDer(anterior.getDer());
                        nodo.setIzq(anterior);
                        anterior.getDer().setIzq(nodo);
                        anterior.setDer(nodo);
                    }
                }
            }
    }
    
    public Cabecera cabeceraActual(int n, Cabecera cabecera){
        Cabecera aux = cabecera;
        while (aux != null)
        {
            if (aux.getCabecera()== n)
                break;
            else
                aux = aux.getSig();
        }
        return aux;
    }
    
    
    private Cabecera insertarCabecera(int i, Cabecera cabecera){
        Cabecera nuevo = new Cabecera(i);
        if(cabecera==null){
            cabecera = nuevo;
        }else{
            if(cabecera.getCabecera()>nuevo.getCabecera()){
                nuevo.setSig(cabecera);
                cabecera = nuevo;
            }else{
                Cabecera anterior, p;
                anterior = p = cabecera;

                while ((p.getSig() != null) && (nuevo.getCabecera()> p.getCabecera())){
                    anterior = p;
                    p = p.getSig();
                }

                if (nuevo.getCabecera()> p.getCabecera()){
                    anterior = p; 
                }
                
                if (!ColumnaExiste(cabecera, nuevo.getCabecera())){
                    nuevo.setSig(anterior.getSig());
                    anterior.setSig(nuevo);
                }
            }
        }
        return cabecera;
    }
    
    private Boolean ColumnaExiste(Cabecera Columna, int n){
        Boolean encontrada = false;
        Cabecera aux = Columna;
        while(aux!=null){
            if(aux.getCabecera()==n){
                encontrada = true;
                break;
            }else{
                aux = aux.getSig();
            }
        }
        return encontrada;
    }
    
    public void cabeceras(){
        Cabecera aux = columnas;
        while (aux!=null) {
            NodoMatriz nodo = aux.getPrimero();
            while(nodo!=null){
                System.out.println("columna: " + aux.getCabecera() + " fila: " + nodo.getFila());
                nodo = nodo.getAbj();
            }
            aux=aux.getSig();
        }
    }   
    
    
}
