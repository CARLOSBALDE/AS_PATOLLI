package Logica;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Jugador {

    String nombre;
    BufferedImage color;
    int nplayer, nfichas;
    boolean perdio = false;
    BufferedImage fondo2;
    BufferedImage ficha1;
    BufferedImage ficha2;
    BufferedImage ficha3;
    BufferedImage ficha4;

    Jugador(int nplayer, int nfichas, BufferedImage color, String nombre) {
     this.color = color;
    }

    public void CargaImagen() {
        try {
//            fondo = ImageIO.read(new FileInputStream("src\\images\\tablero completo.jpg"));

            ficha1 = ImageIO.read(new FileInputStream("src\\images\\ficha morada.png"));
            ficha2 = ImageIO.read(new FileInputStream("src\\images\\ficha rosa.png"));
            ficha3 = ImageIO.read(new FileInputStream("src\\images\\ficha verde.png"));
            ficha4 = ImageIO.read(new FileInputStream("src\\images\\ficha negra.png"));
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
