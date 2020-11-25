/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_MenuJuego;

import Herramientas.Audio;
import Herramientas.BotonesPersonalizados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class Menu extends JPanel {
    private BotonesDeMenu botones;
    private JLabel fondo;
    private Audio audioFondo;

    public Menu() {
        setLayout(null);
        setOpaque(true);
        setVisible(false);
        setBounds(0,0,500, 500);
        agregarBotones();
        agregarMusiquita();
        agregarFondo();
        //setLayout(new BorderLayout());
    }

    private void agregarBotones() {
        int a= (int)(500* (0.5));
        botones = new BotonesDeMenu(getWidth()-a,375);
        botones.setLocation(a,getHeight()-botones.getHeight());
        add(botones);
    }
    
    private void agregarFondo() {
        ImageIcon ico= new ImageIcon("mapaPacman.gif");
        fondo= new JLabel(ico);
        fondo.setBounds(0, 0, getWidth(), getHeight());
        fondo.setBackground(Color.red);
        add(fondo);
    }

    private void agregarMusiquita() {
        if(isVisible()){
            audioFondo = new Audio();
            audioFondo.reproducir("audioDeFondo.wav");
        }
    }

    public BotonesDeMenu getBotones() {
        return botones;
    }
    

    
    
    
}
