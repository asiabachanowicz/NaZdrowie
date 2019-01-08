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
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;



/**
 *Panel Menu
 * @author Asia
 */
public class MenuPanel  extends JPanel {
    
    JButton bNewGame;
    JButton bInfo;
    JButton bExit;
    JButton bInstruction;
    BufferedImage image1;
    BufferedImage background;
    
/**
     * Konstruktor - wstawienie buttonów
     */
public MenuPanel(){
    
        GPars.loadInitialImages();
        setSize(1200,900);
        setLayout(null);
        
        bNewGame=new JButton ("NOWA GRA");
        bNewGame.setBounds(280,220,640,100);
        bNewGame.setBackground(new Color(250,224,120));
        bNewGame.setForeground(Color.BLACK);
        bNewGame.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bNewGame);
        
                
        bInfo=new JButton ("WYŚWIETL INFORMACJE O PRODUKTACH");
        bInfo.setBounds(280,380,640,100);
        bInfo.setBackground(new Color(250,224,120));
        bInfo.setForeground(Color.BLACK);
        bInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bInfo);
        
        
        bExit=new JButton ("ZAKOŃCZ GRĘ");
        bExit.setBounds(280,680,640,100);
        bExit.setBackground(new Color(250,224,120));
        bExit.setForeground(Color.BLACK);
        bExit.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bExit);
       
        
        bInstruction=new JButton ("WYŚWIETL INSTRUKCJĘ");
        bInstruction.setBounds(280,530,640,100);
        bInstruction.setBackground(new Color(250,224,120));
        bInstruction.setForeground(Color.BLACK);
        bInstruction.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bInstruction);
           
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
        
        g.drawImage(GPars.logoImage, 285, 50, null);
}
}