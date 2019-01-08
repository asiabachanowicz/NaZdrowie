/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nazdrowie;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Przełączanie paneli 
 * @author Asia
 */

public class GameWindow extends JFrame{
    
    MenuPanel menu = new MenuPanel();
    Instrukcja instrukcja = new Instrukcja();
    Dane danegracza = new Dane();
    GamePanel nowagra = new GamePanel();
    Poziom2 poziom2 = new Poziom2();
    Poziom3 poziom3 = new Poziom3();
    Informacje1 info1 = new Informacje1();
    Informacje2 info2 = new Informacje2();
    Informacje3 info3 = new Informacje3();
    Informacje4 info4 = new Informacje4();

    JPanel cardPanel;
    CardLayout cl;
    
    /**
     * Główny konstruktor klasy - ustawienie parametrów i rozpoczęcia akcji
     * @param width szerokość okna
     * @param height wysokość okna
     * @param x pozycja x lewego górnego narożnika okna
     * @param y pozycja y lewego górnego narożnika okna
     */
    public GameWindow(int width, int height, int x, int y){
        
        
    super(); //wywołaj kontruktor klasy nadrzędnej - utwórz okno
    setSize(width, height); // wymiary okna
    setLocation(x,y); //ustaw pozycję okna
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false); //zablokuj możliwość zmian rozmiaru okna
    setUndecorated(true); //ukryj ramke okna i przyciski kontrolne
    setVisible(true); // pokaż okno
    
    panels();  
    initGUI();
    
              
    }//koniec GameWindow()  
    
    public void panels(){
    cardPanel = new JPanel(new CardLayout());
    getContentPane().add(cardPanel); 
    cardPanel.add(menu, "MENU");
    cardPanel.add(nowagra, "NOWA GRA");
    cardPanel.add(danegracza, "DANE GRACZA");
    cardPanel.add(instrukcja, "INSTRUKCJA");
    cardPanel.add(poziom2, "POZIOM 2");
    cardPanel.add(poziom3, "POZIOM 3");
    cardPanel.add(info1, "INFORMACJE O PRODUKTACH1");
    cardPanel.add(info2, "INFORMACJE O PRODUKTACH2");
    cardPanel.add(info3, "INFORMACJE O PRODUKTACH3");
    cardPanel.add(info4, "INFORMACJE O PRODUKTACH4");
   
 
    
    cl=(CardLayout) cardPanel.getLayout();
    //otworzenie panelu Menu
    cl.show(cardPanel, "MENU");
    
    //po kliknieciu buttonu Nowa Gra w Menu otwierana sie Dane Gracza, itd.
    menu.bNewGame.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "DANE GRACZA");
            
        }
    });
    
       
       
     menu.bInfo.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "INFORMACJE O PRODUKTACH1");
            
        }
    });
      
     menu.bExit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        System.exit(0);
            
        }
    });
      menu.bInstruction.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INSTRUKCJA");
            
        }
    });
      
    
    poziom2.bMenu.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "MENU");
            
        }
    });
    
    poziom3.bMenu.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "MENU");
            
        }
    });
    
      instrukcja.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info1.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info1.bNext.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH2");
            
        }
    });
       
      info2.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info2.bNext.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH3");
            
        }
      
    });
      
      info2.bPrev.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH1");
            
        }
      
    });
      
       
      info3.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info3.bNext.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH4");
            
        }
    });
      
      info3.bPrev.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH2");
            
        }
      
    });
       info4.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      danegracza.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      info4.bPrev.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH3");
            
        }
      
    });
      
       danegracza.bCalculate.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "WYNIK");
            
        }
    });    
       
       danegracza.bPlay.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        nowagra.restartGame();
        nowagra.loss=false;
        nowagra.win=false;
        cl.show(cardPanel, "NOWA GRA");
            
        }
    });
       
          
       nowagra.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });    
       
         
       nowagra.bLevel2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        poziom2.restartGame();
        cl.show(cardPanel, "POZIOM 2");
            
        }
    });    
       
        poziom2.bLevel3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        poziom3.restartGame();
        cl.show(cardPanel, "POZIOM 3");
            
        }
    });    
       
       
    }    
    
 /**
     * Utwórz interfejs graficzny użytkownika
     * @param width szerokość okna
     * @param height wysokość okna
     */
    private void initGUI(){
        Toolkit tk = Toolkit.getDefaultToolkit();
       
    }
   
}//koniec class GameWindow

