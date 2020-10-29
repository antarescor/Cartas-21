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
class Ficha {
    
    private ImageIcon imagenFicha;
    private int valorFicha;
    
    Ficha(ImageIcon imagenX, int valorX){
        imagenFicha=imagenX;
        valorFicha=valorX;
    }
    
    public ImageIcon getImagen(){
        return imagenFicha;
    }
    
    public void setValor(int valorX){
        valorFicha=valorX;
    }
    
    public int getValor(){
        return valorFicha;
    }
    
    
}
