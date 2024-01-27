/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKeyBoard implements KeyListener {

   public boolean PressUp,PressDown,PressRight,PressLeft,PressEnter;
    
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
        
        switch(e.getKeyCode()){
            
            case KeyEvent.VK_W: PressUp=true; break;
            case KeyEvent.VK_S: PressDown=true;break;
            case KeyEvent.VK_A: PressLeft=true;break;
            case KeyEvent.VK_D: PressRight=true;break;
            case KeyEvent.VK_ENTER: PressEnter=true;break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    switch(e.getKeyCode()){
            
            case KeyEvent.VK_W: PressUp=false; break;
            case KeyEvent.VK_S: PressDown=false;break;
            case KeyEvent.VK_A: PressLeft=false;break;
            case KeyEvent.VK_D: PressRight=false;break;
            case KeyEvent.VK_ENTER: PressEnter=false;break;
        }
    }
    
    
    
}
