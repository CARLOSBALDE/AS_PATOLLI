/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as_patolli;

import Logica.*;
import Teclado.MyKeyBoard;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ServerCliente.*;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.SwingWorker;

public class Gamepanel extends JPanel implements Runnable {

    public int codigo = 0;
    int FPS = 60;
    MyKeyBoard teclado = new MyKeyBoard();
  public  Thread GameThread = new Thread(this);
    Menu menu = new Menu(this, teclado);
    CrearPartida crearpartida = new CrearPartida(this, teclado);
    UnirsePartida unirsepartida = new UnirsePartida(this, teclado);
      JButton boton = new JButton("Mi Botón");
    public ConexionCodigo obj = new ConexionCodigo(this);
    public int palserver = 0;
    public CONFIGURARPARTIDA partida = new CONFIGURARPARTIDA(this);
    public ServidorTCP server = new ServidorTCP(this).getControlador();
     public boolean GAME = false;
    public ClienteTCP cliente = new ClienteTCP(this).getControlador();
 
    public String nombre = "";
    //boleanos
    boolean MENU = true;
    boolean CREARPARTIDA = false;
    boolean UNIRSEPARTIDA = false;
    public boolean CONECTADO = false;
    public boolean LOCAL = false;
    public boolean parametros = false;
    public boolean StartClient = false;
   

 public   Gamepanel() {
        this.addKeyListener(teclado);
        IniciarHiloJuego();
        this.setFocusable(true);
        boton.setBounds(600, 300, 200, 200);
        boton.setVisible(true);
        this.add(boton);
        this.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;  ///0.01666 segundos 
        double nextDrawtime = System.nanoTime() + drawInterval;

        while (GameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawtime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                GameThread.sleep((long) remainingTime);

                nextDrawtime += drawInterval;

            } catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void update() {
        menu.update();
    }

    void IniciarHiloJuego() {
        GameThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (MENU) {
            menu.draw(g2);
        }

        if (CREARPARTIDA) {

            if (parametros == false) {

                partida.SoloUnaVez();
            } else {

                if (palserver == 0) {
                    palserver = 1;
                    cliente.option = 1;
                    server.iniciarServidor();
                    cliente.iniciarCliente();
                }
                crearpartida.draw(g2);

            }

        }

        if (GAME) {
            GameThread=null;
           JUEGO game = new   JUEGO(this);
            GAME = false;
        }

        if (UNIRSEPARTIDA && CONECTADO == false) {

            obj.SoloUnaVez();

        }

        if (CONECTADO) {
            unirsepartida.draw(g2);
            if (StartClient == false) {
                cliente.option = 2;
                cliente.iniciarCliente();
                StartClient = true;
            }

        }

        g2.dispose();

    }

}
