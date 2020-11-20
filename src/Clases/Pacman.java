/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Miguel
 */
public class Pacman{

    private int vida;
    private int puntos;
    private Posicion posicion;
    private boolean vivo;
    private ImageIcon imgActual;
    private ArrayList<ImageIcon> imagenes;
    private boolean estado;

    public Pacman(ArrayList<ImageIcon> img, Posicion pos) {
        imagenes = img;
        for (int i = 0; i < img.size(); i++) {
            img.get(i).setImage(img.get(i).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        }
        imgActual = img.get(0);
        posicion = pos;
    }

    public void paint(Graphics g) {
        if (estado) {
            g.drawImage(imgActual.getImage(), posicion.getX(), posicion.getY(), imgActual.getIconWidth(), imgActual.getIconHeight(), null); 
            
        } else{
            g.drawImage(imagenes.get(4).getImage(), posicion.getX(), posicion.getY(), imgActual.getIconWidth(), imgActual.getIconHeight(), null);
            
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

}
