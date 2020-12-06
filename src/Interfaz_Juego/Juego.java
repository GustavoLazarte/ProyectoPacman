/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Juego;

import Clases.Comida;
import Clases.Comida_Bonus;
import Clases.Comida_Especial;
import Clases.Comida_Normal;
import Clases.Fantasma;
import Clases.Pacman;
import Clases.Posicion;
import Clases.Tablero;
import Herramientas.Audio;
import Interfaz_Opciones.Opciones;
import Interfaz_Puntuaciones.Puntuaciones;
import Ventana.VentanaPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Miguel
 */
public class Juego extends JPanel {

    public static final int EN_CURSO = 1;
    public static final int NO_INICIADO = 0;
    public static final int TERMINADO = -1;
    private int[][] nivel1, nivel2, nivel3;
    private Tablero tab;
    private Pacman p;
    private Timer timer;
    private int estado, nivel, contadorComida;
    private JLabel puntuacion;
    private Color colorDeFondo;
    private Rectangle tamaño;
    private Audio audioDeComer, audioDeFondo, audioInicial;
    private Fantasma[] fantasmas;
    private JLabel etiqueta;
    private JLabel etiquetaDeAviso;
    private Font fuente;
    private int contador;
    private JPanel panelRegistrador;
    private Puntuaciones pun;

    public Juego(Opciones op, Puntuaciones p) {
        cambiarAspectoPanel();
        instanciarVariablesJuego(op);
        instanciarHerramientasDeJuego();
        estado = NO_INICIADO;
        iniciarJuego();
        setFocusable(true);

    }

