/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package edd.practica_1;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class Plantas extends JLabel{
    
    public Plantas(Cola plantas){
        this.setBounds(5, 80, 130, 510);
        this.setOpaque(true);
        this.setLayout(null);
        this.setVisible(true);
        
        Nodos raiz = plantas.getRaiz();
        for(int i=0; i<5 && raiz!=null; i++){
            ImageIcon a = new ImageIcon(raiz.getImagen());
            java.awt.Image b = a.getImage();
            ImageIcon c = new ImageIcon(b.getScaledInstance(95, 95, java.awt.Image.SCALE_DEFAULT));
        
            JLabel imagen = new JLabel(c);
            imagen.setBounds(15, 5+(i*100), 95, 95);
            imagen.setVisible(true);
            this.add(imagen);
            
            raiz = raiz.getSig();
        }
    }
}
