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
 *Info o produktach
 * @author Asia
 */

public class Informacje3 extends JPanel  {
    
    JButton bMenu;
    JButton bNext;
    JButton bPrev;
    BufferedImage background;
    /**
     * Konstruktor - wstawienie buttonów, informacji o produktach w formie obrazu jpg
     */
    public Informacje3(){
        
        /**Ladowanie początkowych zasobów gry */ 
        GPars.loadInitialImages();
        setLayout(null);
 
        bMenu=new JButton ("PRZEJDŹ DO MENU");
        bMenu.setBounds(250,770,200,30);
        bMenu.setBackground(new Color(250,224,120));
        bMenu.setForeground(Color.BLACK);
        bMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bMenu);
        
        bPrev=new JButton ("POPRZEDNIA STRONA");
        bPrev.setBounds(500,770,200,30); 
        bPrev.setBackground(new Color(250,224,120));
        bPrev.setForeground(Color.BLACK);
        bPrev.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bPrev);
        
        bNext=new JButton ("NASTĘPNA STRONA");
        bNext.setBounds(750,770,200,30);
        bNext.setBackground(new Color(250,224,120));
        bNext.setForeground(Color.BLACK);
        bNext.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bNext);
       
        
        
        
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
        g.drawImage(GPars.info3, 0, 0, null);

 }
    
    
}