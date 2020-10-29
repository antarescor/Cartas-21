/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodecartas21;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ~Antares~
 */
public class Interfaz extends JFrame implements ActionListener{

    //-------------
    private Juego juego21;
    //-------------
    private JMenuBar menu;
    private JMenu archivo, integrantes;
    private JMenuItem salir, quienesSomos;
    private JTextField efectivo, apuesta, puntajeJugador, puntajeCupier;
    private JLabel estado, estadoBaraja, efectivoNom, apuestaNom;
    private JButton repartir, otraCarta, seguro, otroJuego;
    //-------------
    private JPanel panelEfectivoApuesta, panelBarraMenu;
    private JPanel panelBotones, panelCartasJugador , panelCartasCupier;
    private JPanel panelCartasJugadorYCupier, panelCartasYBotones, panelFinal;
    //-------------
    private Vector<JButton>vectorFichas;
    private Vector<JLabel> vectorCartasJ;
    private Vector<JLabel> vectorCartasC;
        
    //-------------
    private Container contenedor;
    private boolean hayGanador, seguroJuego;
    
    private int contadorDeCartasJ, contadorDeCartasC;
    int contadorDeCartasB=0;
    
   Interfaz(){
        JOptionPane.showMessageDialog(null, null, null, WIDTH, new ImageIcon("src/juegodecartas21/EXTRAS/Bienvenido.png"));
        juego21= new Juego();
        vectorCartasJ = new Vector<JLabel>(11);
        vectorCartasC = new Vector<JLabel>(11);
        vectorFichas = new Vector<JButton>(6);
        contadorDeCartasJ=2; //inicia a contar a partir de la carta tres
        contadorDeCartasC=1; //inicia a contar a partir de la carta tres
        hayGanador=false;
        seguroJuego=false;
        iniciarVentanaPrincipal();
    }  
    
   public void iniciarVentanaPrincipal(){
        panelEfectivoApuesta();
        //------------
        panelBarraMenu();
        panelBotones();
        //------------
        panelCartasJugador();
        panelCartasCupier();
        panelCartasJugadorYCupier();
        //------------
        panelCartasYBotones();
        panelFinal();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        //Fondo fondo = new Fondo();

        contenedor.add(panelFinal);
        //contenedor.add(fondo);      
        
        setTitle("Juego De cartas (21)");
        setLocation(50, 150);
        setSize(880, 450);
        setResizable(false);
        setVisible(true); 
        
    }
   
   public void panelEfectivoApuesta(){
              
       panelEfectivoApuesta = new JPanel();
       panelEfectivoApuesta.setLayout(null);
       panelEfectivoApuesta.setBorder(BorderFactory.createTitledBorder(null,""
               + "Apuestas",TitledBorder.CENTER,0,null, Color.BLUE));

       //inicilizar componentes de apuesta
       efectivoNom = new JLabel("Efectivo");
       efectivoNom.setBounds(20, 40, 100, 20);
       efectivo = new JTextField();
       efectivo.setEnabled(false);
       efectivo.setText(""+1500);
       efectivo.setBounds(20, 70, 100, 20);
       
       apuestaNom = new JLabel("Apuesta");
       apuestaNom.setBounds(20, 100, 100, 20);
       apuesta = new JTextField();
       apuesta.setEnabled(false);
       apuesta.setText(""+0);
       apuesta.setBounds(20, 130, 100, 20);
       
       //inicializar botones de fichas
       JButton aux; 
       for (int i=0; i<vectorFichas.capacity();i++){
           aux= new JButton();
           aux.setIcon(new ImageIcon("src/juegodecartas21/Fichas/m("+i+").png"));
           aux.addActionListener(this);
           vectorFichas.insertElementAt(aux, i);
       }
       //pocisiones de los botones fichas
       int ancho, alto;
       ancho=alto=30;
       vectorFichas.get(0).setBounds(20, 200, ancho, alto);
       vectorFichas.get(1).setBounds(60, 200, ancho, alto);
       vectorFichas.get(2).setBounds(100, 200, ancho, alto);
       
       vectorFichas.get(3).setBounds(20, 240, ancho, alto);
       vectorFichas.get(4).setBounds(60, 240, ancho, alto);
       vectorFichas.get(5).setBounds(100, 240, ancho, alto);
       
       //anadir elementos al contenedor
       panelEfectivoApuesta.add(efectivoNom);
       panelEfectivoApuesta.add(efectivo);
       panelEfectivoApuesta.add(apuestaNom);
       panelEfectivoApuesta.add(apuesta);
       
       for(int i=0; i<vectorFichas.capacity();i++)
           panelEfectivoApuesta.add(vectorFichas.get(i));
       
   }
   