    private void cargarImagenes(ArrayList<ImageIcon> img, ArrayList<ImageIcon> des, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            des.add(img.get(i));
        }
    }

    private void iniciarJuego() {
        //VentanaPrincipal.detenerMusica();
        audioInicial.reproducir("audio.wav");
        darAccion();
        obtenerControles();
    }

    public void paint(Graphics g) {

        tab.paint(g);
        super.paint(g);
        fantasmas[0].paint(g);
        fantasmas[1].paint(g);
        fantasmas[2].paint(g);
        fantasmas[3].paint(g);
        p.paint(g);

    }

    private void darAccion() {
        timer = new Timer(155, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado == EN_CURSO) {
                    if (sePuedeComer(p.getPosicion())) {
                        comer();
                    }
                    if (!p.tieneVidas() || !tab.hayComida()) {
                        if (!tab.hayComida() && nivel < 3) {
                            avanzarNivel();
                        } else {
                            estado = TERMINADO;
                        }
                    }
                    if(contadorComida >= 120 && contadorComida % 120== 0){
                        tab.aparecerFrutitas();
                        contadorComida++;
                    }else{
                        contadorComida++;
                        System.out.println(contadorComida);
                    }
                    repaint();
                } else if (estado == TERMINADO) {
                    quitarAcciones();
                    terminarJuego();
                    timer.stop();
                } else if (estado == NO_INICIADO) {
                    activarJuego();
                    repaint();
                }

            }
        });
        timer.start();

    }

    private void terminarJuego() {
        if (!tab.hayComida() && nivel == 3) {
            etiquetaDeAviso.setText("Winner");
            etiquetaDeAviso.setVisible(true);
            
        } else {
            etiquetaDeAviso.setText("Game Over");
            etiquetaDeAviso.setVisible(true);
        }
    }

    private void obtenerControles() {
        addKeyListener(p.getControles());
    }

    private void comer() {
        int pacx = p.getPosicion().getX();
        int pacy = p.getPosicion().getY();

        if (!audioDeComer.estaEnCurso()) {
            audioDeComer.reproducir("wakawaka.wav");
        }

        Comida aux = (Comida) tab.getElTablero()[pacy / 20][pacx / 20];
        if(aux instanceof Comida_Bonus){
            Comida_Bonus frutitas = (Comida_Bonus)(aux);
            p.comer(frutitas.getValor());
        }else if (aux instanceof Comida_Especial) {
            Comida_Especial suero = (Comida_Especial) aux;
            suero.cambiarEstado(fantasmas);
            p.comer(suero.getValor());
        }else{
            p.comer(aux.getValor());
        }
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

    private void agregarFantasmas(ImageIcon fanNormal, ImageIcon fanRaro) {
        for (int i = 0; i < fantasmas.length; i++) {
            fantasmas[i] = new Fantasma(fanNormal, fanRaro, new Posicion(220, 240, getWidth(), getHeight()));
        }
    }

    private void reiniciarPosiciones() {
        p.reiniciarPacman();
        for (int i = 0; i < fantasmas.length; i++) {
            fantasmas[i].reiniciarFantasma();
        }
    }

    private void iniciarMovimientos() {
        for (int i = 0; i < fantasmas.length; i++) {
            if(fantasmas[i].getMov().getP() == null){
                fantasmas[i].getMov().setP(p);
            }
        }
    }

    private void detenerMovimientos() {
        for (int i = 0; i < fantasmas.length; i++) {
//            fantasmas[i].getMov().detenerTiempo();
        }
    }

    private void agregarScore() {
        fuente = new Font("MegaMan 2", Font.BOLD, 15);
        etiqueta = new JLabel("Score");
        etiqueta.setBounds(10, 10, 80, 20);
        etiqueta.setFont(fuente);
        etiqueta.setForeground(colorDeFondo.YELLOW);
        etiqueta.setVisible(true);
        puntuacion = new JLabel();
        puntuacion.setBounds(100, 10, 100, 20);
        puntuacion.setFont(fuente);
        puntuacion.setForeground(colorDeFondo.WHITE);
        puntuacion.setVisible(true);
        
        p.getEtiquetaVidas().setBounds(10, 610, 100, 20);
        p.getEtiquetaVidas().setFont(fuente);
        p.getEtiquetaVidas().setForeground(Color.YELLOW);
        
        p.getEtiquetaCantidad().setBounds(100, 610, 100, 20);
        p.getEtiquetaCantidad().setFont(fuente);
        p.getEtiquetaCantidad().setForeground(colorDeFondo.WHITE);
        
        
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public Pacman getP() {
        return p;
    }

    private void agregarEtiquetaDeAviso() {
        etiquetaDeAviso = new JLabel("READY!");
        etiquetaDeAviso.setFont(new Font("Megaman 2", Font.BOLD, 15));
        etiquetaDeAviso.setOpaque(false);
        etiquetaDeAviso.setBounds(170, 280, 250, 25);
        etiquetaDeAviso.setForeground(Color.YELLOW);
        etiquetaDeAviso.setVisible(true);
        add(etiquetaDeAviso);
    }

    public void activarJuego() {
        if (contador == 35) {
            etiquetaDeAviso.setVisible(false);
            etiquetaDeAviso.setText("GAME OVER");
            audioDeFondo.reproducirInfinito("pacmansiren.wav");
            añadirAcciones();
            iniciarMovimientos();
            audioInicial.stop();
            estado = EN_CURSO;
            contador = -1;
        } else if (contador > -1) {
            contador++;
            System.out.println(contador);
        }
    }

    private void avanzarNivel() {
        quitarAcciones();
        nivel++;
        switch (nivel) {
            case 2:
                nivel2 = getNivel2();
                tab.setElTablero(nivel2);
                break;
            case 3:
                tab.setElTablero(nivel3);
                break;
        }
        reiniciarPosiciones();
        estado = NO_INICIADO;
        contador = 0;
        audioDeFondo.stop();
        etiquetaDeAviso.setText("READY!");
        etiquetaDeAviso.setVisible(true);
    }

    public int[][] getNivel3() {
        int[][] t2 = {
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 9, 7, 7, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 7, 7, 9, 1, 0},
            {0, 1, 7, 1, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 1, 7, 1, 0},
            {0, 1, 7, 7, 7, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 7, 7, 7, 1, 0},
            {1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1},
            {8, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7, 7, 7, 8},
            {1, 1, 1, 1, 1, 7, 1, 7, 7, 1, 1, 1, 1, 1, 1, 7, 7, 1, 7, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 7, 1, 7, 1, 1, 9, 7, 7, 9, 1, 1, 7, 7, 7, 1, 1, 1, 1, 0},
            {0, 1, 1, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 7, 7, 1, 7, 7, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 7, 1, 1, 0},
            {0, 1, 7, 7, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 7, 7, 1, 0},
            {0, 1, 7, 1, 1, 1, 1, 7, 1, 7, 1, 0, 0, 1, 7, 1, 7, 1, 1, 1, 1, 7, 1, 0},
            {0, 1, 7, 7, 7, 7, 7, 7, 1, 7, 1, 0, 0, 1, 7, 1, 7, 7, 7, 7, 7, 7, 1, 0},
            {0, 1, 7, 1, 1, 7, 1, 7, 1, 7, 7, 1, 1, 7, 7, 1, 7, 1, 7, 1, 1, 7, 1, 0},
            {0, 1, 7, 1, 1, 7, 7, 7, 1, 1, 7, 7, 7, 7, 1, 1, 7, 7, 7, 1, 1, 7, 1, 0},
            {0, 1, 7, 1, 1, 7, 1, 7, 7, 1, 7, 1, 1, 7, 1, 7, 7, 1, 7, 1, 1, 7, 1, 0},
            {0, 1, 7, 7, 7, 7, 1, 1, 7, 7, 7, 0, 0, 7, 7, 7, 1, 1, 7, 7, 7, 7, 1, 0},
            {0, 1, 1, 7, 1, 7, 1, 7, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 7, 7, 7, 1, 1, 9, 7, 7, 9, 1, 1, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 7, 1, 1, 1, 7, 7, 1, 1, 7, 7, 7, 1, 7, 7, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 7, 1, 1, 7, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 0},
            {1, 1, 1, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7, 1, 7, 7, 7, 7, 7, 7, 1, 1, 1},
            {8, 7, 1, 1, 1, 1, 7, 1, 1, 1, 7, 7, 1, 7, 1, 1, 1, 7, 1, 1, 1, 1, 7, 8},
            {1, 7, 7, 1, 1, 7, 7, 7, 1, 1, 7, 1, 1, 7, 1, 1, 7, 7, 7, 1, 1, 7, 7, 1},
            {1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 1, 1, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1},
            {0, 1, 7, 1, 1, 7, 7, 7, 1, 1, 7, 1, 1, 7, 1, 1, 7, 7, 7, 1, 1, 7, 1, 0},
            {0, 1, 7, 7, 7, 7, 1, 1, 1, 9, 7, 7, 7, 7, 9, 1, 1, 1, 7, 7, 7, 7, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};

        return t2;
    }

    public int[][] getNivel1a() {
        int[][] t = {
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 1, 0},
            {0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
            {0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
            {0, 1, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 7, 7, 7, 7, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 0},
            {0, 1, 1, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 9, 7, 7, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 7, 7, 7, 9, 1, 0},
            {1, 1, 1, 1, 1, 1, 7, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 7, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 7, 1, 0, 1, 1, 1, 1, 1, 1, 0, 7, 7, 7, 1, 1, 1, 1, 1},
            {8, 0, 0, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 7, 0, 0, 0, 0, 8},
            {1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1},
            {0, 1, 9, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 9, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 1, 1, 0},
            {0, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
            {0, 1, 7, 7, 7, 7, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 1, 0},
            {0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
            {0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
            {0, 1, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(t.length + " " + t[0].length);
        return t;
    }

    public int[][] getNivel1() {
        int[][] t = {
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 8},
            {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 9, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(t.length + " " + t[0].length);
        return t;
    }

    public int[][] getNivel2() {
        int[][] t = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1},
            {1, 7, 1, 1, 1, 1, 7, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 7, 1, 1, 1, 7, 1},
            {1, 7, 1, 1, 1, 1, 7, 7, 7, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1},
            {8, 7, 7, 7, 7, 7, 7, 1, 7, 7, 7, 9, 7, 7, 7, 7, 1, 7, 1, 1, 1, 1, 7, 8},
            {1, 7, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 7, 1, 1, 7, 7, 1, 1, 9, 7, 1},
            {1, 7, 9, 1, 1, 7, 7, 7, 7, 7, 1, 1, 1, 1, 7, 7, 7, 7, 1, 1, 1, 1, 7, 1},
            {1, 7, 1, 1, 1, 1, 7, 1, 1, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 7, 7, 1},
            {1, 7, 7, 7, 7, 7, 7, 1, 1, 7, 1, 7, 1, 7, 1, 7, 1, 1, 7, 7, 7, 7, 1, 1},
            {1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 7, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 7, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 7, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 7, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 7, 7, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 7, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 7, 1, 1, 1, 1, 1},
            {8, 0, 0, 0, 0, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 7, 0, 0, 0, 0, 8},
            {1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 7, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 7, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 1, 1, 1, 1, 1},
            {8, 7, 7, 7, 7, 7, 1, 1, 7, 7, 9, 1, 1, 9, 7, 7, 1, 1, 7, 7, 7, 7, 7, 8},
            {1, 7, 1, 7, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 7, 1, 7, 1},
            {1, 7, 1, 1, 1, 7, 1, 1, 7, 7, 1, 1, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 7, 1},
            {1, 7, 7, 9, 1, 7, 1, 1, 7, 1, 7, 1, 1, 7, 1, 7, 1, 1, 7, 1, 9, 7, 7, 1},
            {1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1},
            {8, 7, 7, 7, 1, 1, 7, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 7, 1, 1, 7, 7, 7, 8},
            {1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1},
            {1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
        return t;
    }

    private void añadirAcciones() {
        timer.addActionListener(p);
        timer.addActionListener(fantasmas[0].getMov());
        timer.addActionListener(fantasmas[1].getMov());
        timer.addActionListener(fantasmas[2].getMov());
        timer.addActionListener(fantasmas[3].getMov());
    }

    private void quitarAcciones() {
        timer.removeActionListener(p);
        timer.removeActionListener(fantasmas[0].getMov());
        timer.removeActionListener(fantasmas[1].getMov());
        timer.removeActionListener(fantasmas[2].getMov());
        timer.removeActionListener(fantasmas[3].getMov());
    }

    private void instanciarVariablesJuego(Opciones op) {
        nivel = 1;
        nivel1 = getNivel1();
        fantasmas = new Fantasma[4];
        ArrayList<ImageIcon> img = op.getApariencia();
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        cargarImagenes(img, imagenes, 0, 4);
        ArrayList<ImageIcon> imagenesTab = new ArrayList<>();
        cargarImagenes(img, imagenesTab, 5, 9);
        tab = new Tablero(imagenesTab, nivel1);
        p = new Pacman(imagenes, new Posicion(260, 280, getWidth(), getHeight()), op.getControl(1));
        agregarFantasmas(img.get(10), img.get(11));
    }

    private void cambiarAspectoPanel() {
        colorDeFondo = new Color(12, 20, 20);
        tamaño = new Rectangle(10, 40, 480, 560);
        setLayout(null);
        setOpaque(false);
        setBackground(colorDeFondo);
        setBounds(tamaño);
        setFocusable(true);
    }

    private void instanciarHerramientasDeJuego() {
        audioInicial = new Audio();
        audioDeComer = new Audio();
        audioDeFondo = new Audio();
        agregarPanelAnotador();
        agregarScore();
        agregarEtiquetaDeAviso();
    }
    
    public JLabel agregarEtiquetaDeVida(){
        return p.getEtiquetaVidas();
    }
    
    public JLabel agregarEtiquetaDeCantidad(){
        return p.getEtiquetaCantidad();
    }

    private void agregarPanelAnotador() {
        panelRegistrador = new JPanel();
        panelRegistrador.setBackground(colorDeFondo);
        panelRegistrador.setOpaque(true);
        panelRegistrador.setBounds(getWidth()/3, getHeight()/3, 200, 100);
        JTextField text = new JTextField();
        text.setOpaque(true);
        text.setBackground(Color.red);
        text.setBounds(panelRegistrador.getWidth()/8, panelRegistrador.getHeight()/3, 200, 30);
        text.setVisible(true);
        panelRegistrador.add(text);
        
        
        panelRegistrador.setVisible(true);
        add(panelRegistrador);
    }

}
