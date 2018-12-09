
package nazdrowie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;



/**
 *
 * @author Asia
 */
public class NaZdrowie extends JFrame implements ActionListener {

      
       
    public NaZdrowie() throws IOException{
     
        
    }
    
    
    public static void main(String[] args) throws IOException {
        
        /*
        //wyswietl Menu
        MenuPanel menuglowne=new MenuPanel();
        menuglowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuglowne.setVisible(true);
        */
        
        
        
            //otwarcie okna gry
            int gameWidth=1200;
            int gameHeight=900;
                
            //pobierz rozmiar ekranu
            int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
            int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
            //oblicz wspolrzedne naroznika tak, aby pole gry bylo wysrodkowane
            int xCenter=(screenWidth-gameWidth)/2;
            int yCenter=(screenHeight-gameHeight)/2; 
                   
            GameWindow gw=new GameWindow(gameWidth,gameHeight,xCenter,yCenter);
            gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gw.setVisible(true);
        
                            
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e){
        
}

}