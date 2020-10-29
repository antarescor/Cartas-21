/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class Juego {
    private Baraja barajaDeJuego;
    private Jugador jugador;
    private Cupier cupier;
    int switchBandera=0;//controla la asignacion de los valores del As para el Cupier 
    
    Juego(){
        barajaDeJuego = new Baraja();
        cupier = new Cupier();
        jugador = new Jugador();
    }
        
    public void repartir(){
        Carta cartaX = barajaDeJuego.getCartaAleatoria();
        if (cartaX.getValor()==-1)
            jugador.setCarta(setValorAs(cartaX));
        else
            jugador.setCarta(cartaX);
        repartirCartasCupier();
        //jugador.setCarta(barajaDeJuego.getCartaAleatoria());  
         cartaX = barajaDeJuego.getCartaAleatoria();
        if (cartaX.getValor()==-1)
            jugador.setCarta(setValorAs(cartaX));
        else
            jugador.setCarta(cartaX);
    }
    public Carta setValorAs(Carta cartaX){
        
        Object[] valores = { " [1] Uno ", " [11] Once " };        
        if (cartaX.getValor()==-1)
           if(JOptionPane.showOptionDialog
                   (null, "¿Qué valor desea asignar a la carta?",
                   "Juego 21",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                   cartaX.getImagen(), valores, valores[0]) == 0){
              cartaX.setValor(1);
           }
          else{
              cartaX.setValor(11);
              }  
        return cartaX;
    }
    
    public void otraCarta(){
        Carta cartaX= barajaDeJuego.getCartaAleatoria();
        if (cartaX.getValor()==-1)
            jugador.setCarta(setValorAs(cartaX));
        else
            jugador.setCarta(cartaX);
    }
    
    public  Carta aleatorioAsCupier(Carta cartaX){
        //asigna aleatoriamente el valor del As del Cupier, 
        //en el momento de repartir las cartas
        Random aux= new Random();
        if(aux.nextDouble()<0.5)
               cartaX.setValor(1);
        else 
            cartaX.setValor(11);
        return cartaX;
    }

    public void repartirCartasCupier(){
        Carta cartaX = barajaDeJuego.getCartaAleatoria();        
        if (cartaX.getValor()==-1)
              cupier.setCarta(aleatorioAsCupier(cartaX));
        else
            cupier.setCarta(cartaX);
    }
    public Baraja getBaraja(){
        return barajaDeJuego;
    } 
     public Jugador getJugador(){
        return jugador;
    }
      public Cupier getCupier(){
        return cupier;
    }
  
}
