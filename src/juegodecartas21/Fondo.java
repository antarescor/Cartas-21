/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author ~Antares~
 */
public class Fondo extends JPanel
{

	Image fondo;
	
	public Fondo()
	{           
	    fondo = new ImageIcon("src/juegodecartas21/extras/fondo.png").getImage();
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
	}
}
