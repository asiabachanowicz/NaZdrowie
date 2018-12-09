
package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author Asia
 */
public class MenuPanel  extends JFrame implements ActionListener {
    
    JButton bNowaGra;
    JButton bWyswietlInfo;
    JButton bZakonczGre;
    JButton bInstrukcja;
    BufferedImage image1;
    BufferedImage background;
    

public MenuPanel() throws IOException{
        
        setSize(1200,900);
        setLayout(null);
        
        bNowaGra=new JButton ("NOWA GRA");
        bNowaGra.setBounds(280,210,640,100);
        bNowaGra.setBackground(new Color(250,224,120));
        bNowaGra.setForeground(Color.BLACK);
        bNowaGra.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bNowaGra);
        bNowaGra.addActionListener(this);
        
        bWyswietlInfo=new JButton ("WYŚWIETL INFORMACJE O PRODUKTACH");
        bWyswietlInfo.setBounds(280,370,640,100);
        bWyswietlInfo.setBackground(new Color(250,224,120));
        bWyswietlInfo.setForeground(Color.BLACK);
        bWyswietlInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bWyswietlInfo);
        bWyswietlInfo.addActionListener(this);
        
        bZakonczGre=new JButton ("ZAKOŃCZ GRĘ");
        bZakonczGre.setBounds(280,690,640,100);
        bZakonczGre.setBackground(new Color(250,224,120));
        bZakonczGre.setForeground(Color.BLACK);
        bZakonczGre.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bZakonczGre);
        bZakonczGre.addActionListener(this);
        
        bInstrukcja=new JButton ("WYŚWIETL INSTRUKCJĘ");
        bInstrukcja.setBounds(280,530,640,100);
        bInstrukcja.setBackground(new Color(250,224,120));
        bInstrukcja.setForeground(Color.BLACK);
        bInstrukcja.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(bInstrukcja);
        bInstrukcja.addActionListener(this);
        
        image1 = ImageIO.read(new File("images/logo.png"));
        JLabel logo = new JLabel(new ImageIcon (image1));
        logo.setSize(300,100);
        logo.setBounds(285,50,631,131);
        add(logo);
        
        background = ImageIO.read(new File("images/2.png"));
        JLabel backgroundmenu = new JLabel(new ImageIcon (background));
        backgroundmenu.setSize(1200,900);
        backgroundmenu.setBounds(0,0,1200,900);
        add(backgroundmenu);
              
}
@Override
    public void actionPerformed(ActionEvent e){
        
        Object zrodlo=e.getSource();
        if (zrodlo==bNowaGra){
            
            NowaGra wpisywaniedanych = null;
            try {
                wpisywaniedanych = new NowaGra();
            } catch (IOException ex) {
                Logger.getLogger(NaZdrowie.class.getName()).log(Level.SEVERE, null, ex);
            }
            wpisywaniedanych.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            wpisywaniedanych.setVisible(true);
          
        }
        if (zrodlo==bWyswietlInfo){
            
            Informacje info = null;
            try {
                info = new Informacje();
            } catch (IOException ex) {
                Logger.getLogger(NaZdrowie.class.getName()).log(Level.SEVERE, null, ex);
            }
            info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            info.setVisible(true);
                        
            
        }
        
        if (zrodlo==bZakonczGre){
         
            dispose();
        }
        
        if (zrodlo==bInstrukcja){
        
            Instrukcja instr = null;
            try {
                instr = new Instrukcja();
            } catch (IOException ex) {
                Logger.getLogger(NaZdrowie.class.getName()).log(Level.SEVERE, null, ex);
            }
            instr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            instr.setVisible(true);
                   
        }

}
}