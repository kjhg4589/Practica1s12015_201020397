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
public class Graphviz {
    
    final private String direccion = "/home/kevin/Java/NetBeansProjects/[EDD]Practica_1/reporte.png";

    public String getDireccion() {
        return direccion;
    }
    
    public void usuarios(Usuarios plantas, Usuarios zombis){
        FileWriter fichero = null;
        try
        {
            fichero = new FileWriter("Salida.dot");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(usuarios(plantas.getRaiz(), zombis.getRaiz()));
            Desktop.getDesktop().open(new File("Salida.dot")); 
        } catch (Exception e) {
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
        this.dibujar("Salida.dot", direccion);
    }
    
    private static String usuarios(nodoUsuarios plantas, nodoUsuarios zombis){
        StringBuilder b = new StringBuilder();    
        b.append("digraph G { \n");
        b.append("usuarios -> plantas; \n");
        b.append("usuarios -> zombis; \n");
        b.append(String.format("%s -> %s %s", "plantas", "planta0"+plantas.getTexto().trim(), "\n"));
        b.append(String.format("%s -> %s %s", "zombis", "zombi0"+zombis.getTexto().trim(), "\n"));    
        b.append("subgraph cluster_plantas  { \n");
        b.append(toNodosPlanta(plantas,0));
        b.append(toDotPlanta(plantas,0));
        b.append("}\n");
        b.append("subgraph cluster_zombis { \n");
        b.append(toNodoszombi(zombis,0));
        b.append(toDotZombi(zombis,0));
        b.append("}\n");
        b.append("}\n");
        return b.toString();
    }
    
    private static String toDotPlanta(nodoUsuarios raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz.getSig()!=null){
            b.append(String.format("%s -> %s %s", "planta"+i+raiz.getTexto().trim(), "planta"+(i+1)+raiz.getSig().getTexto().trim(), "\n"));
            i++;
            b.append(toDotPlanta(raiz.getSig(), i));
        }
        return b.toString();
    }
    
