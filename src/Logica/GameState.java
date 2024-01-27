
package Logica;

import java.awt.Color;
import java.util.ArrayList;


public class GameState {
    int njugadores;
    //en juego, turno, ganador,se movio
    Color verde = Color.green;
    Color azul = Color.blue ;
    Color rojo = Color.red; 
    Color lila = Color.MAGENTA;
    
    ArrayList<Jugador> jugadores ;
    
    GameState(int njugadores){
    AñadirJugadores();
       
    }
    
    public void AñadirJugadores(){
           jugadores = new ArrayList<Jugador>();
           
           
    }
    
    
}
