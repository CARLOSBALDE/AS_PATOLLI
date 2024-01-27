/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as_patolli;

import Teclado.MyKeyBoard;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.*;


public class UnirsePartida {

    Gamepanel gp;
    MyKeyBoard mk;
    BufferedImage LOBBY;
    BufferedImage LOBBY2;
    BufferedImage J1;
    BufferedImage J2;
    BufferedImage J3;
    BufferedImage J4;
    BufferedImage[] conectados = new BufferedImage[4];

    UnirsePartida(Gamepanel gp, MyKeyBoard teclado) {

        this.gp = gp;
        this.mk = teclado;

        try {
            LOBBY = ImageIO.read(new FileInputStream("src\\images\\SESION AMIGA.png"));
            J1 = ImageIO.read(new FileInputStream("src\\images\\Jugador1.png"));
            J2 = ImageIO.read(new FileInputStream("src\\images\\Jugador2.png"));
            J3 = ImageIO.read(new FileInputStream("src\\images\\Jugador3.png"));
            J4 = ImageIO.read(new FileInputStream("src\\images\\Jugador4.png"));
            conectados[0] = J1;
            conectados[1] = J2;
            conectados[2] = J3;
            conectados[3] = J4;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void draw(Graphics2D g2) {

        g2.drawImage(LOBBY, 0, 0, null);
        Font nuevaFuente = new Font("Arial", Font.BOLD, 40);
        g2.setFont(nuevaFuente);
        g2.drawString(gp.cliente.Anfitrion, 125, 535);
        System.out.println();
                for (int i = 0; i < gp.cliente.nplayer; i++) {
            g2.drawImage(conectados[i], 0, 0, null);
        }
                
        
}}

