/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Herramientas.MovimientoAuto;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel
 */
public class Fantasma {

    private boolean comible;
    private int valor;
    private Posicion posicion;
    private ImageIcon fantasmaNormal, fantasmaComible;
    private MovimientoAuto mov;

    public Fantasma(ImageIcon fantasmaNormal, ImageIcon fantasmaComible, Posicion p) {
        this.fantasmaNormal = fantasmaNormal;
        this.fantasmaComible = fantasmaComible;
        comible = false;
        posicion = p;
        mov = new MovimientoAuto(this);
    }

    public void paint(Graphics g) {
        if (!comible) {
            g.drawImage(fantasmaNormal.getImage(), posicion.getX(), posicion.getY(), 25, 25, null);
        } else {
            g.drawImage(fantasmaComible.getImage(), posicion.getX(), posicion.getY(), 25, 25, null);
        }
    }

    public void cambiarEstado() {
        comible = !comible;
    }

    public boolean esComible() {
        return comible == true;
    }

    public int getValor() {
        return valor;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public MovimientoAuto getMov() {
        return mov;
    }

    
}
