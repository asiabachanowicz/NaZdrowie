
package nazdrowie;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author Asia
 */

public class GamePanel extends JPanel implements ActionListener, KeyListener  {
    /** Szerokosc pola graficznego gry*/
    public int sWidth;
    /** Wysokosc pola graficznego gry*/
    public int sHeight;
    /** Liczba obiektow w linii*/
    public int objectsInLine;
    /** Przesuniecie liniami ze spadajacymi obiektami*/
    public int shiftBL;
    /** Obiekt reprezentujacy status gry*/
    public GameStatus gStatus;
    /** Wysokosc paska menu*/
    public int barHeight;
    /** Czcionki stosowane w pasku Menu*/
    public Font menuFont;
    /** Czcionki stosowane jako alert w polu gry*/
    public Font alertFont;
    /** Tablica obiektow pierwszego planu - spadajace jedzenie*/ 
    private FlyingFood [] fFood;
    JLabel LPoziom;
    JLabel LKalorie;
    JLabel LZycia;
   
    
    Timer t = new Timer (1, this);
    double x=525, y=550, velx=0, vely=0;
    
    
    /**
     * Konstruktor klasy pola graficznego gry.
     * @param width SzerokoĹ›Ä‡ pola graficznego gry
     * @param height WysokoĹ›Ä‡ pola graficznego gry
     */
    public GamePanel(int width, int height){
        
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
                       
        gStatus=new GameStatus();
        gStatus.reset();
               
        this.sWidth=width;
        this.sHeight=height;
        barHeight=100;
                       
        objectsInLine=1;
        shiftBL=sHeight/(GPars.noOfObjects/objectsInLine);
        fFood=new FlyingFood[GPars.noOfObjects];
          restartGame();                  
        
        
        /* Dodaj obsluge zdarzen - klikniecie przycisku myszki*/
        addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
              
              //inaczej sprawdz czy trafiono spadajacy obiekt
              for(int i=0;i<fFood.length;i++){
                  if(me.getY()<(sHeight-barHeight)){
                      if(fFood[i].containsPoint(me.getX(), me.getY())){
                          if(!fFood[i].hit){
                              fFood[i].setHit();
                              gStatus.points++;
                          }
                      }
                  }
              }
          }//koniec mouseClicked()
      });
        
        
    }//koniec GamePanel()
        
    /**
     * Odrysowanie panelu
     * @param gs 
     */
    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakosci grafiki
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Narysuj tlo
        g.drawImage(GPars.bgImage, 0, 0, null); 
        
        //Narysuj ludzika
        g.drawImage(GPars.body, (int)x, (int)y, null);
                
        //Na tle obiektu pierwszego planu
        for(int i=0;i<fFood.length;i++){
            fFood[i].calculatePathPos(GPars.MoveMODE);
            if(!fFood[i].hit)
                g.drawImage(fFood[i].icon,fFood[i].currX-80,0+fFood[i].currY,(int)(fFood[i].icon.getWidth(null)), (int)(fFood[i].icon.getHeight(null)),null);
        }
              
        //Ustaw kolor dolnego paska Menu i narysuj pasek
        g.setColor(new Color(250,224,171));
        g.fillRect(0, 800, 1280, 100);
             
        //Napisy w pasku Menu
        
        LPoziom= new JLabel("POZIOM "+gStatus.level);
        LPoziom.setBounds(100,785,200,100);
        LPoziom.setForeground(Color.BLACK);
        LPoziom.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LPoziom);
        
        LKalorie= new JLabel("KALORIE "+gStatus.points);
        LKalorie.setBounds(400,785,200,100);
        LKalorie.setForeground(Color.BLACK);
        LKalorie.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LKalorie);
        
        //ikona opisujaca liczbe zyc        
        g.drawImage(GPars.zycia, 700, 772, null);
        //wyswietlanie liczby zyc
        LZycia= new JLabel(":"+gStatus.liczbazyc);
        LZycia.setBounds(800,785,200,100);
        LZycia.setForeground(Color.BLACK);
        LZycia.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        add(LZycia);
        //wyswietlanie logo w rogu gry        
        g.drawImage(GPars.minilogo, 990, 750, null);
        
        
        // Przycisk Menu
        setLayout(null);
        JButton button_menu= new JButton("MENU");
        button_menu.setBackground(new Color(250,224,120));
        button_menu.setForeground(Color.BLACK);
        button_menu.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        button_menu.setBounds(1000, 800, 200, 100);
        add(button_menu);
        
         }//
      
    
    @Override
    public void actionPerformed(ActionEvent e) {
      repaint ();
      x += velx;
      y += vely;
       
    }
               
       public void left() {

           vely= 0;
           velx= -5;
    
        }
       
       public void right() {

           vely= 0;
           velx= 5;

}
       public void rightSTOP() {

           vely= 0;
           velx= 0;

}
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
       
       public void keyReleased (KeyEvent e) {
           
       int code = e.getKeyCode();
       if (code == KeyEvent.VK_RIGHT){
            rightSTOP();
           
       }
       if (code == KeyEvent.VK_LEFT){
            leftSTOP();
           
       }
       }       
       
    
    private void restartGame(){
        gStatus.resetPoints();
        GPars.startTime=System.currentTimeMillis();
        GPars.pause=false;
        int offset=sWidth/objectsInLine; 
        int inLine=0;    
        int yLine=0;
        for(int i=0; i<GPars.noOfObjects;i++){
         
            fFood[i]=new FlyingFood((((inLine%objectsInLine)+1)*offset)-GPars.food[(i%GPars.food.length)].getWidth(null),0,100,0.0025,GPars.food);
            fFood[i].setScreenSize(sWidth, sHeight);

            if(inLine>=objectsInLine){
                yLine++;
                inLine%=objectsInLine;
            }
            inLine++;
            fFood[i].setYPos(yLine*shiftBL*-1);
            
        }//koniec for i
        
    }//koniec restartGame()

}//koniec klasy GamePanel
