/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Miguel
 */
public class Pacman extends ObjetoDeJuego{
    private int vida;
    private int puntos;
    private Posicion posicion;
    private boolean vivo;
    private ImageIcon img;

    public Pacman(ImageIcon img,Posicion pos) {
        Image aux = img.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img = new ImageIcon(aux);
        this.img= img;
        posicion = pos;
    }

    public void paint(Graphics g){
        g.drawImage(img.getImage(), posicion.getX(), posicion.getY(),img.getIconWidth(),img.getIconHeight(), null);
    }
    public int getVida() {
        return vida;
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
        return img;
    }
    
}
