
package nazdrowie;

/**
 *Status gry
 * @author Asia
 */
public class GameStatus {
    //liczba zdobytych punktow na danym poziomie
    public int points;
    //numer poziomu
    public int level;
    //liczba zyc
    public int liczbazyc=3;
    
    
  //zeruj parametry gry
    public void reset(){
        points=0;
        level=1;
       
    }
    
   //zeruj liczbe punktow
    public void resetPoints(){
        points=0;
    }
    
}