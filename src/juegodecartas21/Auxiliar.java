/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ~Antares~
 */
public class Auxiliar extends JFrame implements ActionListener{
    private Container contenedor;
    private ImageIcon c1, c2;
    private JLabel l1, l2;
    private JButton b1;
    
    
    Auxiliar(){
        contenedor = getContentPane();
        contenedor.setLayout(null);        
        c1 = new ImageIcon("src/juegodecartas21/Cartas/tapada.png");
        c2 = new ImageIcon("src/juegodecartas21/Cartas/1c.png");
        
        l1 = new JLabel();
        l1.setBounds(20, 20, 71, 96);
        l1.setIcon(c1);
        
        l2 = new JLabel();
        l2.setBounds(40, 20, 71, 96);
        l2.setIcon(c2);
        
        l2.setVisible(false);
        
        b1 = new JButton("OK");
        b1.addActionListener(this);
        b1.setBounds(300, 300, 71, 96);
        
        contenedor.add(l1);
        contenedor.add(l2);
        contenedor.add(b1);
        
        setTitle("Juego De cartas (21)");
        setLocation(150, 150);
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)){
          l2.setVisible(true);  
        }
            
    }
}
