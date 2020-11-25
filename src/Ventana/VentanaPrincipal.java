/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Interfaz_Juego.Juego;
import Interfaz_MenuJuego.Menu;
import Interfaz_Opciones.Opciones;
import Interfaz_PanelInicio.Panel_Inicio;
import Interfaz_Puntuaciones.Puntuaciones;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Miguel
 */
public class VentanaPrincipal extends JFrame {

    private Menu menu;
    private Panel_Inicio inicio;
    private Juego j;
    private Rectangle tamañoMenu, tamañoJuego;
    private Opciones op;
    private Puntuaciones p;

    public VentanaPrincipal() {
        tamañoMenu = new Rectangle(350, 125, 516, 538);
        tamañoJuego = new Rectangle(350, 125, 635, 600);
        menu = new Menu();
        menu.setVisible(false);
        inicio = new Panel_Inicio();
        setLayout(null);
        setBounds(tamañoMenu);
        
        
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
                //setFocusable(false);
                j= new Juego();
                j.setVisible(true);
                add(j);
                add(j.getPuntuacion());
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
                op= new Opciones();
                op.setVisible(true);
                
                add(op);
            }
        });
        
        menu.getBotones().getBtn_Puntuaciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                setBounds(tamañoMenu);
                p= new Puntuaciones();
                p.setVisible(true);
                
                add(p);
            }
        });
    }

}
