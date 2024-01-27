package as_patolli;

import Logica.Game;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameFrame extends JFrame {

    public static void main(String[] args) {
        
        GameFrame obj = new GameFrame();
        obj.setTitle("PATOLLI");
        obj.add(new Game());
        obj.add(new Gamepanel());
        obj.setVisible(true);
        obj.pack();
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
        obj.setSize(800, 600);
        
    }

}
