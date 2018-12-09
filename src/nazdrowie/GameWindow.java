package nazdrowie;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 *
 * @author Asia
 */

public class GameWindow extends JFrame{
    
   /**
     * Ustawianie parametrów i rozpoczęcia akcji
     * @param width szerokosc okna
     * @param height wysokosc okna
     * @param x pozycja x lewego gornego naroznika okna 
     * @param y pozycja y lewego gornego naroznika okna 
     */
    public GameWindow(int width, int height, int x, int y){
        super(); //utworz okno
        setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycje okna
        setResizable(false); //zablokuj mozliwosc zmian rozmiaru okna
        //setUndecorated(true); //ukryj ramke okna i przyciski kontrolne
        initGUI(width,height); //wywolaj metode budowy interfejsu
        setVisible(true); //pokazokno
        animationLoop(); //uruchom animacje gry
              
    }//koniec GameWindow()   
    
    /**
     * Utworz interfejs graficzny uzytkownika
     * @param width szerokoscokna
     * @param height wysokosc okna
     */
    private void initGUI(int width, int height){
        setLayout(new GridLayout(1,1)); //ustaw rozklad 
        //ustaw zasoby i parametry poczatkowe
        GPars.loadInitialImages();
        Toolkit tk = Toolkit.getDefaultToolkit();
       
        add(new GamePanel(width,height)); //dodaj panel gry zawierajcy grafike i akcje
    }//koniec initGUI()
    
    /**
     * Glowna petla gry - takt animacji 
     */
    
    private void animationLoop() {
        
        
        //pobierz liczbe milisekund od daty referencyjnej (w ms) 
        GPars.startTime = System.currentTimeMillis();
        long currTime = GPars.startTime;

        while (currTime - GPars.startTime < GPars.GAME_TIME) {
          long elapsedTime = System.currentTimeMillis() - currTime;
          //licz czas gry 
          currTime += elapsedTime;
          
          //odrysuj kolejny ekran gry (nowe pozycje obiektow - symulacja ruchu)
          repaint();
          
          // przerwa w czasie
          try {
            Thread.sleep(80);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }//koniec while
    }//koniec animationLoop()
  
}//koniec class GameWindow

