
package nazdrowie;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Klasa - kontener parametrow
 * 
 *
 * @author Asia
 */
 
public class GPars {
    /**  Dopuszczalny czas gry   */
    public static long GAME_TIME=Long.MAX_VALUE;
    /**  Liczba poziomĂłw gry   */
    public final static long NO_LEVELS=5;
    /**  Obraz tla   */
    public static Image bgImage;
    //Tło menu
    public static Image menubackground;
  
    /**  tlo Menu  */
    public static Image bgMenu;
     /**  Obraz ludzika   */
    public static Image body;
       /**  Obraz minilogo   */
    public static Image minilogo;
    /**  Obraz ikony logo   */
    public static Image logoImage;
    /**  Obraz straty zycia   */
    public static Image zycia;    
    /**  Tablica obiektow pierwszego planu   */
    public static Image[] food;
    /**  Zmienna stanu okreslajaca czy jest przerwa w grze   */
    public static boolean pause=false;
    /** Zmienna stanu okreslajaca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza okreslajaca czas poczatkowy gry */
    public static long startTime;
    /** Zmienna pomocnicza okreslajaca czas ukonczenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza okreslajaca aktualny poziom gry */
    public static int MoveMODE=1;
    /** Zmienna pomocnicza okreslajaca status ukonczonej gry */
    public static boolean end=false;
    /** Zmienna pomocnicza okreslajaca max liczbe obiektow pierwszego planu */
    public static int noOfObjects=6;
    /** Szerokosc pola graficznego gry */
    public static int gWidth=1280;
    /** Wysokosc pola graficznego gry */
    public static int gHeight=900;
    
    /**
     * Metoda ladowania poczatkowych zasobow gry
     */
        
    
    public static void loadInitialImages() {
        
        bgImage = loadImage("images/tlo.jpg");       
        logoImage=loadImage("images/logo.png");
        body=loadImage("images/body.png");
        zycia=loadImage("images/pizza2.png");
        minilogo=loadImage("images/logomini.png");


        food= new Image[5];
        food[0]=loadImage("images/strawberry.png");
        food[1]=loadImage("images/pizza.png");
        food[2]=loadImage("images/cake.png");
        food[3]=loadImage("images/pear.png");
        food[4]=loadImage("images/banana.png");
    }//koniec loadInitialImages()
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie sciezki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
    
}//koniec class GameParameters

