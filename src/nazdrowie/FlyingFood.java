
package nazdrowie;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author Asia
 */

public class FlyingFood {
    /** Początkowa współrzędna x spadającego obiektu */
    public int x;
    /** Początkowa współrzędna y spadającego obiektu */
    public int y;
    /** Aktualna współrzędna x spadającego obiektu */
    public int currX;
    /** Aktualna współrzędna y spadającego obiektu */
    public int currY;
    /** Szerokosc ikony spadajacego obiektu  */
    public int width;
    /** Wysokosc ikony spadajacego obiektu */
    public int height;
    /** Krok przesuniecia obiektu z dolu do gory */
    public int dy;
    /** Kąt w funkcji sinus opisującej ruch spadajcego obiektu */
    private double angle;
    /** Amplituda w funkcji sinus opisujacej ruch spadajacego obiektu */
    public int ampl;
    /** Czestotliwosc funkcji sinus opisujacej ruch spadajacego obiektu */
    public double freq;
    /** Rodzaj spadajacego obiektu*/
    public int ktoryobiekt;
    /** Omega 2Pi*f */
    public final static double w=2*Math.PI;
    /** Szerokosc pola graficznego*/
    public int sWidth;
    /** Wysokosc pola graficznego*/
    public int sHeight;
    
    /** Czy trafiono obiektn */
    public boolean hit;
    /** Ikona spadajacego obiektu - zdrowe*/
    public Image icon;
     /** Ikona spadajacego obiektu -niezdrowe*/
    public Image ikona;
    
    /**
     * Konstruktor - ustawienie parametrow spadajacych obiektoww, wylosowanie spadajacego obiektu
     * @param x poczatkowa wspolrzedna x
     * @param y poczatkowa wspolrzedna y
     * @param ampl amplituda sinus (ruch spadajacych obiektow)
     * @param freq czestotliwosc‡ w funkcji sinus
     * @param images tablica ikon ze spadajacym jedzeniem
     */
    public FlyingFood(int x, int y, int ampl, double freq, Image[] images){
        
        //losowanie wspolrzednej x spadajacego obiektu
        Random rand = new Random();
        this.x = rand.nextInt(1100);
        
        this.y=0;
        currX=x;
        currY=y;
        //przesuniecie wspolrzednej y dla poszczegolnych poziomow
        this.dy=5;
       
        //szerokosc/wysokosc pola graficzngo
        sWidth=1200;
        sHeight=900;
        hit=false;
        
        this.ampl=ampl;
        this.freq=freq;
       
         //losujemy spadajacy obiekt -zdrowe jedzenie
        
        int ktoryobiekt=rand.nextInt(24);
        if(ktoryobiekt>=images.length) ;
        icon=images[ktoryobiekt];
       
         //losujemy spadajacy obiekt -niezdrowe jedzenie
        
        int ktoryobiekt2=rand.nextInt(24);
        if(ktoryobiekt2>=images.length) ;
        ikona=images[ktoryobiekt2];
        
        //ustawiamy pulsacje w funkcji sinus 2 Pi f
        setOmega(this.freq);

        
    }
    /**
     * Jedzenie trafione - ustaw stan
     */
    public void setHit(){
        if(!hit){
            hit=true;
            
        }
    }//setHint()
    
    /**
     * Ustaw pozycje spadajacego elementu
     * @param cX wspolrzedna x
     * @param cY wspolrzedna y
     */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }//setPosition()
    
    /**
     * Ustaw rozmiar pola graficznego 
     * @param gWidth szerokosc
     * @param gHeight wysokosc
     */
    public void setScreenSize(int gWidth, int gHeight){
        sWidth=gWidth;
        sHeight=gHeight;
    }
    
        
    /**
     * Ustaw pozycje y spadajacego obiektu
     * @param cY 
     */
    public void setYPos(int cY){
        currY=cY;
    }//setYPos()
    
    /**
     * Pobierz pozycje spadajacego obiektu
     * @return pozycja spadajacego obiektu
     */
    public Point getPosition(){
        return new Point(currX,currY);
    }//getPosition()
  
    /**
     * Ustaw 2 Pi f
     * @param freq 
     */
    public void setOmega(double freq){
        angle=w*freq;
    }//setOmega()
    
    /**
     * Metoda obliczania pozycji spadajacego obiektu - symulacja ruchu
     * 
     * @param mode Tryb określający ruch: 1 - sinus do góry
     */
    public void calculatePathPos(int mode){
        int tmpX=0;
        switch(mode){
           case 1: //poziom 1
                   currY=currY+dy;
                   if(currY>sHeight) { 
                       currY=0;
                   }
                   tmpX=0;
                   currX=x+tmpX;
                    break;
         default: break;  
        }
        
    }//calculatePathPos()
    
}//koniec class FlyingFood

