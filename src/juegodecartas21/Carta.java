/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import javax.swing.ImageIcon;

/**
 *
 * @author ~Antares~
 */
public class Carta {
    
    private ImageIcon imagenCarta;
    private int valorCarta;
    private boolean usada;
    
    Carta(ImageIcon imagenX, int valorX){
        imagenCarta=imagenX;
        valorCarta=valorX;
        usada=false;      
    }
    
    public void setValor(int valorX){
        valorCarta=valorX;
    }
    
    public void turnUsada(){
        usada=true;
    }
    
    public ImageIcon getImagen(){
        return imagenCarta;        
    }
    
    public int getValor(){
        return valorCarta;        
    }
      
    public boolean getUsada(){
        return usada;
    }
        
}
