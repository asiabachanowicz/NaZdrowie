
package nazdrowie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asia
 */

public class Informacje extends JFrame implements ActionListener  {
    
    JButton bPrzejdzDoMenu;
    BufferedImage background;
    
    public Informacje() throws IOException{
                        
        setSize(1200,900);
        setTitle("NowaGra");
        setLayout(null);
 
        bPrzejdzDoMenu=new JButton ("PRZEJDŹ DO MENU");
        bPrzejdzDoMenu.setBounds(740,770,200,30);
        bPrzejdzDoMenu.setBackground(new Color(250,224,120));
        bPrzejdzDoMenu.setForeground(Color.BLACK);
        bPrzejdzDoMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        add(bPrzejdzDoMenu);
        bPrzejdzDoMenu.addActionListener(this);
        
        background = ImageIO.read(new File("images/2.png"));
        JLabel backgroundmenu = new JLabel(new ImageIcon (background));
        backgroundmenu.setSize(1200,1024);
        backgroundmenu.setBounds(0,0,1200,900);
        add(backgroundmenu);
        
}
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object zrodlo=e.getSource();
                
        if (zrodlo==bPrzejdzDoMenu){
         
            MenuPanel menuglowne;
            try {
                menuglowne = new MenuPanel();
                menuglowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuglowne.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Instrukcja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
