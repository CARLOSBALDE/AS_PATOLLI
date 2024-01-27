
package Logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Game  extends JPanel implements Runnable {
      
   Thread stop = new Thread();
      
    
    int unidad=25;
    int x,y;
    int mitad;
         BufferedImage   fondo;
    
    
   public Game(){
        this.setPreferredSize(new Dimension(800, 600));
        repaint();
        this.x = this.getX();
        this.y = this.getY();
        mitad = x/2;
           stop.start();
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       draw(g);
//       DesenfocarFondo(g);
        GenerarCuadrados2(g);
        GenerarCuadrados(g);

        
    }
    
    
    public void draw(Graphics g){
   
        
    }

    @Override
    public void run() {
              
         Mouse();
        repaint();
        
    }
     public void Mouse(){
        // Obtener información sobre el puntero del mouse
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();

        // Obtener las coordenadas x e y
        int x = pointerInfo.getLocation().x;
        int y = pointerInfo.getLocation().y;

        // Imprimir las coordenadas
        System.out.println("Posición del mouse - X: " + x + ", Y: " + y);
    }
    

    
    public void GenerarCuadrados(Graphics g){
        g.setColor(Color.orange);
        for (int i = 2; i <31; i++) {
            for (int j = 2; j < 20; j++) {
                
              if(i==15 || i==16){
                  g.fillRect(i*unidad, j*unidad, unidad-2, unidad-2);
                    if(j==4 || j==17){
                     g.setColor(Color.red);
                         g.fillRect(i*unidad, j*unidad, unidad-2, unidad-2);
                        g.setColor(Color.orange);
                 }  
              }
              
              
            }
        }
        
        for (int i = 7; i < 25; i++) {
            for (int j = 10; j <= 11; j++) {
           
                 g.fillRect(i*unidad, j*unidad, unidad-2, unidad-2);
                if(i==9 || i==22){
                     g.setColor(Color.red);
                      g.fillRect(i*unidad, j*unidad, unidad-2, unidad-2);
                        g.setColor(Color.orange);
                 }
            }
            
            
        }
    }
    
    
    public void GenerarCuadrados2(Graphics g){
     g.setColor(Color.black);
        for (int i = 2; i <31; i++) {
            for (int j = 2; j < 20; j++) {
                
              if(i==15 || i==16){
                  g.fillRect(i*unidad, j*unidad, unidad, unidad);
                    if(j==4 || j==17){
                    g.setColor(Color.black);
                         g.fillRect(i*unidad, j*unidad, unidad, unidad);
                     g.setColor(Color.black);
                 }  
              }
              
              
            }
        }
        
        for (int i = 7; i < 25; i++) {
            for (int j = 10; j <= 11; j++) {
           
                 g.fillRect(i*unidad, j*unidad, unidad, unidad);
                if(i==9 || i==22){
                    g.setColor(Color.black);
                      g.fillRect(i*unidad, j*unidad, unidad, unidad);
                        g.setColor(Color.black);
                 }
            }
            
            
        }
    }
    
    
    
    
}






