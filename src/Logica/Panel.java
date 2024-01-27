package Logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {
  private javax.swing.JButton jButton1;
    Dados dados = new Dados();
    Teclado.MyKeyBoard mk = new Teclado.MyKeyBoard();
    Thread stop = new Thread(this);
    ArrayList<Integer> posciciones = new ArrayList<Integer>();
    boolean isRunning = true;
    int unidad = 25;
    int x, y;
    int mitad;
    BufferedImage fondo;
    BufferedImage fondo2;
    BufferedImage ficha1;
    BufferedImage ficha2;
    BufferedImage ficha3;
    BufferedImage ficha4;
    BufferedImage noturno;
    boolean avanzar = false,Turno=true;
   boolean  Tirando=false;

    int jugadores, nfichas, Avance = -1;

    Panel() {

        this.setFocusable(true);
        this.setVisible(true);
        stop.start();
        LlenarPos();

    }

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        Tirando = true;
        Avance++;
        System.out.println(Avance);
        repaint();
    }        

    public void Avanzar(Graphics g) {
        int con = 0;
        for (int i = 0; i < posciciones.size(); i++) {

            g.drawImage(ficha1, posciciones.get(i), posciciones.get(i + 1), null);

//          con++;
//          if(con==02){
//              con=0;
//          }
            if (con == Avance) {
                Avance = -1;
                break;

            }
            con++;
            i = i + 2;
        }

    }

    @Override
    public void run() {
        while (stop != null) {
            
            if(Turno){
                            Mouse();

            }
            
            repaint();

        }

    }

    public void LlenarPos() {

        posciciones.add(884);
        posciciones.add(553);
        posciciones.add(862);
        posciciones.add(530);
        posciciones.add(853);
        posciciones.add(517);
        posciciones.add(836);
        posciciones.add(506);
        posciciones.add(813);
        posciciones.add(477);
        posciciones.add(789);
        posciciones.add(456);
        posciciones.add(765);
        posciciones.add(434);
        posciciones.add(741);
        posciciones.add(408);
        posciciones.add(716);
        posciciones.add(383);
        posciciones.add(741);
        posciciones.add(359);
        posciciones.add(769);
        posciciones.add(336);
        posciciones.add(791);
        posciciones.add(315);
        posciciones.add(816);
        posciciones.add(292);
        posciciones.add(841);
        posciciones.add(264);
        posciciones.add(858);
        posciciones.add(269);
        posciciones.add(864);
        posciciones.add(243);

        ////
        posciciones.add(886);
        posciciones.add(218);
        posciciones.add(866);
        posciciones.add(200);
        posciciones.add(842);
        posciciones.add(219);
        posciciones.add(231);
        posciciones.add(817);
        posciciones.add(245);
        posciciones.add(791);
        posciciones.add(265);
        posciciones.add(765);
        posciciones.add(289);
        posciciones.add(741);
        posciciones.add(312);
        posciciones.add(716);
        posciciones.add(336);
        posciciones.add(691);
        posciciones.add(358);
        posciciones.add(666);
        posciciones.add(333);
        posciciones.add(643);
        posciciones.add(310);
        posciciones.add(618);
        posciciones.add(286);
        posciciones.add(595);
        posciciones.add(263);
        posciciones.add(571);
        posciciones.add(241);
        posciciones.add(559);
        posciciones.add(227);
        posciciones.add(543);
        posciciones.add(217);
        posciciones.add(520);
        posciciones.add(196);
        posciciones.add(501);
        posciciones.add(214);
        posciciones.add(521);
        posciciones.add(236);
        posciciones.add(534);
        posciciones.add(254);
        posciciones.add(547);
        posciciones.add(262);
        posciciones.add(570);
        posciciones.add(288);
        posciciones.add(594);
        posciciones.add(313);
        posciciones.add(617);
        posciciones.add(334);
        posciciones.add(643);
        posciciones.add(357);
        posciciones.add(668);
        posciciones.add(381);
        posciciones.add(644);
        posciciones.add(414);
        posciciones.add(617);
        posciciones.add(433);
        posciciones.add(590);
        posciciones.add(454);
        posciciones.add(569);
        posciciones.add(478);
        posciciones.add(546);
        posciciones.add(499);
        posciciones.add(529);
        posciciones.add(514);
        posciciones.add(520);
        posciciones.add(526);
        posciciones.add(497);
        posciciones.add(550);
        posciciones.add(518);
        posciciones.add(568);
        posciciones.add(542);
        posciciones.add(548);
        posciciones.add(560);
        posciciones.add(544);
        posciciones.add(567);
        posciciones.add(524);
        posciciones.add(593);
        posciciones.add(505);
        posciciones.add(617);
        posciciones.add(480);
        posciciones.add(643);
        posciciones.add(559);
        posciciones.add(668);
        posciciones.add(432);
        posciciones.add(691);
        posciciones.add(409);
        posciciones.add(715);
        posciciones.add(432);
        posciciones.add(742);
        posciciones.add(457);
        posciciones.add(764);
        posciciones.add(482);
        posciciones.add(742);
        posciciones.add(456);
        posciciones.add(789);
        posciciones.add(505);
        posciciones.add(813);
        posciciones.add(523);
        posciciones.add(827);
        posciciones.add(546);
        posciciones.add(841);
        posciciones.add(551);
        posciciones.add(864);
        posciciones.add(572);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        CargaImagen();

        if (x > 613 && x < 781 && y > 598 && y < 631 && Turno==true) {
            g.drawImage(fondo2, 0, 0, null);
            if(mk.PressEnter){
               Turno=false; 
            }
        } else  {
           
            g.drawImage(fondo, 0, 0, null);


        }
        
        if(Turno==false){
             g.drawImage(noturno, 0, 0, null);
        }

        if (avanzar) {
            Avanzar(g);
            avanzar = false;
        }

        g.dispose();

    }

    public void Mouse() {
        // Obtener información sobre el puntero del mouse
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();

        // Obtener las coordenadas x e y
        x = (int) pointerInfo.getLocation().getX();
        y = (int) pointerInfo.getLocation().getY();

        // Imprimir las coordenadas
//        System.out.println("Posición del mouse - X: " + x + ", Y: " + y);
    }


    public void CargaImagen() {
        try {
            fondo = ImageIO.read(new FileInputStream("src\\images\\tablero completo.jpg"));
            fondo2 = ImageIO.read(new FileInputStream("src\\images\\tablero completo2.jpg"));
            noturno = ImageIO.read(new FileInputStream("src\\images\\no turno.png"));
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
