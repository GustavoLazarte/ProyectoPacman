/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Juego;

import Clases.Comida;
import Clases.Comida_Normal;
import Clases.Fantasma;
import Clases.Pacman;
import Clases.Posicion;
import Clases.Tablero;
import Herramientas.Audio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Miguel
 */
public class Juego extends JPanel {

    public static final int EN_CURSO = 1;
    public static final int NO_INICIADO = 0;
    public static final int TERMINADO = -1;

    private Tablero tab;
    private Pacman p;
    private Timer timer;
    private int estado;
    private JLabel puntuacion;
    private Color colorDeFondo;
    private Rectangle tamaño;
    private Audio audioDeComer, audioDeFondo;
    private Fantasma[] fantasmas;
    private boolean hayCambio;

    public Juego() {
        hayCambio = true;
        audioDeComer = new Audio();
        audioDeFondo = new Audio();
        colorDeFondo = new Color(12, 20, 20);
        tamaño = new Rectangle(0, 0, 481, 561);
        fantasmas = new Fantasma[1];
        setLayout(null);
        setOpaque(true);
        setBackground(colorDeFondo);
        setBounds(tamaño);
        estado = 0;
        puntuacion = new JLabel();
        puntuacion.setBounds(550, 125, 100, 50);
        puntuacion.setVisible(true);
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        imagenes.add(new ImageIcon("pacmanDer.png"));
        imagenes.add(new ImageIcon("pacmanIzq.png"));
        imagenes.add(new ImageIcon("pacmanArri.png"));
        imagenes.add(new ImageIcon("pacmanAba.png"));
        imagenes.add(new ImageIcon("pacmanCerrado.png"));
        tab = new Tablero();
        p = new Pacman(imagenes, new Posicion(260, 280, getWidth() - 1, getHeight() - 1), 1);
        agregarFantasmas();
        iniciarJuego();
        setFocusable(true);

    }

    private void iniciarJuego() {
        darAccion();
        obtenerControles();
    }

    public void paint(Graphics g) {
        super.paint(g);
        tab.paint(g);
        fantasmas[0].paint(g);
//        fantasmas[1].paint(g);
//        fantasmas[2].paint(g);
//        fantasmas[3].paint(g);
        p.paint(g);

    }

    private void darAccion() {
        timer = new Timer(145, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado == EN_CURSO) {
                    if (sePuedeComer(p.getPosicion())) {
                        comer();
                    }
                    if (!p.isVivo() || !tab.hayComida()) {
                        estado = TERMINADO;
                    }
                    repaint();
                } else if (estado == TERMINADO) {
                    detenerMovimientos();
                    timer.stop();
                }
            }
        });

        timer.start();
    }

    private void obtenerControles() {
        addKeyListener(p.getControles());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    estado = EN_CURSO;
                    audioDeFondo.reproducirInfinito("pacmansiren.wav");
                    timer.addActionListener(p);
                    timer.addActionListener(fantasmas[0].getMov());
                    iniciarMovimientos();
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

        if (!audioDeComer.estaEnCurso()) {
            audioDeComer.reproducir("wakawaka.wav");
        }

        Comida aux = (Comida) tab.getElTablero()[pacy / 20][pacx / 20];
        p.comer(aux.getValor());
        puntuacion.setText("" + p.getPuntos());
        tab.getElTablero()[pacy / 20][pacx / 20] = null;
    }

    public JLabel getPuntuacion() {
        return puntuacion;
    }

    private boolean sePuedeComer(Posicion pacman) {
        int pacx = pacman.getX();
        int pacy = pacman.getY();

        return tab.getElTablero()[pacy / 20][pacx / 20] instanceof Comida;
    }

    private void agregarFantasmas() {
        for (int i = 0; i < fantasmas.length; i++) {
            fantasmas[i] = new Fantasma(new ImageIcon("200.gif"), new ImageIcon("201.gif"), new Posicion(240, 520, getWidth() - 1, getHeight() - 1));
        }
    }

    private void iniciarMovimientos() {
        for (int i = 0; i < fantasmas.length; i++) {
//            fantasmas[i].getMov().iniciarMovimiento();
            fantasmas[i].getMov().setP(p);
        }
    }

    private void detenerMovimientos() {
        for (int i = 0; i < fantasmas.length; i++) {
//            fantasmas[i].getMov().detenerTiempo();
        }
    }

}
