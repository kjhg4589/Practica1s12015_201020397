/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.practica_1;

import java.awt.Color;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class informacion extends JLabel{
    
    public informacion(int i, String img, String Nombre, String ataque, int puntos){
        

        this.setBackground(Color.red);
        this.setBounds(10, i+10, 300,90);
        this.setVisible(true);
        this.setLayout(null);
        
        ImageIcon a = new ImageIcon(img);
        java.awt.Image b = a.getImage();
        ImageIcon c = new ImageIcon(b.getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        
        JLabel imagen = new JLabel(c);
        imagen.setBounds(5, 5, 80, 80);
        imagen.setVisible(true);
        this.add(imagen);
    }
    
}
