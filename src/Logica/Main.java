
package Logica;

import javax.swing.JFrame;


public class Main  extends JFrame {
    
    Panel p = new Panel();
    
    Main(){
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(p);
    }    
    
    
    public static void main(String[] args) {
        new Main();
    }
    
    
}
