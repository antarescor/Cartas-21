/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class Apuesta {
    
    private int efectivo;
    private int apuesta;
    private Vector<Ficha> fichas;
    
    Apuesta(){
        fichas = new Vector<Ficha>();
        inicializarApuestaYEfectivo();
        
        //se inicializa el vector fichas consus respectivas fichas
        ImageIcon imagenX;
        Ficha fichaX;
        for(int i=0;i<6;i++){
           imagenX = new ImageIcon("src/juegodecartas21/Fichas/m ("+i+").png");
           fichaX = new Ficha(imagenX, i);
           fichas.addElement(fichaX);
        }        
        fichas.elementAt(0).setValor(1);
        fichas.elementAt(1).setValor(5);
        fichas.elementAt(2).setValor(10);
        fichas.elementAt(3).setValor(25);
        fichas.elementAt(4).setValor(50);
        fichas.elementAt(5).setValor(100);
    }
      
    
    public void restaEfectivo(int valor){
        efectivo-=valor;
    }
     
    public void sumaApuesta(int valor){
        apuesta+=valor;
    }
    
    public void hacerApuesta(int valor){
        sumaApuesta(valor);
        restaEfectivo(valor);
    }
        
    public Ficha getFicha(int index){
        return fichas.get(index);
    }
    
    public int getEfectivo(){
        return efectivo;
    }
    
     public int getApuesta(){
        return apuesta;
    } 
     
    public void ganaEfectivo(){
        efectivo=apuesta*2;
    }
     
    public void setApuesta(int valorX){
        apuesta=valorX;
    }
    public void inicializarApuestaYEfectivo(){
        apuesta=0;
        efectivo=1500;
    }
    
   
    
    
    
    
    
}
