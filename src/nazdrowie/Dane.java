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
 * Klasa umożliwiająca wpisywanie danych przez gracza
 * @author Asia
 */


public class Dane extends JPanel implements ActionListener {
    
     /** Pola tekstowe (wpisywanie danych) */
    JTextField timie;
    JTextField twiek;
    JTextField tmasa;
    JTextField twzrost;
    JTextField tliczbakalorii;
     /** Buttony */
    JButton bPrzejdzDoMenu;
    JButton bOblicz;
    JButton bGraj;
     /** Pola tekstowe */
    JLabel LwyswietlImie;
    JLabel LwyswietlPlec;
    JLabel LwyswietlWiek;
    JLabel LwyswietlMasa;
    JLabel LwyswietlWzrost;
    JLabel LwyswietlInfo1;
    JLabel LwyswietlInfo2;
    JLabel Ldziennezapotrzebowanie;
     /** Lista wyboru */
    JComboBox Bplec;
     /** Zmienne do obliczeń poprane z pól tekstowych */
    String imie;
    String plec;
    String wiek;
    String masa;
    String wzrost;
     /** Zmienne do oblcizeń zamienione na double */
    double podanamasa;
    double podanywzrost;
    double podanywiek;
    public double liczbakalorii;
     /** Obraz tła */
    BufferedImage background;
    
     /**
     * Konstruktor - wstawienie pól tekstowych, pobieranie tekstu,
     * wyświetlenie wyniku obliczeń w polu tekstowym
     */
     public Dane() {
        
        /**Ladowanie początkowych zasobów gry */ 
        GPars.loadInitialImages();
        setLayout(null);
        
        /** Pole tekstowe */
        LwyswietlInfo1= new JLabel( "WPISZ DANE I KLIKNIJ <OBLICZ>, ABY OBLICZYĆ");
        LwyswietlInfo1.setBounds(283,100,1240,30);
        LwyswietlInfo1.setForeground(Color.BLACK);
        LwyswietlInfo1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LwyswietlInfo1);
        
