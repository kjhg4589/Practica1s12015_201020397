/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package edd.practica_1;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author kevin
 */
public final class JF_Plantas extends javax.swing.JFrame {

    /**
     * Creates new form JF_Plantas
     */
    
    Lista plantas = new Lista();
    Lista zombis = new Lista();
    Usuarios uPlantas, uZombis;
    boolean gZombis;
    public JF_Plantas(Usuarios uPlantas, Usuarios uZombis) {
        initComponents();
        this.uPlantas = uPlantas;
        this.uZombis = uZombis;
    }
    
    public JF_Plantas(Lista plantas, Usuarios uPlantas, Usuarios uZombis) {
        initComponents();
        this.plantas = plantas;
        this.uPlantas = uPlantas;
        this.uZombis = uZombis;
        this.crearPersonajes();
        gZombis = false;
    }
    
    public  JF_Plantas(Lista plantas, Lista zombis, Usuarios uPlantas, Usuarios uZombis){
        initComponents();
        this.plantas = plantas;
        this.zombis = zombis;
        this.uPlantas = uPlantas;
        this.uZombis = uZombis;
        this.setTitle("Registro de zombis");
        gZombis = true;
        this.crearPersonajes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Plantas");
        setPreferredSize(new java.awt.Dimension(550, 585));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Continuar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Registro de Plantas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //boton que agrega plantas o zombis
        new Agregar(plantas, zombis, uPlantas, uZombis, gZombis).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //boton que continua a la ventana de zombis
        if(!gZombis){
            new JF_Plantas(plantas, zombis, uPlantas, uZombis).setVisible(true);
        }else{
            new DMapa(uPlantas, uZombis, plantas, zombis).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new jModificar(plantas, zombis, uPlantas, uZombis, gZombis).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Eliminar(plantas, zombis, uPlantas, uZombis, gZombis).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public void crearPersonajes(){
        
        Nodos temp;
        
        if(gZombis){
            temp = zombis.getRaiz();
        }else{
            temp = plantas.getRaiz();
        }
        
        List<JLabel> labels = new ArrayList<>();

        int i = 0;
        while(temp != null){
            informacion lbl = new informacion(i*100,temp.getImagen(),temp.getNombre(),temp.getTipo(),temp.getPuntos());
            labels.add(lbl);
            temp = temp.getSig();
            i++;
        }
        
        JLabel panel = new JLabel();
        panel.setPreferredSize(new Dimension(500, labels.size()*100));
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setLayout(null);
        
        for (JLabel label : labels) {
            panel.add(label);
        }

       JScrollPane scrollPane = new JScrollPane(panel);
       scrollPane.setBounds(10, 43, 520, 467);
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       
       this.add(scrollPane);
   
       this.repaint();
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
