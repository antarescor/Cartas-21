/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class Baraja {
    
    private Vector<Carta> baraja;
    private String rutaDirectorio;
    
    Baraja(){
        rutaDirectorio = new String("src/juegodecartas21/Cartas/");
        inicializarBaraja();
    }
    
    public void inicializarBaraja(){
        
        baraja = new Vector<Carta>(51);
        System.out.println("Se inicializo la baraja");
        ImageIcon imagenCartaX;
        int aux;
        //ciclo que asigna a la baraja las cartas de corazon.
        for(int iCar=1;iCar<=13;iCar++){
            imagenCartaX = new ImageIcon(rutaDirectorio+iCar+"c.png");
            if(1==iCar)
                aux=-1;
            else if (iCar>10)
                     aux=10;
                 else
                     aux=iCar;           
            Carta cartaX = new Carta(imagenCartaX, aux);
            baraja.addElement(cartaX);                        
        }
        
        //ciclo que asigna a la baraja las cartas de picas.
        for(int iCar=1;iCar<=13;iCar++){
            imagenCartaX = new ImageIcon(rutaDirectorio+iCar+"p.png");
            if(1==iCar)
                aux=-1;
            else if (iCar>10)
                     aux=10;
                 else
                     aux=iCar;           
            Carta cartaX = new Carta(imagenCartaX, aux);
            baraja.addElement(cartaX);                        
        }
        
        //ciclo que asigna a la baraja las cartas de diamantes.
        for(int iCar=1;iCar<=13;iCar++){
            imagenCartaX = new ImageIcon(rutaDirectorio+iCar+"d.png");
            if(1==iCar)
                aux=-1;
            else if (iCar>10)
                     aux=10;
                 else
                     aux=iCar;           
            Carta cartaX = new Carta(imagenCartaX, aux);
            baraja.addElement(cartaX);                        
        }
        
        //ciclo que asigna a la baraja las cartas de trebol.
        for(int iCar=1;iCar<=13;iCar++){
            imagenCartaX = new ImageIcon(rutaDirectorio+iCar+"t.png");
            if(1==iCar)
                aux=-1;
            else if (iCar>10)
                     aux=10;
                 else
                     aux=iCar;           
            Carta cartaX = new Carta(imagenCartaX, aux);
            baraja.addElement(cartaX);           
           }        
    }
    public void borrarBaraja(){
        baraja.removeAllElements();
    }
    public int getSize(){
        return baraja.size();
    }
    
    public void verificarBaraja(){
        if(baraja.size()<=1){
            Object[] valores = { "Reiniciar Baraja", "Salir del Juego" };
            
            if(JOptionPane.showOptionDialog(null, "¡ La Baraja se agoto !"
                    + "\n¿Deseas reiniciar la baraja?","BARAJA AGOTADA",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    (new ImageIcon("src/juegodecartas21/Cartas/baraja.png")),
                    valores, valores[0]) == 0){
                
                    borrarBaraja();
                    inicializarBaraja();
              }
            else{        
                JOptionPane.showMessageDialog(null, null, null, 0, new ImageIcon("src/juegodecartas21/extras/bye.png"));
                System.exit(0);
                }           
        } 
    }
    
    public Carta getCartaAleatoria(){
        int index;
        Carta cartaX;       
        Random aleatorio= new Random();
        index=(int)(aleatorio.nextDouble()* baraja.size()); //crea un num aleatorio entre o y tam vector
        cartaX = baraja.elementAt(index);//elige una carta y la guarda       
        baraja.removeElementAt(index);//elimina la carta anterior, de la baraja
        System.out.println("Ahora el numero de Cartas en la Baraja es: "+baraja.size());
        verificarBaraja();
        return cartaX;//retorna la carta selecionada 
    }
        
 }