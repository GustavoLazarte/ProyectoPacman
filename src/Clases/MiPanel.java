/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class MiPanel extends JPanel {

    private Tablero miTablero;
    private Image imagen;
    private Pacman p;
    private boolean estado;

    public MiPanel() {;
        setBounds(50, 50, 500, 500);
        setVisible(true);
        System.out.println(getBounds().getMaxX());
        System.out.println(getBounds().getMinY());
        miTablero = new Tablero();
        File mimagen = new File("OIP.jpg");
        try {
            imagen = ImageIO.read(mimagen);
        } catch (IOException ex) {
            System.out.println("La imagen no se encuentra");
        }
        //p = new Pacman(imagen);
//        addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                p.getPosicion().mover(e, getBounds());
//                System.out.println(p.getPosicion().getX() + " " + p.getPosicion().getY());
//                repaint();
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //miTablero.dibujarTablero(g);
        //p.dibujar(g);
    }

    public boolean estado() {
        return estado;
    }

    public void setEstado() {
        estado = !estado;
    }
}
