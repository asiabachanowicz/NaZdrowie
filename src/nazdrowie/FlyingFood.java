/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nazdrowie;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;

/**
 * Klasa modelująca przemieszczające się obiekty
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
  /** Krok przesuniecia obiektu z dolu do gory - poziom 1,3*/
    public int dy;
      /** Krok przesuniecia obiektu z dolu do gory - poziom 2 */
    public int cy;
    /** Kąt w funkcji sinus (poziom 3) opisującej ruch spadajcego obiektu */
    private double angle;
    /** Amplituda w funkcji sinus (poziom 3) opisujacej ruch spadajacego obiektu */
    public int ampl;
    /** Czestotliwosc funkcji sinus (poziom 3) opisujacej ruch spadajacego obiektu */
    public double freq;
    /** Rodzaj spadajacego obiektu -zdrowe*/
    public int ktoryobiekt;
    /** Rodzaj spadajacego obiektu -niezdrowe*/
    public int ktoryobiekt2;
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
     * Konstruktor - ustawienie parametrów obiektu, wylosowanie rodzaju spadającego obiektu, 
     * wylosowanie początkowej współrzędnej x obiektów
     * @param x początkowa współrzędna x
     * @param y początkowa współrzędna y
     * @param ampl amplituda sinus (ruch obiektu)
     * @param freq częstotliwość w funkcji sinus (poziom 3)
     * @param images tablica ikon z jedzeniem
     */
    public FlyingFood(int x, int y, int ampl, double freq, Image[] images){
        
        /** Losowanie współrzędnej x spadającego obiektu*/
        Random rand = new Random();
        this.x = rand.nextInt(1100);
        
        this.y=0;
        currX=x;
        currY=y;
        
        /** Przesunięcie współrzędnej y dla poszczególnych poziomów*/
        this.dy=5;
        this.cy=10;
       
        /** Szerokość/wysokość okna graficznego*/
        sWidth=1200;
        sHeight=900;
        hit=false;
        
        this.ampl=ampl;
        this.freq=freq;
       
        /** Losujemy spadający obiekt - zdrowe jedzenie*/
        int ktoryobiekt=rand.nextInt(24);
        if(ktoryobiekt>=images.length) ;
        icon=images[ktoryobiekt];
       
        /** Losujemy spadający obiekt - niezdrowe jedzenie*/
        int ktoryobiekt2=rand.nextInt(24);
        if(ktoryobiekt2>=images.length) ;
        ikona=images[ktoryobiekt2];
        
        /** Ustawiamy pulsację w funkcji sinus*/
        setOmega(this.freq);

        
    }
    /**
     * Jedzenie trafione - ustaw stan
     */
    public void setHit(){
        if(!hit){
            hit=true;     
        }
    }
    
    /**
     * Ustaw pozycje spadajacego elementu
     * @param cX wspolrzedna x
     * @param cY wspolrzedna y
     */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }
    
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
    }
    
    /**
     * Pobierz pozycje spadajacego obiektu
     * @return pozycja spadajacego obiektu
     */
    public Point getPosition(){
        return new Point(currX,currY);
    }
  
    /**
     * Ustaw 2 Pi f
     * @param freq 
     */
    public void setOmega(double freq){
        angle=w*freq;
    }
    
    /**
     * Metoda obliczania pozycji spadajacego obiektu - symulacja ruchu
     * 
     * @param mode Tryb określający ruch: 
     * 1 - liniowo do dołu,
     * 2 - liniowo do dołu z większą szybkością
     * 3 - sinus do dołu
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
            case 2: //poziom 2
                   currY=currY+cy;
                   if(currY>sHeight) { 
                       currY=0;
                   }
                   tmpX=0;
                   currX=x+tmpX;
                    break;
            
           case 3://sinus -poziom 3
                   currY=currY+dy;
                   if(currY>sHeight) { 
                       currY=0;
                   }
                   tmpX=(int)(ampl*Math.sin(angle*currY));
                   currX=x+tmpX;
                   
                
         default: break;  
        }
        
    }
    
}

