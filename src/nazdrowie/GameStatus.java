/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nazdrowie;

/**
 *Status gry
 * @author Asia
 */
public class GameStatus {
    /** Liczba zgromadzonych punktów na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Liczba żyć */
    public int liczbazyc=3;
    
    
  /** Zeruj parametry gry */
    public void reset(){
        points=0;
        liczbazyc=3;
    }
    
   /** Zeruj liczbę punktów */
    public void resetPoints(){
        points=0;
    }
    
}