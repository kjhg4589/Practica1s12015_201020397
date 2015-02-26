/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package edd.practica_1;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Mapa extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Mapa
     * @param ancho
     * @param alto
     * @param imagen
     */
    
    private final Tablero tablero;
    private final Usuarios uPlantas, uZombis;
    private final Lista cPlantas, cZombis;
    private final Pila pila;
    private final Cola cola;
    private int totalPlantas, totalZombis, cantPlantas, cantZombis;
    private Plantas lblplantas;
    private Zombis lblzombis;
    private Matriz matriz;
    private Thread hilo1;
    
    public Mapa(int ancho, int alto, String imagen, Usuarios uPlantas, Usuarios uZombis, Lista cPlantas, Lista cZombis) {
        initComponents();
        tablero = new Tablero(alto, alto, imagen);
        this.add(tablero);
        this.uPlantas = uPlantas;
        this.uZombis = uZombis;
        this.cPlantas = cPlantas;
        this.cZombis = cZombis;
        this.pila = new Pila();
        this.cola = new Cola();
        this.totalPlantas = Integer.parseInt(uPlantas.getRaiz().getSig().getTexto());
        this.totalZombis = Integer.parseInt(uZombis.getRaiz().getSig().getTexto());
        this.cantPlantas = this.cantZombis = 0;
        lblu1.setText(uPlantas.getRaiz().getTexto());
        lblu2.setText(uZombis.getRaiz().getTexto());
        this.matriz = new Matriz();
        matriz.insertarColumnas(ancho, alto);
        matriz.cabeceras();
        this.insertarPrimeros();
        this.agregarPlantas();
        hilo1 = new Thread(this);
        hilo1.start();
    }
    
    public void hilo(){
        int plantas = cPlantas.getCantidad();
        int zombis = cZombis.getCantidad();
        
        int num1 = (int) Math.floor(Math.random()*(plantas-0+1)+0);
        if(cantPlantas<totalPlantas){
            Nodos nodo = cPlantas.getRaiz();
            for(int j=1; j<num1; j++){
                nodo = nodo.getSig();
            }
            cantPlantas++;
            cola.insertar(nodo.getImagen(), nodo.getNombre(), nodo.getTipo(), nodo.getPuntos());
        }
        
        int num2 = (int) Math.floor(Math.random()*(zombis-0+1)+0);
        if(cantZombis<totalZombis){
            Nodos nodo = cZombis.getRaiz();
            for(int j=1; j<num2; j++){
                nodo = nodo.getSig();
            }
            cantZombis++;
            pila.insertar(nodo.getImagen(), nodo.getNombre(), nodo.getTipo(), nodo.getPuntos());
        }
        this.remove(lblplantas);
        this.remove(lblzombis);
        this.agregarPlantas();
        this.repaint();
    }
    
    public void insertarPrimeros(){

        int plantas = cPlantas.getCantidad();
        int zombis = cZombis.getCantidad();
  
        for(int i=0; i<5; i++){
            int num1 = (int) Math.floor(Math.random()*(plantas-0+1)+0);
            if(cantPlantas<totalPlantas){
                Nodos nodo = cPlantas.getRaiz();
                for(int j=1; j<num1; j++){
                    nodo = nodo.getSig();
                }
                cantPlantas++;
                cola.insertar(nodo.getImagen(), nodo.getNombre(), nodo.getTipo(), nodo.getPuntos());
            }
        }
        
        for(int i=0; i<5; i++){
            int num2 = (int) Math.floor(Math.random()*(zombis-0+1)+0);
            if(cantZombis<totalZombis){
                Nodos nodo = cZombis.getRaiz();
                for(int j=1; j<num2; j++){
                    nodo = nodo.getSig();
                }
                cantZombis++;
                pila.insertar(nodo.getImagen(), nodo.getNombre(), nodo.getTipo(), nodo.getPuntos());
            }
        }
    }
    
    public void agregarPlantas(){
        lblplantas = new Plantas(cola);
        this.add(lblplantas);
        lblzombis = new Zombis(pila);
        this.add(lblzombis);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblu1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblu2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plantas vs Zombis Guatemalteco");
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pausa(evt);
            }
        });

        jLabel1.setText("Usuario: ");

        lblu1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblu1.setForeground(new java.awt.Color(204, 0, 0));
        lblu1.setText("jLabel2");

        jLabel3.setText("Usuario: ");

        lblu2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblu2.setForeground(new java.awt.Color(204, 0, 0));
        lblu2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblu1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 908, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblu2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblu1)))
                .addContainerGap(597, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pausa(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pausa
        // TODO add your handling code here:
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            new Pausa(this, true, uPlantas, uZombis, cPlantas, cZombis, cola, pila, matriz).setVisible(true);
        }
    }//GEN-LAST:event_pausa

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblu1;
    private javax.swing.JLabel lblu2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            this.hilo();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
