/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nazdrowie;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Główny obszar graficzny gry - poziom 1 
 * @author Asia
 */


public class GamePanel extends JPanel implements ActionListener, KeyListener   {
    
    /**liczba obiektow w linii (zdrowe) */
    public int objectsInLine;
    /**Liczba obiektow w linii (niezdrowe) */
    public int objectsInLine2;
    /** Przesuniecie liniami ze spadajacymi obiektami (zdrowe)*/
    public int shiftBL;
    /** Przesuniecie liniami ze spadajacymi obiektami (niezdrowe)*/
    public int shiftBL2;
    /**Obiekt reprezentujacy status gry */
    public GameStatus gStatus;
    /**Wysokosc paska menu */
    public int barHeight;
    /**Tablica obiektow pierwszego planu - spadajace zdrowe jedzenie  */
    public FlyingFood [] fFood;
    /**Tablica obiektow pierwszego planu - spadajace niezdrowe jedzenie  */
    public FlyingFood [] fFood2;
    /**Obiekt reprezentujacy parametry gry */
    public GPars gPars;   
    /**Obiekt reprezentujacy spadające jedzenie */
    public FlyingFood fFlying;
    /**Czcionki */
    public Font menuFont;
    public Font menuFont2;
    /**Czy gre wygrano/przegrano*/
    public boolean przegrano=false;
    public boolean wygrano=false;
    /**Obliczone dzienne zapotrzebowanie na kalorie */
    public double kalorie;
    /**Pola tekstowe, buttony */
    JLabel LPoziom;
    JLabel LKalorie;
    JLabel LZycia;
    JLabel LDoZdobycia;
    JLabel LKoniecGry;
    JLabel LKoniecGry2;
    JLabel LKoniecGry3;
    JLabel LKoniecGry4;
    JLabel LKoniecGry5;
    JButton bMenu;
    JButton bPoziom2;
  
    Timer t = new Timer (5, this);
    /** Początkowe wspolrzedne ludzika, przesunięcie współrzędnych*/
    public double x=525, y=550, velx=0, vely=0;
   
    /**
     * Konstruktor klasy pola graficznego gry.
     * Ustawienia początkowe oraz ładowanie zasobów
     * Ponadto dodanie obsługi zdarzeń w polu graficznym gry
     */
    public GamePanel(){
        
        gStatus=new GameStatus();
        gStatus.level=1;
        GPars.MoveMODE=1;
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);       
        
        menuFont=new Font("Dialog",Font.BOLD,40);
        
        // Przycisk Menu
        setLayout(null);
        bMenu= new JButton("MENU");
        bMenu.setBackground(new Color(250,224,120));
        bMenu.setForeground(Color.BLACK);
        bMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        bMenu.setBounds(1000, 800, 200, 70);
        add(bMenu);
        
        
        // Przycisk ->Poziom
        setLayout(null);
        bPoziom2= new JButton("->POZIOM");
        bPoziom2.setBackground(new Color(250,224,120));
        bPoziom2.setForeground(Color.BLACK);
        bPoziom2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        bPoziom2.setBounds(1000, 730, 200, 70);
        add(bPoziom2);
           
        barHeight=100; //szerokosc paska menu 
        objectsInLine=1;
        shiftBL=900/(6/objectsInLine);
        fFood=new FlyingFood[3];
        
        objectsInLine2=1;
        shiftBL2=900/(6/objectsInLine2);
        fFood2=new FlyingFood[3];
        
