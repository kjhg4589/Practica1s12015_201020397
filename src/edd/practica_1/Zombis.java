/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.practica_1;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class Zombis extends JLabel{
    
    public Zombis(Pila zombis){
        this.setBounds(1040, 80, 130, 510);
        this.setOpaque(true);
        this.setLayout(null);
        this.setVisible(true);
        
        int cantidad = zombis.getCantidad();
        int n = 0;
        for(int i=0; i<5; i++){
            Nodos raiz = zombis.getRaiz();
            for(int j=1; j<cantidad-n; j++){
                raiz = raiz.getSig();
            }
                ImageIcon a = new ImageIcon(raiz.getImagen());
                java.awt.Image b = a.getImage();
                ImageIcon c = new ImageIcon(b.getScaledInstance(95, 95, java.awt.Image.SCALE_DEFAULT));

                JLabel imagen = new JLabel(c);
                imagen.setBounds(15, 5+(i*100), 95, 95);
                imagen.setVisible(true);
                this.add(imagen);
                n++;
        }
    }

}
