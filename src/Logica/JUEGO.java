
package Logica;

import as_patolli.Gamepanel;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class JUEGO extends javax.swing.JFrame implements Runnable {

    int turno = 1;
    int clicks = 0;
    Dados dados = new Dados();
    int checker = 0;
    Thread stop = new Thread(this);
    BufferedImage fondo;
    BufferedImage fondo2;
    BufferedImage ficha1;
    BufferedImage ficha2;
    BufferedImage ficha3;
    BufferedImage ficha4;
    Gamepanel gp;
    Teclado.MyKeyBoard mk = new Teclado.MyKeyBoard();

    ArrayList<Integer> posciciones = new ArrayList<Integer>();

    public JUEGO controlador = null;

    boolean cañasenjuego = false, Tirando = false, start = true;
    int jugadores, nfichas, Avance = -1, x, y;
    int Avance2 = 33, Avance3 = 67, Avance4 = 101;
    BufferedImage C1;
    BufferedImage C2;
    BufferedImage[] cañas = new BufferedImage[5];

    boolean J1, J2, J3, J4;

    public JUEGO getControlador() {

        if (controlador == null) {
            return controlador = new JUEGO(this.gp);
        }
        return controlador;

    }

    public int LlenarCañas(Graphics g) {

        int num = 50;
        int Dados = dados.AvanzarCasillas();
        for (int i = 0; i < 5; i++) {
            if (Dados > i) {
                g.drawImage(C2, 230 + num, 570, null);
            } else {
                g.drawImage(C1, 230 + num, 570, null);

            }
            num = num + 50;

//            g.drawImage(C1,280+100,570, null);
//            g.drawImage(C1,280+150,570, null);
//            g.drawImage(C1,280+200,570, null);
        }
        return Dados;
    }

    public JUEGO(Gamepanel gp) {
        initComponents();
        stop.start();
        LlenarPos();
        this.gp = gp;;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        CargaImagen();

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Obtener las coordenadas relativas al JFrame
                int x = e.getX();
                int y = e.getY();

                // Imprimir las coordenadas
                System.out.println("Posición del mouse en JFrame - X: " + x + ", Y: " + y);
            }
        });

    }

    public void LlenarPos() {

        posciciones.add(581);
        posciciones.add(506);
        posciciones.add(604);
        posciciones.add(494);
        posciciones.add(581);
        posciciones.add(465);
        posciciones.add(570);
        posciciones.add(453);
        posciciones.add(555);
        posciciones.add(441);
        posciciones.add(534);
        posciciones.add(417);
        posciciones.add(509);
        posciciones.add(391);
        posciciones.add(476);
        posciciones.add(370);
        posciciones.add(459);
        posciciones.add(344);
        posciciones.add(435);
        posciciones.add(319);
        posciciones.add(462);
        posciciones.add(295);
        posciciones.add(480);
        posciciones.add(272);
        posciciones.add(510);
        posciciones.add(251);
        posciciones.add(535);
        posciciones.add(227);
        posciciones.add(559);
        posciciones.add(202);
        posciciones.add(575);
        posciciones.add(191);
        posciciones.add(585);
        posciciones.add(174);
        posciciones.add(605);
        posciciones.add(154);
        posciciones.add(583);
        posciciones.add(138);
        posciciones.add(564);
        posciciones.add(155);
        posciciones.add(550);
        posciciones.add(168);
        posciciones.add(537);
        posciciones.add(180);
        posciciones.add(512);
        posciciones.add(201);
        posciciones.add(487);
        posciciones.add(226);
        posciciones.add(462);
        posciciones.add(248);
        posciciones.add(437);
        posciciones.add(272);
        posciciones.add(411);
        posciciones.add(297);
        posciciones.add(389);
        posciciones.add(271);
        posciciones.add(362);
        posciciones.add(249);
        posciciones.add(336);
        posciciones.add(223);
        posciciones.add(315);
        posciciones.add(200);
        posciciones.add(289);
        posciciones.add(174);
        posciciones.add(278);
        posciciones.add(162);
        posciciones.add(263);
        posciciones.add(151);
        posciciones.add(239);
        posciciones.add(132);
        posciciones.add(220);
        posciciones.add(150);
        posciciones.add(241);
        posciciones.add(171);
        posciciones.add(248);
        posciciones.add(190);
        posciciones.add(268);
        posciciones.add(200);
        posciciones.add(287);
        posciciones.add(223);
        posciciones.add(312);
        posciciones.add(248);
        posciciones.add(337);
        posciciones.add(272);
        posciciones.add(362);
        posciciones.add(294);
        posciciones.add(385);
        posciciones.add(319);
        posciciones.add(365);
        posciciones.add(350);
        posciciones.add(337);
        posciciones.add(368);
        posciciones.add(313);
        posciciones.add(390);
        posciciones.add(287);
        posciciones.add(414);
        posciciones.add(265);
        posciciones.add(436);
        posciciones.add(252);
        posciciones.add(450);
        posciciones.add(239);
        posciciones.add(465);
        posciciones.add(211);
        posciciones.add(485);
        posciciones.add(237);
        posciciones.add(502);
        posciciones.add(261);
        posciciones.add(483);
        posciciones.add(277);
        posciciones.add(475);
        posciciones.add(289);
        posciciones.add(459);
        posciciones.add(311);
        posciciones.add(441);
        posciciones.add(337);
        posciciones.add(418);
        posciciones.add(361);
        posciciones.add(393);
        posciciones.add(386);
        posciciones.add(368);
        posciciones.add(412);
        posciciones.add(343);
        posciciones.add(434);
        posciciones.add(369);
        posciciones.add(460);
        posciciones.add(390);
        posciciones.add(485);
        posciciones.add(415);
        posciciones.add(508);
        posciciones.add(440);
        posciciones.add(531);
        posciciones.add(461);
        posciciones.add(540);
        posciciones.add(479);
        posciciones.add(561);
        posciciones.add(488);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(fondo, 10, 30, null);
        int dados = LlenarCañas(g);

        if (Tirando) {

//            if(gp.cliente.nplayer==gp.cliente.turno){
//                System.out.println(gp.cliente.nplayer);
//            }
            if (start == false) {

            } else {
                switch (turno) {
                    case 1:
                        if (J1 && dados != 0) {

                            Avance = Avance + 2*dados;
                        } else {

                            if (J1 == false) {
                                Avance++;
                            }
                            J1 = true;
                        }

                        turno = 2;
                        break;
                    case 2:
                        if (J2 && dados != 0) {
                            Avance2 = Avance2 + 2*dados;
                        } else {

                            if (J2 == false) {
                                Avance2++;
                            }
                            J2 = true;
                        }

                        turno = 3;
                        break;
                    case 3:

                        if (J3 && dados != 0) {
                            Avance3 = Avance3 + 2*dados;
                        } else {

                            if (J3 == false) {
                                Avance3++;
                            }
                            J3 = true;
                        }

                        turno = 4;
                        break;

                    case 4:

                        if (J4 && dados != 0) {
                            Avance4 = Avance4 + 2*dados;
                        } else {
                            if (J4 == false) {
                                Avance4++;
                            }

                            J4 = true;
                        }

                        turno = 1;
                        break;

                }
            }

//            if (Avance % 3 == 0 &&  Avance!=0 && J1) {
//                Avance--;
//            }
//            if (Avance2 % 3 == 0 &&  Avance2!=0 && J2) {
//                Avance2--;
//            }
//            if (Avance3 % 3 == 0 &&  Avance3!=0 && J3) {
//                Avance3--;
//            }
//            if (Avance4 % 3 == 0 &&  Avance4!=0 && J4) {
//                Avance4--;
//            }

            if (J1) {
                g.drawImage(ficha1, posciciones.get(Avance) - 35, posciciones.get(Avance + 1) - 30, null);
            }
            if (J2) {
                g.drawImage(ficha2, posciciones.get(Avance2) - 35, posciciones.get(Avance2 + 1) - 30, null);
            }
            if (J3) {
                g.drawImage(ficha3, posciciones.get(Avance3) - 35, posciciones.get(Avance3 + 1) - 30, null);
            }
            if (J4) {
                g.drawImage(ficha4, posciciones.get(Avance4) - 35, posciciones.get(Avance4 + 1) - 30, null);
            }

            System.out.println();

            Tirando = false;
            System.out.println(dados);
//            Avanzar(g);
        }

    }

    public void Avanzar(Graphics g) {
        int con = 0;
        for (checker = 0; checker < posciciones.size(); checker++) {

            g.drawImage(ficha1, posciciones.get(checker), posciciones.get(checker + 1), null);
            g.drawImage(ficha2, posciciones.get(checker), posciciones.get(checker + 1), null);

//          con++;
//          if(con==02){
//              con=0;
//          }
            if (con == Avance) {
                Avance = -1;
                System.out.println("contando");
                break;

            }
            con++;
            checker = checker + 2;
            repaint();
        }

        if (checker < posciciones.size()) {
            checker = 0;
        }

        Tirando = false;

    }

    public void Mouse() {
        // Obtener información sobre el puntero del mouse
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();

        // Obtener las coordenadas x e y
        x = (int) pointerInfo.getLocation().getX();
        y = (int) pointerInfo.getLocation().getY();

        // Imprimir las coordenadas
        System.out.println("Posición del mouse - X: " + x + ", Y: " + y);
    }

    public void CargaImagen() {
        try {
//            fondo = ImageIO.read(new FileInputStream("src\\images\\tablero completo.jpg"));
            fondo = ImageIO.read(new FileInputStream("src\\images\\tab.jpg"));
            fondo2 = ImageIO.read(new FileInputStream("src\\images\\tablero completo2.jpg"));
            ficha1 = ImageIO.read(new FileInputStream("src\\images\\ficha morada.png"));
            ficha2 = ImageIO.read(new FileInputStream("src\\images\\ficha rosa.png"));
            ficha3 = ImageIO.read(new FileInputStream("src\\images\\ficha verde.png"));
            ficha4 = ImageIO.read(new FileInputStream("src\\images\\ficha negra.png"));

            C1 = ImageIO.read(new FileInputStream("src\\images\\CAÑA.png"));
            C2 = ImageIO.read(new FileInputStream("src\\images\\CAÑA2.png"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        NAME = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Lanzar Cañas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        NAME.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jButton1)
                .addContainerGap(346, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAME)
                .addGap(380, 380, 380))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(463, Short.MAX_VALUE)
                .addComponent(NAME)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Avance == posciciones.size() - 1) {
            Avance = -1;
        }
        if (Avance2 == posciciones.size() - 1) {
            Avance2 = -1;
        }
        if (Avance3 == posciciones.size() - 1) {
            Avance3 = -1;
        }
        if (Avance4 == posciciones.size() - 1) {
            Avance4 = -1;
        }

//        switch (turno) {
//            case 1:
//                Avance++;
//W
//                turno = 2;
////Avance+=dados.AvanzarCasillas();
//                break;
//            case 2:
//                Avance2++;
////                    turno = 3; Avance2+=dados.AvanzarCasillas();
//                break;
//            case 3:
//                Avance3++;
////                    turno = 4;    Avance3+=dados.AvanzarCasillas();
//                break;
//
//            case 4:
//
////                    turno = 1;   Avance4+=dados.AvanzarCasillas();
//                Avance4++;
//                break;
//
//        }
        Tirando = true;
        repaint();

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JUEGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Gamepanel gp = new Gamepanel();
                new JUEGO(gp).setVisible(true);

            }
        });
    }

    @Override
    public void run() {
        while (stop != null) {
//Mouse();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NAME;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
