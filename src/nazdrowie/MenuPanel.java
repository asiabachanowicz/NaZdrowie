
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
    
    JButton bNowaGra;
    JButton bWyswietlInfo;
    JButton bZakonczGre;
    JButton bInstrukcja;
    BufferedImage image1;
    BufferedImage background;
    

public MenuPanel(){
    
        GPars.loadInitialImages();
        setSize(1200,900);
        setLayout(null);
        
        bNowaGra=new JButton ("NOWA GRA");
        bNowaGra.setBounds(280,220,640,100);
        bNowaGra.setBackground(new Color(250,224,120));
        bNowaGra.setForeground(Color.BLACK);
        bNowaGra.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bNowaGra);
        
                
        bWyswietlInfo=new JButton ("WYŚWIETL INFORMACJE O PRODUKTACH");
        bWyswietlInfo.setBounds(280,380,640,100);
        bWyswietlInfo.setBackground(new Color(250,224,120));
        bWyswietlInfo.setForeground(Color.BLACK);
        bWyswietlInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bWyswietlInfo);
        
        
        bZakonczGre=new JButton ("ZAKOŃCZ GRĘ");
        bZakonczGre.setBounds(280,680,640,100);
        bZakonczGre.setBackground(new Color(250,224,120));
        bZakonczGre.setForeground(Color.BLACK);
        bZakonczGre.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bZakonczGre);
       
        
        bInstrukcja=new JButton ("WYŚWIETL INSTRUKCJĘ");
        bInstrukcja.setBounds(280,530,640,100);
        bInstrukcja.setBackground(new Color(250,224,120));
        bInstrukcja.setForeground(Color.BLACK);
        bInstrukcja.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bInstrukcja);
           
}
        protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.menubackground, 0, 0, null);
        
        g.drawImage(GPars.logoImage, 285, 50, null);
}
}