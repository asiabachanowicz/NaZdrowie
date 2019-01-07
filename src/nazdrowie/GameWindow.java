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
    
   
    public GameWindow(int width, int height, int x, int y){
        
        
    super();
    this.nowagra = new GamePanel();
    setSize(width, height);
    setLocation(x,y);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false); //zablokuj możliwość zmian rozmiaru okna
    setUndecorated(true); //ukryj ramke okna i przyciski kontrolne
    setVisible(true);
    
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
    menu.bNowaGra.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "DANE GRACZA");
            
        }
    });
    
       
       
     menu.bWyswietlInfo.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "INFORMACJE O PRODUKTACH1");
            
        }
    });
      
     menu.bZakonczGre.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        System.exit(0);
            
        }
    });
      menu.bInstrukcja.addActionListener(new ActionListener(){
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
    
      instrukcja.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info1.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info1.bNastepnaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH2");
            
        }
    });
       
      info2.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info2.bNastepnaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH3");
            
        }
      
    });
      
      info2.bPoprzedniaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH1");
            
        }
      
    });
      
       
      info3.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      info3.bNastepnaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH4");
            
        }
    });
      
      info3.bPoprzedniaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH2");
            
        }
      
    });
       info4.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      
      danegracza.bPrzejdzDoMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
      info4.bPoprzedniaStrona.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "INFORMACJE O PRODUKTACH3");
            
        }
      
    });
      
       danegracza.bOblicz.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "WYNIK");
            
        }
    });    
       
       danegracza.bGraj.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "NOWA GRA");
            
        }
    });
       
          
       nowagra.bMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });    
       
         
       nowagra.bPoziom2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "POZIOM 2");
            
        }
    });    
       
        poziom2.bPoziom3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "POZIOM 3");
            
        }
    });    
       
       
    }    
    

     // Utworz interfejs graficzny uzytkownika
 
    private void initGUI(){
        Toolkit tk = Toolkit.getDefaultToolkit();
       
    }
   
}//koniec class GameWindow