    private static String toNodosPlanta(nodoUsuarios raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz!=null){
            b.append(String.format("%s [label = \"%s\"]; %s", "planta"+i+raiz.getTexto().trim(), raiz.getTexto().trim(), "\n"));
            i++;
            b.append(toNodosPlanta(raiz.getSig(), i));
        }
        return b.toString();
    }
    
    private static String toDotZombi(nodoUsuarios raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz.getSig()!=null){
            b.append(String.format("%s -> %s %s", "zombi"+i+raiz.getTexto().trim(), "zombi"+(i+1)+raiz.getSig().getTexto().trim(), "\n"));
            i++;
            b.append(toDotZombi(raiz.getSig(), i));
        }
        return b.toString();
    }
    
    private static String toNodoszombi(nodoUsuarios raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz!=null){
            b.append(String.format("%s [label = \"%s\"]; %s", "zombi"+i+raiz.getTexto().trim(), raiz.getTexto(), "\n"));
            i++;
            b.append(toNodoszombi(raiz.getSig(),i));
        }
        return b.toString();
    }
    
    private void dibujar(String dot, String png){
        try{
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng","-o", png, dot);
            pbuilder.redirectErrorStream( true );
            pbuilder.start();
        }catch(Exception e){}
    }
    
    public void CatPlantas(Nodos raiz){
        FileWriter fichero = null;
        try
        {
            fichero = new FileWriter("Salida.dot");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(toPlantas(raiz));
            Desktop.getDesktop().open(new File("Salida.dot")); 
        } catch (Exception e) {
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
        this.dibujar("Salida.dot", direccion);
    }
    
    private String toPlantas(Nodos plantas){
        StringBuilder b = new StringBuilder();    
        b.append("digraph G { \n");
        b.append(toPlanta(plantas, 0));
        b.append(toCatPlanta(plantas, 0));
        b.append("}\n");
        return b.toString();
    }
    
    private static String toPlanta(Nodos raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz!=null){
            b.append(String.format("%s [label = \"%s\"]; %s", "planta"+i, raiz.getNombre() + "\\l" + raiz.getImagen() + 
                    "\\l" + raiz.getTipo(), "\n"));
            i++;
            b.append(toPlanta(raiz.getSig(), i));
        }
        return b.toString();
    }
    
    private static String toCatPlanta(Nodos raiz, int i) {
        StringBuilder b = new StringBuilder();
        if(raiz.getSig()!=null){
            b.append(String.format("%s -> %s %s", "planta"+i, "planta"+(i+1), "\n"));
            i++;
            b.append(toCatPlanta(raiz.getSig(), i));
        }
        return b.toString();
    }
    
    public void AmbosCat(Lista plantas, Lista zombis){
        FileWriter fichero = null;
        try
        {
            fichero = new FileWriter("Salida.dot");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(toAmbosCat(plantas.getRaiz(), zombis.getRaiz()));
            Desktop.getDesktop().open(new File("Salida.dot")); 
        } catch (Exception e) {
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
        this.dibujar("Salida.dot", direccion);
    }
    
    private String toAmbosCat(Nodos plantas, Nodos zombis){
        StringBuilder b = new StringBuilder();    
        b.append("digraph G { \n");
        b.append("subgraph cluster_plantas  { \n");
        b.append(toPlanta(plantas,0));
        b.append(toCatPlanta(plantas, 0));
        b.append("}\n");
        b.append("subgraph cluster_zombis { \n");
        b.append(toPlanta(zombis,1000));
        b.append(toCatPlanta(zombis, 1000));
        b.append("}\n");
        b.append("}\n");
        return b.toString();
    }
    
    public void dibujarMatriz(Cabecera filas, Cabecera columnas){
        FileWriter fichero = null;
        try
        {
            fichero = new FileWriter("Salida.dot");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(toMatriz(filas, columnas));
            Desktop.getDesktop().open(new File("Salida.dot")); 
        } catch (Exception e) {
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
        this.dibujar("Salida.dot", direccion);
    }
    
    
    private String toMatriz(Cabecera filas, Cabecera columnas){
        StringBuilder b = new StringBuilder();    
        b.append("digraph G { \n");
        b.append(moverNodos(columnas));
        Cabecera aux1 = columnas;
        while(aux1!=null){
            b.append(porColumnas(aux1.getPrimero()));
            aux1 = aux1.getSig();
        }
        Cabecera aux2 = filas;
        while(aux2!=null){
            b.append(porFilas(aux2.getPrimero()));
            aux2 = aux2.getSig();
        }
        b.append("}\n");
        return b.toString();
    }
    
    private static String moverNodos(Cabecera columna){
        StringBuilder b = new StringBuilder();    
        if(columna!=null){
            b.append(toNodosMatriz(columna.getPrimero()));
            b.append(moverNodos(columna.getSig()));
        }
        return b.toString();
    }
    
    private static String toNodosMatriz(NodoMatriz raiz) {
        StringBuilder b = new StringBuilder();
        if(raiz!=null){
            b.append(String.format("%s [label = \"%s\"]; %s", "nodo"+String.valueOf(raiz.getFila())+String.valueOf(raiz.getColumna()), String.valueOf(raiz.getFila())+","+String.valueOf(raiz.getColumna()),"\n"));
            b.append(toNodosMatriz(raiz.getAbj()));
        }
        return b.toString();
    }
    
    private static String porFilas(NodoMatriz raiz) {
        StringBuilder b = new StringBuilder();
        if(raiz.getIzq()!=null){
            b.append(String.format("%s -> %s; %s", "nodo"+String.valueOf(raiz.getFila())+String.valueOf(raiz.getColumna()), "nodo"+String.valueOf(raiz.getIzq().getFila())+String.valueOf(raiz.getIzq().getColumna()),"\n"));
        }
        if(raiz.getDer()!=null){
            b.append(String.format("%s -> %s; %s", "nodo"+String.valueOf(raiz.getFila())+String.valueOf(raiz.getColumna()), "nodo"+String.valueOf(raiz.getDer().getFila())+String.valueOf(raiz.getDer().getColumna()),"\n"));
            b.append(porFilas(raiz.getDer()));
        }
        return b.toString();
    }
    
    private static String porColumnas(NodoMatriz raiz) {
        StringBuilder b = new StringBuilder();
        if(raiz.getArr()!=null){
            b.append(String.format("%s -> %s; %s", "nodo"+String.valueOf(raiz.getFila())+String.valueOf(raiz.getColumna()), "nodo"+String.valueOf(raiz.getArr().getFila())+String.valueOf(raiz.getArr().getColumna()),"\n"));
        }
        if(raiz.getAbj()!=null){
            b.append(String.format("%s -> %s; %s", "nodo"+String.valueOf(raiz.getFila())+String.valueOf(raiz.getColumna()), "nodo"+String.valueOf(raiz.getAbj().getFila())+String.valueOf(raiz.getAbj().getColumna()),"\n"));
            b.append(porColumnas(raiz.getAbj()));
        }
        return b.toString();
    }
}
