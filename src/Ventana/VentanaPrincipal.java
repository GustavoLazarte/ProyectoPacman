package Ventana;

import Herramientas.Controles;
import Interfaz_Juego.Juego;
import Interfaz_MenuJuego.Menu;
import Interfaz_Opciones.Opciones;
import Interfaz_PanelInicio.Panel_Inicio;
import Interfaz_Puntuaciones.Puntuaciones;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    private Menu menu;
    private Panel_Inicio inicio;
    private Juego j;
    private Rectangle tamañoMenu, tamañoJuego, tamanioP;
    private Opciones op;
    private Puntuaciones p;
    private final Toolkit miPc;

    public VentanaPrincipal() {
        miPc = Toolkit.getDefaultToolkit();
        Dimension dimPantalla = miPc.getScreenSize();
        tamañoMenu = new Rectangle(dimPantalla.width/4, dimPantalla.height/32, 516, 538);
        tamañoJuego = new Rectangle(dimPantalla.width/4, dimPantalla.height/32, 500+16, 680);
        tamanioP = new Rectangle(350, 125, 516, 835);
        menu = new Menu();
        menu.setVisible(false);
        inicio = new Panel_Inicio();
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setBounds(tamañoMenu);
        p = new Puntuaciones();
        j = new Juego();
        double a=getSize().getWidth() - j.getWidth();
        System.out.println(a);
        add(inicio);
        add(menu);
        darAccionABotones();
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void darAccionABotones() {
        inicio.getBtn_inicio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.setVisible(false);
                menu.setVisible(true);
            }
        });

        inicio.getBtn_fin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.getBotones().getBtn_Iniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                setBounds(tamañoJuego);
                j.setVisible(true);
                add(j);
                add(j.getPuntuacion());
                add(j.getEtiqueta());
//                for (int i = 0; i < j.getP().getVidas().length; i++) {
//                    add(j.getP().getVidas()[i]);
//                }
                addKeyListener(j.getKeyListeners()[0]);
                addKeyListener(j.getKeyListeners()[1]);
                //addKeyListener(j.getKeyListeners()[2]);
            }
        });

        menu.getBotones().getBtn_OpcionesDeJuego().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                setBounds(tamañoMenu);
                op = new Opciones(new Controles(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, null), new Controles(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, null), menu);
                op.setVisible(true);

                add(op);
            }
        });

        menu.getBotones().getBtn_Puntuaciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                setBounds(tamañoJuego);
                //setBounds(tamañoJuego);
                p.setVisible(true);
                add(p);
            }
        });
        p.getBtn_regresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                menu.setVisible(true);
                setBounds(tamañoMenu);
            }
        });
//        j.getBtn_regresar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                j.setVisible(false);
//                menu.setVisible(true);
//                setBounds(tamañoMenu);
//            }
//        });
    }
}
