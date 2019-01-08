/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *Instrukcja gry
 * @author Asia
 */

public class Instrukcja  extends JPanel   {
    
    JButton bMenu;
    BufferedImage instruction;
    
    /**
     * Konstruktor - wstawienie buttonów, instrukcji w formie obrazu jpg
     */
    public Instrukcja() {
        
        /**Ladowanie początkowych zasobów gry */         
        GPars.loadInitialImages();
        setLayout(null);
 
        bMenu=new JButton ("PRZEJDŹ DO MENU");
        bMenu.setBounds(740,770,200,30);
        bMenu.setBackground(new Color(250,224,120));
        bMenu.setForeground(Color.BLACK);
        bMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bMenu);
        
                
    }
    /**
     * Nadpisz metodę odpowiedzialną za odrysowanie panelu - własne wypełnienie 
     * pola graficznego gry, zgodnie z wybraną treścią
     * @param gs 
     */
        protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.menubackground, 0, 0, null);
        g.drawImage(GPars.instruction, 0, 0, null);

 }
    
}