   public void panelBarraMenu(){
       panelBarraMenu = new JPanel();
       panelBarraMenu.setLayout(null);
       
       menu = new JMenuBar();
       menu.setBounds(0, 0, 200, 40);
       menu.setLayout(new GridLayout(1, 2));
       archivo = new JMenu("Archivo");
       integrantes = new JMenu("Integrantes");
       
       salir = new JMenuItem("Salir");
       quienesSomos = new JMenuItem("Quienes Somos");
       
       salir.addActionListener(this);
       quienesSomos.addActionListener(this);
       
       archivo.add(salir);
       integrantes.add(quienesSomos);
       
       menu.add(archivo);
       menu.add(integrantes);
       
       panelBarraMenu.add(menu);
   }
   
   
   public void panelBotones(){
       panelBotones= new JPanel();
       panelBotones.setLayout(null);
              
       int posY, posX, ancho, alto, esp;
       ancho=100;
       alto=30;
       posY=50;
       posX=100;
       esp=20;
       
       repartir = new JButton("Repartir");
       repartir.setBounds(posX, posY, ancho, alto);
       otraCarta = new JButton("Otra Carta");
       otraCarta.setBounds(posX+=ancho+esp, posY, ancho, alto);
       seguro = new JButton("Seguro");
       seguro.setBounds(posX+=ancho+esp, posY, ancho, alto);
       otroJuego = new JButton("Otro Juego");
       otroJuego.setBounds(posX+=ancho+esp, posY, ancho, alto);
       
       repartir.setEnabled(false);
       otraCarta.setEnabled(false);
       seguro.setEnabled(false);
         
       estado= new JLabel("****** Haga su Apuesta******");
       estado.setBounds(150, 10, 250, 30);
       
       estadoBaraja= new JLabel("Nº cartas en baraja: "+juego21.getBaraja().getSize());
       estadoBaraja.setBounds(320, 10, 250, 30);
       
       repartir.addActionListener(this);
       otraCarta.addActionListener(this);
       seguro.addActionListener(this);
       otroJuego.addActionListener(this);
                    
       panelBotones.add(repartir);
       panelBotones.add(otraCarta);
       panelBotones.add(seguro);
       panelBotones.add(otroJuego);
       panelBotones.add(estado);
       panelBotones.add(estadoBaraja);
            
   }
   
   public void panelCartasJugador(){
       panelCartasJugador = new JPanel();
       panelCartasJugador.setLayout(null);
       panelCartasJugador.setBorder(BorderFactory.createTitledBorder(null,""
               + "Cartas de "+juego21.getJugador().getNombre(),TitledBorder.CENTER,0,null, Color.BLUE));       
       
       puntajeJugador = new JTextField("0");       
       puntajeJugador.setEnabled(false);      
       puntajeJugador.setBounds(120, 180, 100, 20);       
       inicializarVCartasJ();     
       panelCartasJugador.add(puntajeJugador);      
   }
   
   public void panelCartasCupier(){
       panelCartasCupier = new JPanel();
       panelCartasCupier.setLayout(null);
       panelCartasCupier.setBorder(BorderFactory.createTitledBorder(null,""
               + "Cartas De Cupier",TitledBorder.CENTER,0,null, Color.BLUE));
       
       puntajeCupier = new JTextField("0");       
       puntajeCupier.setEnabled(false);     
       puntajeCupier.setBounds(120, 180, 100, 20);       
       inicializarVCartasC();       
       panelCartasCupier.add(puntajeCupier); 
   }
   
