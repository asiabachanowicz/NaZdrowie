
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
       //pasek z liczba kalorii
    public static Image ilekalorii;
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
    /**  Tablica obiektow pierwszego planu -niezdrowe jedzenie   */
    public static Image[] fastfood;
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


         //tablica ze zdrowymi produktami
        food= new Image[24];
        food[0]=loadImage("images/strawberry.png");
        food[1]=loadImage("images/pear.png");
        food[2]=loadImage("images/banana.png");
        food[3]=loadImage("images/apple.png");
        food[4]=loadImage("images/pineapple.png");
        food[5]=loadImage("images/raspberry.png");
        food[6]=loadImage("images/watermelon.png");
        food[7]=loadImage("images/orange.png");
        food[8]=loadImage("images/grapes.png");
        food[9]=loadImage("images/brecol.png");
        food[10]=loadImage("images/corn.png");
        food[11]=loadImage("images/baklazan.png");
        food[12]=loadImage("images/tomatoe.png");
        food[13]=loadImage("images/kapusta.png");
        food[14]=loadImage("images/carrot.png");
        food[15]=loadImage("images/pepper.png");
        food[16]=loadImage("images/veg.png");
        food[17]=loadImage("images/onion.png");
        food[18]=loadImage("images/por.png");
        food[19]=loadImage("images/cucumber.png");
        food[20]=loadImage("images/milk.png");
        food[21]=loadImage("images/salad.png");
        food[22]=loadImage("images/eggs.png");
        food[23]=loadImage("images/juice.png");
        
         //tablica z niezdrowymi produktami
        fastfood= new Image[25];
        fastfood[0]=loadImage("images/pizza.png");
        fastfood[1]=loadImage("images/cake.png");
        fastfood[2]=loadImage("images/coke.png");
        fastfood[3]=loadImage("images/hamburger.png");
        fastfood[4]=loadImage("images/hotdog.png");
        fastfood[5]=loadImage("images/fries.png");
        fastfood[6]=loadImage("images/chocolate.png");
        fastfood[7]=loadImage("images/kitcat.png");
        fastfood[8]=loadImage("images/twix.png");
        fastfood[9]=loadImage("images/sweet.png");
        fastfood[10]=loadImage("images/icecream.png");
        fastfood[11]=loadImage("images/lolpop.png");
        fastfood[12]=loadImage("images/pancake.png");
        fastfood[13]=loadImage("images/bread.png");
        fastfood[14]=loadImage("images/ketchup.png");
        fastfood[15]=loadImage("images/mustard.png");
        fastfood[16]=loadImage("images/popcorn.png");
        fastfood[17]=loadImage("images/beer.png");
        fastfood[18]=loadImage("images/sushi.png");
        fastfood[19]=loadImage("images/majo.png");
        fastfood[20]=loadImage("images/wine.png");
        fastfood[21]=loadImage("images/fanta.png");
        fastfood[22]=loadImage("images/sprite.png");
        fastfood[23]=loadImage("images/piernik.png");
        fastfood[24]=loadImage("images/becon.png");
    }//koniec loadInitialImages()
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie sciezki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
    
}//koniec class GameParameters

