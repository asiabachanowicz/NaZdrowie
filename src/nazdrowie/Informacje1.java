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

public class Informacje1 extends JPanel  {
    
    JButton bPrzejdzDoMenu;
    JButton bNastepnaStrona;
    BufferedImage background;
    
     /**
     * Konstruktor - wstawienie buttonów, informacji o produktach w formie obrazu jpg
     */
    public Informacje1(){
                        
        /**Ladowanie początkowych zasobów gry */ 
        GPars.loadInitialImages();
        setLayout(null);
 
        bPrzejdzDoMenu=new JButton ("PRZEJDŹ DO MENU");
        bPrzejdzDoMenu.setBounds(250,770,200,30);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bPrzejdzDoMenu);
        
        bNastepnaStrona=new JButton ("NASTĘPNA STRONA");
        bNastepnaStrona.setBounds(750,770,200,30);
        bNastepnaStrona.setBackground(new Color(250,224,120));
        bNastepnaStrona.setForeground(Color.BLACK);
        bNastepnaStrona.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bNastepnaStrona);
       
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
        g.drawImage(GPars.info1, 0, 0, null);

 }
    
    
}