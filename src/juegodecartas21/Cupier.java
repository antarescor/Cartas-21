/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.util.Vector;

/**
 *
 * @author ~Antares~
 */
public class Cupier{

   private Vector<Carta> vectorCartas;
   private boolean ganador;
   
   Cupier(){
       vectorCartas= new Vector<Carta>(11);
       ganador=false;
   }
   
   public void setGanador(){
       ganador= true;
   }
   
   public boolean getGanador(){
       return ganador;
   }
   
    public void setCarta(Carta cartaX){
       vectorCartas.addElement(cartaX);
   }
   
   public Carta getCarta(int index){
       return vectorCartas.get(index);
   }
   public void inicializarDatos(){
       vectorCartas.removeAllElements();
       vectorCartas = vectorCartas= new Vector<Carta>(11);
       ganador=false;
   }
   public int getPuntaje(){
       int puntajeX=0;
       if (vectorCartas.size()==0)
           return 0;
       else
           for(int i=0; i<vectorCartas.size();i++){
               puntajeX+=vectorCartas.get(i).getValor();
           }
       return puntajeX;
   }
}
