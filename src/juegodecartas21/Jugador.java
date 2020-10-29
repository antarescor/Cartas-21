/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class Jugador extends Cupier{
    
   private String nombre;
      
   Jugador(){       
       setNombre();   
   }
   
   public void setNombre(){
       nombre=JOptionPane.showInputDialog(null, 
               "Dime tu nombre: ", "Nombre de Jugador", 1);
       while(nombre.length()==0){
           JOptionPane.showMessageDialog(null, 
                   "** ERROR **:\nEl nombre debe contener al menos un caracter "
                   , "Nombre Invalido", 0);
           nombre=JOptionPane.showInputDialog(null, 
               "Dime tu nombre: ", "Nombre de Jugador", 1);
       }
       nombre=nombre.toUpperCase();
   }
  public String getNombre(){
      return nombre;
  }
   
}
   
  
