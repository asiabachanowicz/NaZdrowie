
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
    
    JButton bPrzejdzDoMenu;
    BufferedImage instrukcja;
    
    public Instrukcja() {
        
                
        GPars.loadInitialImages();
        setLayout(null);
 
        bPrzejdzDoMenu=new JButton ("PRZEJDŹ DO MENU");
        bPrzejdzDoMenu.setBounds(740,770,200,30);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bPrzejdzDoMenu);
        
                
    }
    
        protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.menubackground, 0, 0, null);
        g.drawImage(GPars.instrukcja, 0, 0, null);

 }
    
}