        restartGame();   
       
    }//koniec GamePanel()
   
    /**
     * Odrysowanie panelu - własne wypełnienie pola graficznego gry
     * @param gs 
     */
    
    public void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        
        //Ustaw tryb lepszej jakosci grafiki
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Narysuj tlo
        g.drawImage(GPars.bgImage, 0, 0, null); 
        
        //Narysuj ludzika
        g.drawImage(GPars.body, (int)x, (int)y, null);
                
        //Na tle obiektu pierwszego planu
        //zdrowe jedzenie
        
        if(przegrano==false == wygrano==false){
        for(int i=0;i<fFood.length;i++){
            fFood[i].calculatePathPos(GPars.MoveMODE=1);
                if(!fFood[i].hit){
                    g.drawImage(fFood[i].icon,fFood[i].currX+50,fFood[i].currY+80,(int)(fFood[i].icon.getWidth(null) ), (int)(fFood[i].icon.getHeight(null)),null); 
                }
        }
        //niezdrowe jedzenie
        for(int i=0;i<fFood2.length;i++){
            fFood2[i].calculatePathPos(GPars.MoveMODE=1);
                if(!fFood2[i].hit){
                    g.drawImage(fFood2[i].icon,fFood2[i].currX+50,fFood2[i].currY+80,(int)(fFood2[i].ikona.getWidth(null) ), (int)(fFood2[i].ikona.getHeight(null)),null); 
                }
            }
        }
        
        // gdy zlapano zdrowy obiekt
        for(int i=0;i<fFood.length;i++){
            if(fFood[i].hit){
               //odrysowanie elementow
               g.drawImage(fFood[i].icon,fFood[i].currX+50,fFood[i].currY=0,(int)(fFood[i].icon.getWidth(null) ), (int)(fFood[i].icon.getHeight(null)),null);  
               fFood[i].hit=false;

               //odtworzenie dzwieku
               playSound(new File("sounds/eatingsound.wav"));
               //zwiekszamy liczbe punktow
               if (gStatus.liczbazyc>=1){
               gStatus.points+=70;
               }
            }
        }
        
        // gdy zlapano niezdrowy obiekt
        for(int i=0;i<fFood2.length;i++){
            if(fFood2[i].hit){
                //odrysowanie elementow
                g.drawImage(fFood2[i].icon,fFood2[i].currX+50,fFood2[i].currY=0,(int)(fFood2[i].ikona.getWidth(null) ), (int)(fFood2[i].ikona.getHeight(null)),null);  
                fFood2[i].hit=false;
                //zmniejszamy liczbe zyc
                gStatus.liczbazyc--;
                //odtworzenie dzwieku
                playSound(new File("sounds/error.wav"));
                //zwiekszamy liczbe punktow
                if (gStatus.liczbazyc>=1){
                gStatus.points+=200;
                }
            }      
        }
        
        //Ustaw kolor dolnego paska Menu i narysuj pasek
        g.setColor(new Color(250,224,171));
        g.fillRect(0, 800, 1280, 100);
        
        //Informacja o liczbie kalorii do zdobycia
        g.drawImage(GPars.ilekalorii, 785, 15, null);  
        
     /**
     * Pobieranie z pliku i wyświetlanie liczby kalorii do zdobycia
     */
          try {
            Scanner odczyt = new Scanner(new File("zapis_zapotrzebowania kalorycznego.txt"));
            String zdanie = odczyt.nextLine();
	    LDoZdobycia= new JLabel(zdanie);
            LDoZdobycia.setBounds(890,35,200,100);
            LDoZdobycia.setForeground(Color.RED);
            LDoZdobycia.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            add(LDoZdobycia);
            String dozdobycia = LDoZdobycia.getText();
            kalorie = Double.parseDouble(LDoZdobycia.getText());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //czy najchechano ludzikiem na zdrowy obiekt
            for(int i=0;i<fFood.length;i++){
                if((x+75)<=(fFood[i].currX+100) && (x+75)>=fFood[i].currX  ){
                    if(550<=(fFood[i].currY+100) && (fFood[i].currY+100)<=773){  
                        if(!fFood[i].hit){
                        fFood[i].setHit();
                        }
                    }
                }
            }
            
        //czy najchechano ludzikiem na niezdrowy obiekt
        for(int i=0;i<fFood2.length;i++){
            if((x+75)<=(fFood2[i].currX+100) && (x+75)>=fFood2[i].currX  ){
                if(550<=(fFood2[i].currY+100) && (fFood2[i].currY+100)<=773){  
                    if(!fFood2[i].hit){
                      fFood2[i].setHit();
                    }
                }
            }
        }
            
        //koniec gry gdy stracono zycia
        if(gStatus.liczbazyc==0 ){
            //napisy po przegraniu gry
            LKoniecGry= new JLabel("KONIEC GRY");
            LKoniecGry.setBounds(400,250,1000,300);
            LKoniecGry.setForeground(Color.red);
            LKoniecGry.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
            add(LKoniecGry);

            LKoniecGry4= new JLabel("ZAJRZYJ DO INFORMACJI O PRODUKTACH!");
            LKoniecGry4.setBounds(220,350,1200,300);
            LKoniecGry4.setForeground(Color.black);
            LKoniecGry4.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            add(LKoniecGry4);
            
            przegrano=true;
            wygrano=false;
        }
            
        //gdy zdobyto dzienne zapotrzebowanie - wygrana
        if(gStatus.points>=kalorie){
           //napisy gry wygrano 
           LKoniecGry= new JLabel("WYGRAŁEŚ!");
           LKoniecGry.setBounds(415,280,370,80);
           LKoniecGry.setForeground(Color.red);
           LKoniecGry.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
           add(LKoniecGry);

           LKoniecGry2= new JLabel("ZDOBYŁEŚ SWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE");
           LKoniecGry2.setBounds(70,380,1200,50);
           LKoniecGry2.setForeground(new Color(5,205,105));
           LKoniecGry2.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
           add(LKoniecGry2);

           LKoniecGry3= new JLabel(" " +gStatus.points+ " KCAL");
           LKoniecGry3.setBounds(505,440,400,50);
           LKoniecGry3.setForeground(new Color(5,205,105));
           LKoniecGry3.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
           add(LKoniecGry3);

           LKoniecGry5= new JLabel("PRZEJDŹ DO POZIOMU 2");
           LKoniecGry5.setBounds(385,500,800,50);
           LKoniecGry5.setForeground(Color.red);
           LKoniecGry5.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
           add(LKoniecGry5);

           wygrano=true;
           przegrano=false;
        }

        
        //Napisy w pasku Menu    
        //wyswietlanie poziomu
        LPoziom= new JLabel("POZIOM "+gStatus.level);
        LPoziom.setBounds(100,785,200,100);
        LPoziom.setForeground(Color.BLACK);
        LPoziom.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LPoziom);
        
        //Ustaw kolor napisu kalorii
        g.setColor(new Color(12,203,107));;
               
        //Ustaw czcionki do wypelnienia paska Menu
        g.setFont(menuFont);
        
        //wyswietlanie liczby zdobytych kalorii
        g.drawString(""+gStatus.points,600, 845);
        LKalorie= new JLabel("KALORIE ");
        LKalorie.setBounds(400,785,200,100);
        LKalorie.setForeground(Color.BLACK);
        LKalorie.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LKalorie);
        
        //ikona opisujaca liczbe zyc        
        g.drawImage(GPars.zycia, 700, 772, null);
        
        //Ustaw kolor napisu liczby żyć
        g.setColor(new Color(252,79,54));;
        
        //wyswietlanie liczby dostepnych zyc
        g.drawString(""+gStatus.liczbazyc,825, 845);
        LZycia= new JLabel(":");
        LZycia.setBounds(800,785,200,100);
        LZycia.setForeground(Color.BLACK);
        LZycia.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LZycia);
        
        //wyswietlanie logo w rogu okna       
        g.drawImage(GPars.minilogo, 0, 750, null);
    }
    
    //sterowanie ludzikiem za pomoca strzalek
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
      repaint ();
      requestFocus();
      
      if(przegrano==false == wygrano==false){
        //zwiekszenie/zmniejszenie wspolrzednej x
        x += velx;
      }
    }
    /**
     *Metoda opisująca co się zdarzy gdy klikniemy strzałkę w lewo
     */           
       public void left() {
           vely= 0;
           velx= -7;
    
        }
    /**
     *Metoda opisująca co się zdarzy gdy klikniemy strzałkę w prawo
     */      
       public void right() {

           vely= 0;
           velx= 7;

}
     /**
     *Metoda opisująca ograniczenie sterowania w prawo
     */   
       public void rightSTOP() {

           vely= 0;
           velx= 0;

}
     /**
     *Metoda opisująca ograniczenie sterowania w lewo
     */  
       public void leftSTOP() {

           vely= 0;
           velx= 0;

}
    
       public void keyPressed(KeyEvent e){
       
       int code = e.getKeyCode();
       
       if (code == KeyEvent.VK_RIGHT){
           right();         
        }
       if (code == KeyEvent.VK_LEFT){
           left();         
         
        }
      
       }
       
       public void keyTyped(KeyEvent e){}
      
       
    //ograniczenie sterowania
       
       public void keyReleased (KeyEvent e) {
           
       int code = e.getKeyCode();
       if (code == KeyEvent.VK_RIGHT){
            rightSTOP();
           
       }
       if (code == KeyEvent.VK_LEFT){
            leftSTOP();
           
       }
       }       
       
    /**
     * Restart gry - ustawienia parametrĂłw oraz obiektĂłw pierwszego planu
     * 
     */   
      
   private void restartGame(){
        gStatus.resetPoints();
        
        
        int offset=1200/objectsInLine; 
        int inLine=0;    
        int yLine=0;
        for(int i=0; i<3;i++){
         
            fFood[i]=new FlyingFood((((inLine%objectsInLine)+1)*offset)-GPars.food[(i%GPars.food.length)].getWidth(null),0,100,0.0025,GPars.food);
            fFood[i].setScreenSize(1200, 900);
            
            fFood2[i]=new FlyingFood((((inLine%objectsInLine2)+1)*offset)-GPars.fastfood[(i%GPars.fastfood.length)].getWidth(null),0,100,0.0025,GPars.fastfood);
            fFood2[i].setScreenSize(1200, 900);
            
                 
            if(inLine>=objectsInLine){
                yLine++;
               
            }
            inLine++;
            fFood[i].setYPos(yLine*shiftBL*-1);
            fFood2[i].setYPos(yLine*shiftBL2*-1);
           
        }
        
              
    }
    /**
     * Funkcja odtwarzania dźwięku z pliku
     * @param f - obiekt klasy File reprezentujący ścieżkę do pliku
     */ 
   
     
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }
   
}//koniec klasy GamePanel
