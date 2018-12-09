
package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asia
 */
public class  ObliczanieKalorii extends JFrame implements ActionListener {
    
    /**
     * Ustawianie parametrów i rozpoczęcia akcji
     * @param width szerokosc okna
     * @param height wysokosc okna
     * @param x pozycja x lewego gornego naroznika okna 
     * @param y pozycja y lewego gornego naroznika okna 
     */
    
    JLabel Ldziennezapotrzebowanie;
    JButton bOK;
    JButton bZakonczGre;
    BufferedImage background;
    

public ObliczanieKalorii() throws IOException  //obliczanie dziennego zapotrzebowania
        
    {
        setSize(1200,900);
        setTitle("Obliczanie Kalorii");
        setLayout(null);

        Ldziennezapotrzebowanie= new JLabel( "TWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE TO: ");
        Ldziennezapotrzebowanie.setBounds(250,100,1240,30);
        Ldziennezapotrzebowanie.setForeground(Color.BLACK);
        Ldziennezapotrzebowanie.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(Ldziennezapotrzebowanie);


        bZakonczGre=new JButton ("ZAKOŃCZ GRĘ");
        bZakonczGre.setBounds(630,710,300,70);
        bZakonczGre.setBackground(new Color(250,224,120));
        bZakonczGre.setForeground(Color.BLACK);
        bZakonczGre.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bZakonczGre);
        bZakonczGre.addActionListener(this);
        
        bOK=new JButton ("OK, ROZPOCZNIJ GRĘ");
        bOK.setBounds(270,710,300,70);
        bOK.setBackground(new Color(250,224,120));
        bOK.setForeground(Color.BLACK);
        bOK.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bOK);
        bOK.addActionListener(this);
        
        background = ImageIO.read(new File("images/2.png"));
        JLabel backgroundmenu = new JLabel(new ImageIcon (background));
        backgroundmenu.setSize(1200,1024);
        backgroundmenu.setBounds(0,0,1200,900);
        add(backgroundmenu);
              

    }

/*
public ilosckalorii(){
    
       
       
    Mężczyźni	66 + [13,7 x masa ciała (kg)] + [5 x wzrost (cm)] - [6,76 x wiek (lata)]
    Kobiety	655 + [9,6 x masa ciała (kg)] + [1,8 x wzrost (cm)] - [4,7 x wiek (lata)]
    
}
*/

@Override
    public void actionPerformed(ActionEvent e){
        Object zrodlo=e.getSource();
                
        if (zrodlo==bZakonczGre){
         
            dispose();
                       
        }       
          
        if (zrodlo==bOK){
            
            //Włączanie nowej gry ??? nie otwiera się :(
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
       
    }
    
}