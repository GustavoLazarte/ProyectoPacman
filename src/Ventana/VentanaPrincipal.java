/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Interfaz_Juego.Juego;
import Interfaz_MenuJuego.Menu;
import Interfaz_PanelInicio.Panel_Inicio;
import java.awt.HeadlessException;
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

    public VentanaPrincipal() {
        menu = new Menu();
        menu.setVisible(false);
        inicio = new Panel_Inicio();
        setLayout(null);
        setBounds(350, 125, 516, 538);
        
        
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
                setBounds(350, 125, 635, 600);
                //setFocusable(false);
                j= new Juego();
                j.setVisible(true);
                add(j);
                addKeyListener(j.getKeyListeners()[0]);
                addKeyListener(j.getKeyListeners()[1]);
                addKeyListener(j.getKeyListeners()[2]);
            }
        });
    }

}
