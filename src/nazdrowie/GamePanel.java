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
    public boolean loss=false;
    public boolean win=false;
    /**Obliczone dzienne zapotrzebowanie na kalorie */
    public double calories;
    /**Pola tekstowe, buttony */
    JLabel LLevel;
    JLabel LCalories;
    JLabel LFail;
    JLabel LToBeWon;
    JButton bMenu;
    JButton bLevel2;
  
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
        gStatus.reset();
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
        bLevel2= new JButton("->POZIOM");
        bLevel2.setBackground(new Color(250,224,120));
        bLevel2.setForeground(Color.BLACK);
        bLevel2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        bLevel2.setBounds(1000, 730, 200, 70);
        add(bLevel2);
           
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
        
        if(loss==false == win==false){
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
                    g.drawImage(fFood2[i].icon,fFood2[i].currX+50,fFood2[i].currY+80,(int)(fFood2[i].iconUnhealthy.getWidth(null) ), (int)(fFood2[i].iconUnhealthy.getHeight(null)),null); 
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
               if (gStatus.fail>=1){
               gStatus.points+=70;
               }
            }
        }
        
        // gdy zlapano niezdrowy obiekt
        for(int i=0;i<fFood2.length;i++){
            if(fFood2[i].hit){
                //odrysowanie elementow
                g.drawImage(fFood2[i].icon,fFood2[i].currX+50,fFood2[i].currY=0,(int)(fFood2[i].iconUnhealthy.getWidth(null) ), (int)(fFood2[i].iconUnhealthy.getHeight(null)),null);  
                fFood2[i].hit=false;
                //zmniejszamy liczbe zyc
                gStatus.fail--;
                //odtworzenie dzwieku
                playSound(new File("sounds/error.wav"));
                //zwiekszamy liczbe punktow
                if (gStatus.fail>=1){
                gStatus.points+=200;
                }
            }      
        }
        
        //Ustaw kolor dolnego paska Menu i narysuj pasek
        g.setColor(new Color(250,224,171));
        g.fillRect(0, 800, 1280, 100);
        
        //Informacja o liczbie kalorii do zdobycia
        g.drawImage(GPars.calories, 785, 15, null);  
        
     /**
     * Pobieranie z pliku i wyświetlanie liczby kalorii do zdobycia
     */
          try {
            Scanner odczyt = new Scanner(new File("zapis_zapotrzebowania kalorycznego.txt"));
            String zdanie = odczyt.nextLine();
	    LToBeWon= new JLabel(zdanie);
            LToBeWon.setBounds(890,35,200,100);
            LToBeWon.setForeground(Color.RED);
            LToBeWon.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            add(LToBeWon);
            String dozdobycia = LToBeWon.getText();
            calories = Double.parseDouble(LToBeWon.getText());
            
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
        if(gStatus.fail==0 ){
            
            //napisy po przegraniu gry
            g.setColor(Color.red);;
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
            g.drawString("KONIEC GRY",400, 350);
            
            g.setColor(Color.black);;
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            g.drawString("ZAJRZYJ DO INFORMACJI O PRODUKTACH!",220, 450);
           
            loss=true;
            win=false;
        }
            
        //gdy zdobyto dzienne zapotrzebowanie - wygrana
        if(gStatus.points>=calories){
           //napisy gry wygrano 
            g.setColor(Color.red);;
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
            g.drawString("WYGRAŁEŚ!",415, 280);
            
            g.setColor(new Color(5,205,105));
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            g.drawString("ZDOBYŁEŚ SWOJE DZIENNE ZAPOTRZEBOWANIE NA KALORIE",70, 380);
            
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            g.drawString(" " +gStatus.points+ " KCAL",505, 440);
            
            g.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
            g.drawString("PRZEJDŹ DO POZIOMU 2",385, 500);
            
           win=true;
           loss=false;
        }

        
        //Napisy w pasku Menu    
        //wyswietlanie poziomu
        LLevel= new JLabel("POZIOM "+gStatus.level);
        LLevel.setBounds(100,785,200,100);
        LLevel.setForeground(Color.BLACK);
        LLevel.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LLevel);
        
        //Ustaw kolor napisu kalorii
        g.setColor(new Color(12,203,107));;
               
        //Ustaw czcionki do wypelnienia paska Menu
        g.setFont(menuFont);
        
        //wyswietlanie liczby zdobytych kalorii
        g.drawString(""+gStatus.points,600, 845);
        LCalories= new JLabel("KALORIE ");
        LCalories.setBounds(400,785,200,100);
        LCalories.setForeground(Color.BLACK);
        LCalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LCalories);
        
        //ikona opisujaca liczbe zyc        
        g.drawImage(GPars.fail, 700, 772, null);
        
        //Ustaw kolor napisu liczby żyć
        g.setColor(new Color(252,79,54));;
        
        //wyswietlanie liczby dostepnych zyc
        g.drawString(""+gStatus.fail,825, 845);
        LFail= new JLabel(":");
        LFail.setBounds(800,785,200,100);
        LFail.setForeground(Color.BLACK);
        LFail.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LFail);
        
        //wyswietlanie logo w rogu okna       
        g.drawImage(GPars.minilogo, 0, 750, null);
    }
    
    //sterowanie ludzikiem za pomoca strzalek
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
      repaint ();
      requestFocus();
      
      if(loss==false == win==false){
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
      
   public void restartGame(){
       
        gStatus.resetPoints();
        gStatus.reset();
        gStatus.level=1;
        loss=false;
        win=false;
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
