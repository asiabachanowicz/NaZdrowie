
package nazdrowie;

/**
 *
 * @author Asia
 */
public class GameStatus {
    /** Liczba zgromadzonych punktow na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Czas gry na danym poziomie*/   
    public double time;
    /** Liczba żyć*/
    public int liczbazyc;
    
    /**
     * Zeruj parametry gry
     */
    public void reset(){
        points=0;
        level=1;
        time=0.0;
    }//reset()
    /**
     * Zeruj liczbe punktow
     */
    public void resetPoints(){
        points=0;
    }//resetPoints()
    /**
     * Zmien wskaznik poziomu
     */
    public void nextLevel(){
        level++;
    }//nextLevel()
}//koniec class GameStatus


