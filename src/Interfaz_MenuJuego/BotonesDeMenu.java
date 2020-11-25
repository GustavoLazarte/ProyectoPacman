/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_MenuJuego;

import Herramientas.BotonesPersonalizados;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class BotonesDeMenu extends JPanel {

    private BotonesPersonalizados btn_Iniciar;
    private BotonesPersonalizados btn_OpcionesDeJuego;
    private BotonesPersonalizados btn_Puntuaciones;
    private BotonesPersonalizados btn_Salir;

    public BotonesDeMenu(int ancho,  int alto) {
        setSize(ancho, alto);
        setLayout(null);
        setOpaque(false);
        agregarBotones();
    }

    private void agregarBotones() {
        agregarBotonIniciar();
        agregarBotonOpcionesDeJuego();
        agregarBotonVerPuntuaciones();
    }

    private void agregarBotonIniciar() {
        int x = ((getWidth()/2)- (BotonesPersonalizados.ancho/2));
        //System.out.println(x);
        int y = (int)(getHeight()*0.375)-75;
        ImageIcon imgico = new ImageIcon("Jugar.png");
        ImageIcon imgico2 = new ImageIcon("Jugar Claro.png");
        btn_Iniciar = new BotonesPersonalizados(x, y, imgico, imgico2);
        add(btn_Iniciar);
    }

    private void agregarBotonVerPuntuaciones() {
        int x = ((getWidth()/2)- (BotonesPersonalizados.ancho/2));
        int y = (int)(getHeight()*0.625)-75;
        ImageIcon imgico = new ImageIcon("Jugar.png");
        ImageIcon imgico2 = new ImageIcon("Jugar Claro.png");
        btn_Puntuaciones = new BotonesPersonalizados(x, y, imgico, imgico2);
        add(btn_Puntuaciones);
    }

    private void agregarBotonOpcionesDeJuego() {
        int x = ((getWidth()/2)- (BotonesPersonalizados.ancho/2));
        int y = (int)(getHeight()*0.875)-75;
        ImageIcon imgico = new ImageIcon("Opciones.png");
        ImageIcon imgico2 = new ImageIcon("Opciones Claro.png");
        btn_OpcionesDeJuego = new BotonesPersonalizados(x, y, imgico, imgico2);
        add(btn_OpcionesDeJuego);
    }

    public BotonesPersonalizados getBtn_Iniciar() {
        return btn_Iniciar;
    }

    public BotonesPersonalizados getBtn_OpcionesDeJuego() {
        return btn_OpcionesDeJuego;
    }

    public BotonesPersonalizados getBtn_Puntuaciones() {
        return btn_Puntuaciones;
    }

    public BotonesPersonalizados getBtn_Salir() {
        return btn_Salir;
    }
    
    
}
