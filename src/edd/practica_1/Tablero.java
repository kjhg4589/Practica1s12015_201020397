/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.practica_1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class Tablero extends JLabel{
    
    public Tablero(int x, int y, String imagen){
        
        ImageIcon a = new ImageIcon(imagen);
        java.awt.Image b = a.getImage();
        ImageIcon c = new ImageIcon(b.getScaledInstance(875, 590, java.awt.Image.SCALE_DEFAULT));
        
        this.setIcon(c);
        this.setBounds(150, 10, 875, 590);
        this.setVisible(true);
        this.setLayout(null);
    }
}
