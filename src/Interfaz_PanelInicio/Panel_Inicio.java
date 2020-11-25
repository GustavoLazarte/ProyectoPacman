/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_PanelInicio;

import Eventos.EfectoDeMouse;
import Herramientas.Audio;
import Herramientas.BotonesPersonalizados;
import Interfaz_MenuJuego.Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Miguel
 */
public class Panel_Inicio extends JPanel{
    private BotonesPersonalizados btn_inicio, btn_fin;
    private JLabel titulo, fondo;
    private Menu menu;
    private Audio audioFondo;

    public Panel_Inicio() {
        setLayout(null);
        setOpaque(true);
        
        setBounds(0,0,500, 500);
        agregarTitulo();
        agregarBotones();
        agregarMusiquita();
        //setBorder(new LineBorder(Color.red, 1));
        agregarFondo();   
        
        
    }
    
    

    private void agregarBotones() {
        agregarBotonInicio();
        agregarBotonSalir();
    }

    private void agregarBotonInicio() {
        int x = -(BotonesPersonalizados.ancho/2)+(getWidth()/2);
        int y = (((int)(getHeight()*0.75))- BotonesPersonalizados.alto)+5;
        ImageIcon imgico = new ImageIcon("Jugar.png");
        ImageIcon imgico2 = new ImageIcon("Jugar Claro.png");
        btn_inicio = new BotonesPersonalizados(x, y, imgico, imgico2);
        add(btn_inicio);
    }
    
    private void agregarBotonSalir() {
        int x = -(BotonesPersonalizados.ancho/2)+(getWidth()/2);
        int y = 375+ 5;
        ImageIcon imgico = new ImageIcon("Salir.png");
        ImageIcon imgico2 = new ImageIcon("Salir Claro.png");
        btn_fin = new BotonesPersonalizados(x, y, imgico,imgico2);
        
        add(btn_fin);
    }

    private void agregarFondo() {
        ImageIcon ico= new ImageIcon("mapaPacman.gif");
        fondo= new JLabel(ico);
        fondo.setBounds(0, 0, getWidth(), getHeight());
        fondo.setBackground(Color.red);
        add(fondo);
    }

    private void agregarTitulo() {
        int x,y;
        ImageIcon ico= new ImageIcon("titulo.png");
        x= -(ico.getIconWidth()/2)+250;
        y= ((int)(getHeight()*0.25))- ico.getIconHeight();
        titulo = new JLabel(ico);
        //titulo.setOpaque(true);
        //titulo.setBackground(Color.red);
        titulo.setBounds(x, y,ico.getIconWidth(),ico.getIconHeight());
        
        add(titulo);
    }

    private void agregarMusiquita() {
        audioFondo = new Audio();
        audioFondo.reproducir("audioDeFondo.wav");
    }

    public BotonesPersonalizados getBtn_inicio() {
        return btn_inicio;
    }

    public BotonesPersonalizados getBtn_fin() {
        return btn_fin;
    }
    
    
    
}