   public void panelCartasJugadorYCupier(){
       panelCartasJugadorYCupier= new JPanel();
       panelCartasJugadorYCupier.setLayout(new BoxLayout(panelCartasJugadorYCupier, BoxLayout.X_AXIS));
       
       panelCartasJugadorYCupier.add(panelCartasJugador);
       panelCartasJugadorYCupier.add(panelCartasCupier);             
   }
   
   public void panelCartasYBotones(){
       panelCartasYBotones= new JPanel();
       panelCartasYBotones.setLayout(new BoxLayout(panelCartasYBotones, BoxLayout.Y_AXIS));              
       panelCartasYBotones.add(panelCartasJugadorYCupier);
       panelCartasYBotones.add(panelBotones);
   }
   
   public void panelFinal(){
       panelFinal= new JPanel();
       panelFinal.setLayout(null);
       
       panelBarraMenu.setBounds(0, 0, 200, 40);
       panelEfectivoApuesta.setBounds(10, 40, 200, 350);
       panelCartasYBotones.setBounds(210, 40, 650, 500);
       
       panelFinal.add(panelBarraMenu);
       panelFinal.add(panelEfectivoApuesta);
       panelFinal.add(panelCartasYBotones);
       
      
   }
   
  public void inicializarVCartasJ(){
       
       JLabel labelX;
       int ancho=71;
       int alto=96; 
       int posX=220;
       int posY=40;
       for(int i=0;i<vectorCartasJ.capacity();i++){
           labelX = new JLabel();
           labelX.setVisible(false);
           labelX.setBounds(posX, posY, ancho, alto);
           posX=posX-20;
           posY=posY+2;
           vectorCartasJ.insertElementAt(labelX, i);
       }
       
       vectorCartasJ.get(0).setIcon(new ImageIcon("src/juegodecartas21/Cartas/tapada.png"));
       vectorCartasJ.get(0).setVisible(true);
       
       
       for(int i=0;i<vectorCartasJ.size();i++){
           panelCartasJugador.add(vectorCartasJ.get(i));
       }
   }
   
   public void inicializarVCartasC(){
       JLabel labelX;
       int ancho=71;
       int alto=96; 
       int posX=220;
       int posY=40;
       
       for(int i=0;i<vectorCartasC.capacity();i++){           
           labelX = new JLabel();
           labelX.setVisible(false);
           labelX.setBounds(posX, posY, ancho, alto);
           posX=posX-20;
           posY=posY+2;
           vectorCartasC.insertElementAt(labelX, i);
       }
       
       vectorCartasC.get(0).setIcon(new ImageIcon("src/juegodecartas21/Cartas/tapada.png"));
       vectorCartasC.get(0).setVisible(true);
       
       for(int i=0;i<vectorCartasC.size();i++){
           panelCartasCupier.add(vectorCartasC.get(i));
       }
       
   }
   
   public void inicilizarJuegoNuevo(){
          
       activarFichas();
       ponerBotonesInicio();
       juego21.getBaraja().borrarBaraja();
       juego21.getBaraja().inicializarBaraja();
       apuesta.setText(""+0);
       efectivo.setText(""+1500);
       inicializarImagenCartas();
   }
   
