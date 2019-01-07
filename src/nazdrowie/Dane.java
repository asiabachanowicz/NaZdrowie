package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.*;


/**
 *Wpisywanie danych gracza
 * 
 * @author Asia
 */

public class Dane extends JPanel {
    
    //pola tekstowe (wpisywanie danych)
    JTextField timie;
    JTextField twiek;
    JTextField tmasa;
    JTextField twzrost;
    JTextField tliczbakalorii;
    //buttony
    JButton bPrzejdzDoMenu;
    JButton bOblicz;
    JButton bGraj;
    //pola tekstowe
    JLabel LwyswietlImie;
    JLabel LwyswietlPlec;
    JLabel LwyswietlWiek;
    JLabel LwyswietlMasa;
    JLabel LwyswietlWzrost;
    JLabel LwyswietlInfo1;
    JLabel LwyswietlInfo2;
    JLabel Ldziennezapotrzebowanie;
    //lista wyboru
    JComboBox Bplec;
    //zmienne do obliczen
    String imie;
    String plec;
    String wiek;
    String masa;
    String wzrost;
    
    BufferedImage background;
    
     public Dane() {
        
        GPars.loadInitialImages();
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
        //pobieranie tekstu z pola tekstowego i przypisanie do nowej zmiennej
        String imie = timie.getText();
        timie.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        LwyswietlPlec= new JLabel("PŁEĆ:");
        LwyswietlPlec.setBounds(242,315,100,30);
        LwyswietlPlec.setForeground(Color.BLACK);
        LwyswietlPlec.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlPlec);
        
        
        Bplec = new JComboBox ();
        Bplec.addItem("Kobieta");
        Bplec.setSelectedIndex(0);
        Bplec.addItem("Mężczyzna");
        Bplec.setBounds(320,310,640,50);
        add(Bplec);
        Bplec.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        
        LwyswietlWiek= new JLabel("WIEK:");
        LwyswietlWiek.setBounds(242,415,100,30);
        LwyswietlWiek.setForeground(Color.BLACK);
        LwyswietlWiek.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWiek);
        
        twiek= new JTextField();
        twiek.setBounds(320,410,640,50);
        add(twiek);
        //pobieranie tekstu z pola tekstowego i przypisanie do nowej zmiennej
        String wiek = twiek.getText();
        twiek.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        LwyswietlMasa= new JLabel("MASA:");
        LwyswietlMasa.setBounds(242,515,100,30);
        LwyswietlMasa.setForeground(Color.BLACK);
        LwyswietlMasa.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlMasa);
        
        tmasa= new JTextField();
        tmasa.setBounds(320,510,640,50);
        add(tmasa);
        //pobieranie tekstu z pola tekstowego i przypisanie do nowej zmiennej
        String masa = tmasa.getText();
        tmasa.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        LwyswietlWzrost= new JLabel("WZROST:");
        LwyswietlWzrost.setBounds(222,615,200,30);
        LwyswietlWzrost.setForeground(Color.BLACK);
        LwyswietlWzrost.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWzrost);
        
        twzrost= new JTextField();
        twzrost.setBounds(320,610,640,50);
        add(twzrost);
        //pobieranie tekstu z pola tekstowego i przypisanie do nowej zmiennej
        String wzrost = twzrost.getText();
        twzrost.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        bPrzejdzDoMenu=new JButton ("MENU");
        bPrzejdzDoMenu.setBounds(755,760,200,70);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bPrzejdzDoMenu);
        
        bGraj=new JButton ("GRAJ");
        bGraj.setBounds(505,760,200,70);
        bGraj.setBackground(new Color(250,224,120));
        bGraj.setForeground(Color.BLACK);
        bGraj.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bGraj);
              
        Ldziennezapotrzebowanie= new JLabel( "TWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE TO: ");
        Ldziennezapotrzebowanie.setBounds(250,690,1240,30);
        Ldziennezapotrzebowanie.setForeground(Color.BLACK);
        Ldziennezapotrzebowanie.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        add(Ldziennezapotrzebowanie);
      
        
        tliczbakalorii= new JTextField();
        tliczbakalorii.setBounds(735,680,70,50);
        add(tliczbakalorii);
        tliczbakalorii.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        bOblicz=new JButton ("OBLICZ");
        bOblicz.setBounds(255,760,200,70);
        bOblicz.setBackground(new Color(250,224,120));
        bOblicz.setForeground(Color.BLACK);
        bOblicz.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bOblicz);
       
        
        
    }
}
