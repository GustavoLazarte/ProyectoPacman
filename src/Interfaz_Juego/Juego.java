/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Juego;

import Clases.Comida_Normal;
import Clases.Muro;
import Clases.Pacman;
import Clases.Posicion;
import Clases.Tablero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author Miguel
 */
public class Juego extends JPanel {

    private Tablero tab;
    private Pacman p;
    private Timer timer;
    private boolean arriba = false,
                    abajo = false,
                    izq = false,
                    der = true;

    public Juego() {
        setLayout(null);
        setOpaque(true);
        LineBorder borde = new LineBorder(Color.RED, 1);
        setBorder(borde);
        setBackground(new Color(12, 20, 20));
        setBounds(20, 0, 521, 561);
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        imagenes.add(new ImageIcon("PacmanDer.png"));
        imagenes.add(new ImageIcon("PacmanIzq.png"));
        imagenes.add(new ImageIcon("PacmanArri.png"));
        imagenes.add(new ImageIcon("PacmanAba.png"));
        imagenes.add(new ImageIcon("pacmanCerrado.png"));
        tab = new Tablero();
        p = new Pacman(imagenes, new Posicion(260, 280, getWidth() - 1, getHeight() - 1));

        darAccion();
        setFocusable(true);

    }

    public void paint(Graphics g) {

        super.paint(g);
        tab.paint(g);
        p.paint(g);

    }

    public void darAccion() {

        timer = new Timer(140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arriba) {
                    p.getPosicion().moverArriba();
                } else if (abajo) {
                    p.getPosicion().moverAbajo();
                } else if (der) {
                    p.getPosicion().moverDerecha();
                } else if (izq) {
                    p.getPosicion().moverIzquierda();
                }
                comer();
                //System.out.println(p.getPosicion().toString());
                repaint();
            }
        });
        timer.start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (p.getPosicion().sePuedeMoverArri()) {
                        arriba = true;
                        abajo = false;
                        izq = false;
                        der = false;
                        p.setImg(2);
                    }
                    //repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (p.getPosicion().sePuedeMoverAba()) {
                        arriba = false;
                        abajo = true;
                        izq = false;
                        der = false;
                        p.setImg(3);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (p.getPosicion().sePuedeMoverIzq()) {
                        arriba = false;
                        abajo = false;
                        izq = true;
                        der = false;
                        p.setImg(1);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (p.getPosicion().sePuedeMoverDer()) {
                        arriba = false;
                        abajo = false;
                        izq = false;
                        der = true;
                        p.setImg(0);
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void comer() {
        int pacx = p.getPosicion().getX();
        int pacy = p.getPosicion().getY();
        if (tab.getElTablero()[pacy / 20][pacx / 20] instanceof Comida_Normal) {
            tab.getElTablero()[pacy / 20][pacx / 20] = null;
        }
    }
}