   public void inicializarImagenCartas(){
       
       juego21.getJugador().inicializarDatos();
       for(int i=0; i<vectorCartasJ.size();i++){
           vectorCartasJ.get(i).setVisible(false);
       }
       vectorCartasJ.get(0).setIcon(new ImageIcon("src/juegodecartas21/Cartas/tapada.png"));
       vectorCartasJ.get(0).setVisible(true);
       
       juego21.getCupier().inicializarDatos();
       for(int i=0; i<vectorCartasJ.size();i++){
           vectorCartasC.get(i).setVisible(false);
       }
       vectorCartasC.get(0).setIcon(new ImageIcon("src/juegodecartas21/Cartas/tapada.png"));
       vectorCartasC.get(0).setVisible(true);      
       
       otroJuego.setEnabled(true);
       contadorDeCartasJ=2;
       contadorDeCartasC=1;
       
       hayGanador=false;
       seguroJuego=false;
       
       actualizarPuntajes();
       estado.setText("****** Haga su Apuesta******");
             
   }
   
   public void actualizarPuntajes(){
       puntajeJugador.setText(""+juego21.getJugador().getPuntaje());
       puntajeCupier.setText(""+juego21.getCupier().getPuntaje());
   }
   
   public void activarFichas(){
       for(int i=0;i<vectorFichas.capacity();i++)
           vectorFichas.get(i).setEnabled(true);
   }
   public void desactivarFichas(){
       for(int i=0;i<vectorFichas.capacity();i++)
           vectorFichas.get(i).setEnabled(false);
   }
   public void desactivarBotones(){
       repartir.setEnabled(false);
       otraCarta.setEnabled(false);
       seguro.setEnabled(false);
       otroJuego.setEnabled(false);
   }
   public void ponerBotonesInicio(){
       repartir.setEnabled(false);
       otraCarta.setEnabled(false);
       seguro.setEnabled(false);
       otroJuego.setEnabled(true);
   }
   