        /** Pole tekstowe */
        LwyswietlInfo2= new JLabel( "DZIENNE ZAPOTRZEBOWANIE  NA KALORIE");
        LwyswietlInfo2.setBounds(320,135,1240,30);
        LwyswietlInfo2.setForeground(Color.BLACK);
        LwyswietlInfo2.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LwyswietlInfo2);
        
        /** Pole tekstowe */
        LwyswietlImie= new JLabel("IMIĘ:");
        LwyswietlImie.setBounds(250,215,100,30);
        LwyswietlImie.setForeground(Color.BLACK);
        LwyswietlImie.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlImie);
        
        /** Pole tekstowe (wpisywanie danych)*/
        timie= new JTextField();
        timie.setBounds(320,210,640,50);
        add(timie);
        
        /** Pobieranie tekstu z pola tekstowego */
        String imie = timie.getText();
        timie.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Pole tekstowe */
        LwyswietlPlec= new JLabel("PŁEĆ:");
        LwyswietlPlec.setBounds(242,315,100,30);
        LwyswietlPlec.setForeground(Color.BLACK);
        LwyswietlPlec.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlPlec);
        
         /** Lista */
        Bplec = new JComboBox ();
        Bplec.addItem("Kobieta");
        Bplec.setSelectedIndex(0);
        Bplec.addItem("Mężczyzna");
        Bplec.setBounds(320,310,640,50);
        add(Bplec);
        Bplec.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Pole tekstowe*/
        LwyswietlWiek= new JLabel("WIEK:");
        LwyswietlWiek.setBounds(242,415,100,30);
        LwyswietlWiek.setForeground(Color.BLACK);
        LwyswietlWiek.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWiek);
        
        /** Pole tekstowe (wpisywanie danych)*/
        twiek= new JTextField();
        twiek.setBounds(320,410,640,50);
        add(twiek);
        
         /** Pobieranie tekstu z pola tekstowego */
        String wiek = twiek.getText();
        twiek.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Pole tekstowe*/
        LwyswietlMasa= new JLabel("MASA:");
        LwyswietlMasa.setBounds(242,515,100,30);
        LwyswietlMasa.setForeground(Color.BLACK);
        LwyswietlMasa.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlMasa);
        
        /** Pole tekstowe (wpisywanie danych)*/
        tmasa= new JTextField();
        tmasa.setBounds(320,510,640,50);
        add(tmasa);
        
         /** Pobieranie tekstu z pola tekstowego */
        String masa = tmasa.getText();
        tmasa.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Pole tekstowe*/
        LwyswietlWzrost= new JLabel("WZROST:");
        LwyswietlWzrost.setBounds(222,615,200,30);
        LwyswietlWzrost.setForeground(Color.BLACK);
        LwyswietlWzrost.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LwyswietlWzrost);
        
        /** Pole tekstowe (wpisywanie danych)*/
        twzrost= new JTextField();
        twzrost.setBounds(320,610,640,50);
        add(twzrost);
        
         /** Pobieranie tekstu z pola tekstowego */
        String wzrost = twzrost.getText();
        twzrost.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Button przejdz do menu*/
        bPrzejdzDoMenu=new JButton ("MENU");
        bPrzejdzDoMenu.setBounds(755,760,200,70);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bPrzejdzDoMenu);
        
        /** Button graj*/
        bGraj=new JButton ("GRAJ");
        bGraj.setBounds(505,760,200,70);
        bGraj.setBackground(new Color(250,224,120));
        bGraj.setForeground(Color.BLACK);
        bGraj.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bGraj);
              
         /** Pole tekstowe*/
        Ldziennezapotrzebowanie= new JLabel( "TWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE TO: ");
        Ldziennezapotrzebowanie.setBounds(250,690,1240,30);
        Ldziennezapotrzebowanie.setForeground(Color.BLACK);
        Ldziennezapotrzebowanie.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        add(Ldziennezapotrzebowanie);
      
        /** Pole tekstowe (wpisywanie danych)*/
        tliczbakalorii= new JTextField();
        tliczbakalorii.setBounds(735,680,70,50);
        add(tliczbakalorii);
        tliczbakalorii.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Button oblicz*/
        bOblicz=new JButton ("OBLICZ");
        bOblicz.setBounds(255,760,200,70);
        bOblicz.setBackground(new Color(250,224,120));
        bOblicz.setForeground(Color.BLACK);
        bOblicz.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bOblicz);
        bOblicz.addActionListener(this);
        
        
    }
     
    /**
     * Nadpisz metodę - co wydarzy się po kliknięciu buttonu "oblicz"
     */
    @Override
    public void actionPerformed(ActionEvent e){
       
       
        /** Zamiana String (pobranego z pola tekstowego) na double*/
        podanamasa = Double.parseDouble(tmasa.getText());
        podanywzrost = Double.parseDouble(twzrost.getText());
        podanywiek = Double.parseDouble(twiek.getText());
        
        /** Jeśli wybierzemy opcję "kobieta" */
       
        if (Bplec.getSelectedIndex() == 0){
        /** Wzór obliczenia*/
        liczbakalorii = 655+(9.6*podanamasa)+(1.8*podanywzrost)-(4.7*podanywiek);
        /** Przypisanie wyniku do pola tekstowego */
        tliczbakalorii.setText(String.valueOf(liczbakalorii));
              
        }
        /** Jeśli wybierzemy opcję "mężczyzna"*/
        
        else{
        /** Wzór obliczenia*/
        liczbakalorii = 66.5+(13.7*podanamasa)+(5*podanywzrost)-(6.8*podanywiek);
        /** Przypisanie wyniku do pola tekstowego */
        tliczbakalorii.setText(String.valueOf(liczbakalorii));
        
        }
     
       /**
        * Zapis liczby kalorii do pliku
        */
        try {
            PrintWriter zapis= new PrintWriter("zapis_zapotrzebowania kalorycznego.txt");
            zapis.println("" +liczbakalorii);
            zapis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dane.class.getName()).log(Level.SEVERE, null, ex);
        }
      
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

 }    

}
