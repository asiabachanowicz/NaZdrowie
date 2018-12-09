
package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author Asia
 */

public class NowaGra extends JFrame implements ActionListener  {
    
    JTextField timie;
    JTextField tplec;
    JTextField twiek;
    JTextField tmasa;
    JTextField twzrost;
    JButton bPrzejdzDoMenu;
    JButton bOblicz;
    JLabel LwyswietlImie;
    JLabel LwyswietlPlec;
    JLabel LwyswietlWiek;
    JLabel LwyswietlMasa;
    JLabel LwyswietlWzrost;
    JLabel LwyswietlInfo1;
    JLabel LwyswietlInfo2;
    String imie;
    String plec;
    String wiek;
    String masa;
    String wzrost;
    BufferedImage background;
          
    public NowaGra() throws IOException{
        
                
        setSize(1200,900);
        setTitle("NowaGra");
        setLayout(null);
        
        LwyswietlInfo1= new JLabel( "WPISZ DANE I KLIKNIJ <OBLICZ>, ABY OBLICZYĆ");
        LwyswietlInfo1.setBounds(283,100,1240,30);
        LwyswietlInfo1.setForeground(Color.BLACK);
        LwyswietlInfo1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LwyswietlInfo1);
        
        LwyswietlInfo2= new JLabel( "DZIENNE ZAPOTRZEBOWANIE  NA KALORIE");
        LwyswietlInfo2.setBounds(320,135,1240,30);
        LwyswietlInfo2.setForeground(Color.BLACK);
        LwyswietlInfo2.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LwyswietlInfo2);
        
        LwyswietlImie= new JLabel("IMIĘ:");
        LwyswietlImie.setBounds(250,215,100,30);
        LwyswietlImie.setForeground(Color.BLACK);
        LwyswietlImie.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlImie);
        
        timie= new JTextField();
        timie.setBounds(320,210,640,50);
        add(timie);
        String imie = timie.getText();
        
        LwyswietlPlec= new JLabel("PŁEĆ:");
        LwyswietlPlec.setBounds(242,315,100,30);
        LwyswietlPlec.setForeground(Color.BLACK);
        LwyswietlPlec.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlPlec);
        
        tplec= new JTextField();
        tplec.setBounds(320,310,640,50);
        add(tplec);
        String plec = tplec.getText();
        
        LwyswietlWiek= new JLabel("WIEK:");
        LwyswietlWiek.setBounds(242,415,100,30);
        LwyswietlWiek.setForeground(Color.BLACK);
        LwyswietlWiek.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWiek);
        
        twiek= new JTextField();
        twiek.setBounds(320,410,640,50);
        add(twiek);
        String wiek = twiek.getText();
        
        LwyswietlMasa= new JLabel("MASA:");
        LwyswietlMasa.setBounds(242,515,100,30);
        LwyswietlMasa.setForeground(Color.BLACK);
        LwyswietlMasa.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlMasa);
        
        tmasa= new JTextField();
        tmasa.setBounds(320,510,640,50);
        add(tmasa);
        String masa = tmasa.getText();
        
        LwyswietlWzrost= new JLabel("WZROST:");
        LwyswietlWzrost.setBounds(222,615,200,30);
        LwyswietlWzrost.setForeground(Color.BLACK);
        LwyswietlWzrost.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWzrost);
        
        twzrost= new JTextField();
        twzrost.setBounds(320,610,640,50);
        add(twzrost);
        String wzrost = twzrost.getText();
        
        bPrzejdzDoMenu=new JButton ("PRZEJDŹ DO MENU");
        bPrzejdzDoMenu.setBounds(630,710,300,70);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bPrzejdzDoMenu);
        bPrzejdzDoMenu.addActionListener(this);
        
        bOblicz=new JButton ("OBLICZ");
        bOblicz.setBounds(270,710,300,70);
        bOblicz.setBackground(new Color(250,224,120));
        bOblicz.setForeground(Color.BLACK);
        bOblicz.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bOblicz);
        bOblicz.addActionListener(this);
        
        background = ImageIO.read(new File("images/2.png"));
        JLabel backgroundmenu = new JLabel(new ImageIcon (background));
        backgroundmenu.setSize(1200,900);
        backgroundmenu.setBounds(0,0,1200,900);
        add(backgroundmenu);
     
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object zrodlo=e.getSource();
                
        if (zrodlo==bPrzejdzDoMenu){
         
            MenuPanel menuglowne;
            try {
                menuglowne = new MenuPanel();
                menuglowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuglowne.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Instrukcja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        if (zrodlo==bOblicz){
          
            ObliczanieKalorii oblicz = null;
            try {
                oblicz = new ObliczanieKalorii();
            } catch (IOException ex) {
                Logger.getLogger(NowaGra.class.getName()).log(Level.SEVERE, null, ex);
            }
            oblicz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            oblicz.setVisible(true);
            
        }       
    }

}