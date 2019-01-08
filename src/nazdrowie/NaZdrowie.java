/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nazdrowie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;



/**
 * Interaktywna gra Komputerowa „Na zdrowie!”
 * pokazująca różnice pomiędzy zdrowym a niezdrowym odżywianiem
 * @author Asia
 */
public class NaZdrowie extends JFrame implements ActionListener {
  
    public NaZdrowie() throws IOException{
     
    }
    
    /**
     * Metoda uruchamia grę.
     */
    public static void main(String[] args) throws IOException {
        
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