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
    private Pacman p,p2;
    private Timer timer;
    private boolean arriba = false,
            abajo = false,
            izq = false,
            der = true;
    private boolean estado;
    private JLabel puntuacion;

    public Juego() {
        setLayout(null);
        setOpaque(true);
        LineBorder borde = new LineBorder(Color.RED, 1);
        setBorder(borde);
        setBackground(new Color(12, 20, 20));
        setBounds(0, 0, 481, 561);
        estado = false;
        puntuacion = new JLabel();
        puntuacion.setBounds(550, 125, 100, 50);
        puntuacion.setVisible(true);
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        imagenes.add(new ImageIcon("PacmanDer.png"));
        imagenes.add(new ImageIcon("PacmanIzq.png"));
        imagenes.add(new ImageIcon("PacmanArri.png"));
        imagenes.add(new ImageIcon("PacmanAba.png"));
        imagenes.add(new ImageIcon("pacmanCerrado.png"));
        tab = new Tablero();
        p = new Pacman(imagenes, new Posicion(260, 280, getWidth() - 1, getHeight() - 1),1);
        //p2 = new Pacman(imagenes, new Posicion(240, 280, getWidth() - 1, getHeight() - 1), 2);
        //p2.getControles().setIzq();
        darAccion();
        setFocusable(true);

    }

    private void iniciarJuego() {

    }

    public void paint(Graphics g) {

        super.paint(g);
        tab.paint(g);
        p.paint(g);
        //p2.paint(g);

    }

    public void darAccion() {

        timer = new Timer(145, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado) {
                    if (p.getControles().isArriba()) {
                        p.getPosicion().moverArriba();
                    } else if (p.getControles().isAbajo()) {
                        p.getPosicion().moverAbajo();
                    } else if (p.getControles().isDer()) {
                        p.getPosicion().moverDerecha();
                    } else if (p.getControles().isIzq()) {
                        p.getPosicion().moverIzquierda();
                    }
                    
//                    if (p2.getControles().isArriba()) {
//                        p2.getPosicion().moverArriba();
//                    } else if (p2.getControles().isAbajo()) {
//                        p2.getPosicion().moverAbajo();
//                    } else if (p2.getControles().isDer()) {
//                        p2.getPosicion().moverDerecha();
//                    } else if (p2.getControles().isIzq()) {
//                        p2.getPosicion().moverIzquierda();
//                    }
                    comer();
//                    comer2();
                    repaint();
                }
                
                
            }
        });
        timer.start();
        addKeyListener(p.getControles());
        //addKeyListener(p2.getControles());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    estado = true;
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
            Comida_Normal aux= (Comida_Normal)tab.getElTablero()[pacy / 20][pacx / 20];
            p.setPuntos(aux.getValor());
            puntuacion.setText(""+p.getPuntos());
            tab.getElTablero()[pacy / 20][pacx / 20] = null;
        }
        //System.out.println(p.getPuntos());
    }
    
    private void comer2() {
        int pacx = p2.getPosicion().getX();
        int pacy = p2.getPosicion().getY();
        if (tab.getElTablero()[pacy / 20][pacx / 20] instanceof Comida_Normal) {
            tab.getElTablero()[pacy / 20][pacx / 20] = null;
        }
    }

    public JLabel getPuntuacion() {
        return puntuacion;
    }
    
    
}