   public void juez(){      
      int ptsCupier, ptsJugador;
      ptsCupier=Integer.parseInt(puntajeCupier.getText());
      ptsJugador=Integer.parseInt(puntajeJugador.getText());
      
       if(seguroJuego){                 
           if (ptsCupier>ptsJugador && ptsCupier<=21){
               juego21.getCupier().setGanador();
               hayGanador=true;
           }
           if (ptsCupier>21){
               juego21.getJugador().setGanador();
               hayGanador=true;
           }
       }
       else{
           if (ptsJugador==21){
               juego21.getJugador().setGanador();
               hayGanador=true;
           }
           if (ptsJugador>21){
               juego21.getCupier().setGanador();
               hayGanador=true;
           }           
       }
       if(juego21.getJugador().getGanador()){
           estado.setVisible(true);
           estado.setText("****** GANA "+juego21.getJugador().getNombre()+" ******");
           JOptionPane.showMessageDialog(null,
                 "GANA "+juego21.getJugador().getNombre(),
                 "***** GANADOR *****", 1);
           int efectivoX=Integer.parseInt(efectivo.getText());
           int apuestaX=Integer.parseInt(apuesta.getText())*2;
           int suma=efectivoX+apuestaX;
           efectivo.setText(""+suma);
       }
         
       if(juego21.getCupier().getGanador()){
           estado.setVisible(true);
           estado.setText("****** GANA CUPIER ******");
           JOptionPane.showMessageDialog(null,
                 "GANA CUPIER",
                 "***** GANADOR *****", 1);
       }
                
   }
   public void apostar(int valorApuesta){
       int efectivoX,apuestaX;
       
       efectivoX=Integer.parseInt(efectivo.getText());
       apuestaX=Integer.parseInt(apuesta.getText());
             
       if(efectivoX<valorApuesta){
         JOptionPane.showMessageDialog(null,
                 "YA NO PUEDE APOSTAR MAS, SE HA QUEDADO SIN DINERO",
                 "SIN DINERO", 1);
         
       }
       else{
           efectivoX-=valorApuesta;
           efectivo.setText(""+efectivoX);           
           apuestaX+=valorApuesta;
           apuesta.setText(""+apuestaX);
       }
   }
  
      
    public void actionPerformed(ActionEvent e) {
        
        //para las fichas
        if (e.getSource().equals(vectorFichas.get(0))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(1);
            
        }
        if (e.getSource().equals(vectorFichas.get(1))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(5);
            
        }
        if (e.getSource().equals(vectorFichas.get(2))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(10);
            
        }
        if (e.getSource().equals(vectorFichas.get(3))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(25);
            
        }
        if (e.getSource().equals(vectorFichas.get(4))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(50);            
        }
        if (e.getSource().equals(vectorFichas.get(5))){
            repartir.setEnabled(true);
            otroJuego.setEnabled(true);
            apostar(100);
            
        }
        
        //para los botones
        if (e.getSource().equals(repartir)){
                repartir.setEnabled(false);
                desactivarFichas();
                estado.setVisible(false);
                desactivarBotones();
                seguro.setEnabled(true);
                otraCarta.setEnabled(true);
            
                juego21.repartir();
                vectorCartasJ.get(0).setIcon(juego21.getJugador().getCarta(0).getImagen());
                vectorCartasJ.get(1).setIcon(juego21.getJugador().getCarta(1).getImagen());
                vectorCartasJ.get(1).setVisible(true);
                                         
                vectorCartasC.get(0).setIcon(juego21.getCupier().getCarta(0).getImagen());
                actualizarPuntajes();
                estadoBaraja.setText("Nº cartas en baraja: "+juego21.getBaraja().getSize());
                juez();            
        }
        if (e.getSource().equals(otraCarta)){
            if (contadorDeCartasJ>10){
                JOptionPane.showMessageDialog(null,"SE AGOTARON LAS CARTAS DE SU BARAJA","SIN CARTAS", 1);
                JOptionPane.showMessageDialog(null, "USTED PIERDE", "GAME OVER", 1);
                otraCarta.setEnabled(false);
                seguro.setEnabled(false);              
                inicializarImagenCartas();
                activarFichas();
                ponerBotonesInicio();
                contadorDeCartasJ=2;
               }
            else{                
                juego21.otraCarta();
                vectorCartasJ.get(contadorDeCartasJ).setIcon(juego21.getJugador().getCarta(contadorDeCartasJ).getImagen());
                vectorCartasJ.get(contadorDeCartasJ).setVisible(true);
                estadoBaraja.setText("Nº cartas en baraja: "+juego21.getBaraja().getSize());              
                actualizarPuntajes();
                juez();
               }
            contadorDeCartasJ++;
        }
        if(e.getSource().equals(seguro)){
            seguroJuego=true;
            desactivarBotones();
        }
        if(e.getSource().equals(otroJuego)){
            inicilizarJuegoNuevo();
            estadoBaraja.setText("Nº cartas en baraja: "+juego21.getBaraja().getSize());
            contadorDeCartasJ=1;
        }
        if(e.getSource().equals(quienesSomos))
            JOptionPane.showMessageDialog(null,"MADE BY:\nManuel Alejandro Doncel Castro 1056353\nLeidy Marcela Toro Velez 1056234","QUIENES SOMOS", 1);
        
        if(e.getSource().equals(salir)){
            setVisible(false);
            JOptionPane.showMessageDialog(null, null, null, WIDTH, new ImageIcon("src/juegodecartas21/extras/bye.png"));
            System.exit(0);  
        }  
        
        if (seguroJuego){
            desactivarBotones();
            seguro.setEnabled(true);
            while(!hayGanador){
                juego21.repartirCartasCupier();
                vectorCartasC.get(contadorDeCartasC).setIcon(juego21.getCupier().getCarta(contadorDeCartasC).getImagen());
                vectorCartasC.get(contadorDeCartasC).setVisible(true);
                estadoBaraja.setText("Nº cartas en baraja: "+juego21.getBaraja().getSize());
                actualizarPuntajes();
                juez();
                contadorDeCartasC++;
            }
        }
        
        if (hayGanador){
           inicializarImagenCartas();
           activarFichas();
           ponerBotonesInicio();          
           apuesta.setText(""+0);
       }
       if((Integer.parseInt(apuesta.getText())==0) &&
               (Integer.parseInt(apuesta.getText())==0) )
           repartir.setEnabled(false);
     }       
   }
