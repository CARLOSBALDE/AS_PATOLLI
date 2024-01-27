/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as_patolli;

    //Dibuja y elijge por opciones del m
import Teclado.MyKeyBoard;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
    public class Menu{
      
     Gamepanel gp;
     MyKeyBoard mk;
      int option =1;   
     BufferedImage   start;
     BufferedImage   unirse;
     BufferedImage   foto;
     BufferedImage   salir;
    

        Menu(Gamepanel gp,MyKeyBoard teclado){
            
            
          this.gp = gp;
          this.mk = teclado;
           
          
          
          
         try {
             salir = ImageIO.read(new FileInputStream("src\\images\\SALIR.png"));
              foto = ImageIO.read(new FileInputStream("src\\images\\CAMBIAR FOTO.png"));
            start = ImageIO.read(new FileInputStream("src\\images\\CREAR PARTIDA.png"));
             unirse = ImageIO.read(new FileInputStream("src\\images\\UNIRSE.png"));
             
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
           
        }
        

        
    public void draw(Graphics2D g2) {

        if (option == 1) {
            g2.drawImage(start, 0, 0, null);
        } else if (option == 2) {
            g2.drawImage(unirse, 0, 0, null);
            
        } else if (option == 3) {
            g2.drawImage(foto, 0, 0, null);

        } else if(option ==4){
              g2.drawImage(salir, 0, 0, null);
        }
        
        Font font = new Font("Arial", Font.PLAIN, 16);
        g2.setFont(font);
        g2.setColor(Color.GREEN);

    }
    
    
    
    public Font FuenteLetra(){
         Font customFont=null;
         try {
             customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Windows\\Fonts\\Impact Normal.ttf")).deriveFont(16f);
         } catch (FontFormatException ex) {
              GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
         return customFont ;
    }
    
    
      public void update (){

          
          if(mk.PressDown==true){
          option++;
          try {
              gp.GameThread.sleep(200);
          } catch (InterruptedException ex) {
              Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
          }
       
      }
      if(mk.PressUp==true){
          option--;
             try {
              gp.GameThread.sleep(200);
          } catch (InterruptedException ex) {
              Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
                  if (option > 4) {
                option = 4;
            }
            if (option < 1) {
                option = 1;
            }
            
            if(mk.PressEnter==true){
                switch(option){
                    
                    case 1: gp.CREARPARTIDA=true;  gp.MENU=false;break;
                    case 2:gp.UNIRSEPARTIDA=true; gp.MENU=false;break;
                    case 3: gp.LOCAL=true;  gp.MENU=false; break;
                    case 4: System.exit(0); break;
                    
                    
                }
            }
             Point punto = MouseInfo.getPointerInfo().getLocation();
            int  x = (int) punto.getX();
            int y =(int)punto.getY();
            
            
      if(gp.CREARPARTIDA==true && x>809 &&y>581 && x>819 && y<627 && x<1019 && y>586 && x<1026 && y<628){
         
      }
            
  }  
        
    }