/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Herramientas.Controles;
import Interfaz_Juego.Juego;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Miguel
 */
public class Pacman implements ActionListener {

    private Controles controles;
    private int vida;
    private int puntos;
    private Posicion posicion, inicial;
    private boolean vivo;
    private ImageIcon imgActual;
    private ArrayList<ImageIcon> imagenes;
    private JLabel[] vidas;
    private boolean estado;
    private int cantidadVidas;

    public Pacman(ArrayList<ImageIcon> img, Posicion pos, int jug) {
//        vidas = new JLabel[3];
//        crearVidas(img.get(0));
        cantidadVidas = 3;
        estado = true;
        imagenes = img;
        imgActual = img.get(0);
        inicial = new Posicion(pos.getX(), pos.getY(), (int)pos.getArea().getWidth(), (int)pos.getArea().getHeight());
        posicion = pos;
        if (jug == 1) {
            controles = new Controles(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, this);
        } else if (jug == 2) {
            controles = new Controles(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, this);
        }
        vivo = true;
    }

    public void paint(Graphics g) {
        if (estado) {
            g.drawImage(imgActual.getImage(), posicion.getX(), posicion.getY(), 25, 25, null);
        } else {
            g.drawImage(imagenes.get(4).getImage(), posicion.getX(), posicion.getY(), 25, 25, null);
        }
        estado = !estado;
    }

    public int getVida() {
        return vida;
    }

    public void setImg(int i) {
        this.imgActual = imagenes.get(i);
    }

    public int getPuntos() {
        return puntos;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public ImageIcon getImg() {
        return imgActual;
    }

    public Controles getControles() {
        return controles;
    }

    public void comer(int puntos) {
        this.puntos += puntos;
    }

    public void morir() {
        vivo= false;
        cantidadVidas--;
    }
    
    public void reiniciarPacman(){
        if(cantidadVidas > 0){
            posicion = new Posicion(inicial.getX(), inicial.getY(), (int)inicial.getArea().getMaxX(), (int)inicial.getArea().getMaxY());
            vivo = true;
        }
    }
    
    public boolean tieneVidas(){
        return cantidadVidas > 0;
    }
    
    public boolean isVivo() {
        return vivo;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (tieneVidas()) {
            if (getControles().isArriba()) {
                posicion.moverArriba();
            } else if (getControles().isAbajo()) {
                posicion.moverAbajo();
            } else if (getControles().isDer()) {
                posicion.moverDerecha();
            } else if (getControles().isIzq()) {
                posicion.moverIzquierda();
            }
            
            if(puntos >0 && puntos % 2500== 0){
                cantidadVidas++;
            }
        }
    }

    private void crearVidas(ImageIcon v) {
        ImageIcon vida= new ImageIcon(v.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        for (int i = 0; i < vidas.length; i++) {
            JLabel aux = new JLabel();
            aux.setOpaque(true);
            aux.setIcon(vida);
            aux.setBounds((10+(i*aux.getIcon().getIconWidth())), 500, 25, 25);
            aux.setVisible(true);
            vidas[i] = aux;
        }
    }

    public JLabel[] getVidas() {
        return vidas;
    }
}
