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
    JTextField tname;
    JTextField tage;
    JTextField tweight;
    JTextField theight;
    JTextField tcalories;
     /** Buttony */
    JButton bMenu;
    JButton bCalculate;
    JButton bPlay;
     /** Pola tekstowe */
    JLabel LName;
    JLabel LSex;
    JLabel LAge;
    JLabel LWeight;
    JLabel LHeight;
    JLabel LInfo1;
    JLabel LInfo2;
    JLabel LDailyCalories;
     /** Lista wyboru */
    JComboBox BSex;
     /** Zmienne do obliczeń poprane z pól tekstowych */
    String name;
    String age;
    String weight;
    String height;
     /** Zmienne do oblcizeń zamienione na double */
    double givenweight;
    double givenheight;
    double givenage;
    public double numberofcalories;
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
        LInfo1= new JLabel( "WPISZ DANE I KLIKNIJ <OBLICZ>, ABY OBLICZYĆ");
        LInfo1.setBounds(283,100,1240,30);
        LInfo1.setForeground(Color.BLACK);
        LInfo1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LInfo1);
        
        /** Pole tekstowe */
        LInfo2= new JLabel( "DZIENNE ZAPOTRZEBOWANIE  NA KALORIE");
        LInfo2.setBounds(320,135,1240,30);
        LInfo2.setForeground(Color.BLACK);
        LInfo2.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        add(LInfo2);
        
        /** Pole tekstowe */
        LName= new JLabel("IMIĘ:");
        LName.setBounds(250,215,100,30);
        LName.setForeground(Color.BLACK);
        LName.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LName);
        
        /** Pole tekstowe (wpisywanie danych)*/
        tname= new JTextField();
        tname.setBounds(320,210,640,50);
        add(tname);
        
        /** Pobieranie tekstu z pola tekstowego */
        String name = tname.getText();
        tname.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Pole tekstowe */
        LSex= new JLabel("PŁEĆ:");
        LSex.setBounds(242,315,100,30);
        LSex.setForeground(Color.BLACK);
        LSex.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LSex);
        
         /** Lista */
        BSex = new JComboBox ();
        BSex.addItem("Kobieta");
        BSex.setSelectedIndex(0);
        BSex.addItem("Mężczyzna");
        BSex.setBounds(320,310,640,50);
        add(BSex);
        BSex.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Pole tekstowe*/
        LAge= new JLabel("WIEK:");
        LAge.setBounds(242,415,100,30);
        LAge.setForeground(Color.BLACK);
        LAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LAge);
        
        /** Pole tekstowe (wpisywanie danych)*/
        tage= new JTextField();
        tage.setBounds(320,410,640,50);
        add(tage);
        
         /** Pobieranie tekstu z pola tekstowego */
        String age = tage.getText();
        tage.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Pole tekstowe*/
        LWeight= new JLabel("MASA:");
        LWeight.setBounds(242,515,100,30);
        LWeight.setForeground(Color.BLACK);
        LWeight.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LWeight);
        
        /** Pole tekstowe (wpisywanie danych)*/
        tweight= new JTextField();
        tweight.setBounds(320,510,640,50);
        add(tweight);
        
         /** Pobieranie tekstu z pola tekstowego */
        String weight = tweight.getText();
        tweight.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Pole tekstowe*/
        LHeight= new JLabel("WZROST:");
        LHeight.setBounds(222,615,200,30);
        LHeight.setForeground(Color.BLACK);
        LHeight.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        add(LHeight);
        
        /** Pole tekstowe (wpisywanie danych)*/
        theight= new JTextField();
        theight.setBounds(320,610,640,50);
        add(theight);
        
         /** Pobieranie tekstu z pola tekstowego */
        String height = theight.getText();
        theight.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
        /** Button przejdz do menu*/
        bMenu=new JButton ("MENU");
        bMenu.setBounds(755,760,200,70);
        bMenu.setBackground(new Color(250,224,120));
        bMenu.setForeground(Color.BLACK);
        bMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bMenu);
        
        /** Button graj*/
        bPlay=new JButton ("GRAJ");
        bPlay.setBounds(505,760,200,70);
        bPlay.setBackground(new Color(250,224,120));
        bPlay.setForeground(Color.BLACK);
        bPlay.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bPlay);
              
         /** Pole tekstowe*/
        LDailyCalories= new JLabel( "TWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE TO: ");
        LDailyCalories.setBounds(250,690,1240,30);
        LDailyCalories.setForeground(Color.BLACK);
        LDailyCalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        add(LDailyCalories);
      
        /** Pole tekstowe (wpisywanie danych)*/
        tcalories= new JTextField();
        tcalories.setBounds(735,680,70,50);
        add(tcalories);
        tcalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
        
         /** Button oblicz*/
        bCalculate=new JButton ("OBLICZ");
        bCalculate.setBounds(255,760,200,70);
        bCalculate.setBackground(new Color(250,224,120));
        bCalculate.setForeground(Color.BLACK);
        bCalculate.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        add(bCalculate);
        bCalculate.addActionListener(this);
        
        
    }
     
    /**
     * Nadpisz metodę - co wydarzy się po kliknięciu buttonu "oblicz"
     */
    @Override
    public void actionPerformed(ActionEvent e){
       
       
        /** Zamiana String (pobranego z pola tekstowego) na double*/
        givenweight = Double.parseDouble(tweight.getText());
        givenheight = Double.parseDouble(theight.getText());
        givenage = Double.parseDouble(tage.getText());
        
        /** Jeśli wybierzemy opcję "kobieta" */
       
        if (BSex.getSelectedIndex() == 0){
        /** Wzór obliczenia*/
        numberofcalories = 655+(9.6*givenweight)+(1.8*givenheight)-(4.7*givenage);
        /** Przypisanie wyniku do pola tekstowego */
        tcalories.setText(String.valueOf(numberofcalories));
              
        }
        /** Jeśli wybierzemy opcję "mężczyzna"*/
        
        else{
        /** Wzór obliczenia*/
        numberofcalories = 66.5+(13.7*givenweight)+(5*givenheight)-(6.8*givenage);
        /** Przypisanie wyniku do pola tekstowego */
        tcalories.setText(String.valueOf(numberofcalories));
        
        }
     
       /**
        * Zapis liczby kalorii do pliku
        */
        try {
            PrintWriter zapis= new PrintWriter("zapis_zapotrzebowania kalorycznego.txt");
            zapis.println("" +numberofcalories);
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
