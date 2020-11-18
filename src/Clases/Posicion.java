/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Miguel
 */
public class Posicion {

    private int x, y;
    int aumento = 20;
    private int[][] lab;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
        lab = Tablero.elTablero;
    }

    public void moverArriba(int minY) {
        if(sePuedeMoverArri(minY)){
            y = y - aumento;
        }
    }

    public void moverAbajo(int maxY) {
        if(sePuedeMoverAba(maxY)){
            y = y + aumento;
        }
    }

    public void moverIzquierda(int minX) {
        if(sePuedeMoverIzq(minX)){
            x = x - aumento;
        }
    }

    public void moverDerecha(int maxX) {
        if(sePuedeMoverDer(maxX)){
            x = x + aumento;
        }
    }

    public boolean sePuedeMoverDer(int maxX) {
        if ((x + 20) + aumento <= maxX) {
            if (lab[(y / 20)][(x / 20) + 1] != 1) {
                if(lab[(y / 20)][(x / 20) + 1] == 7){
                    
                }
                return true;
            }
        }
        return false;
    }

    public boolean sePuedeMoverIzq(int minX) {
        if (x - aumento >= minX) {
            if (lab[(y / 20)][(x / 20) - 1] != 1) {
                return true;
            }
        }
        return false;
    }

    public boolean sePuedeMoverAba(int maxY) {
        if ((y + 20) + aumento <= maxY) {
            if (lab[(y / 20) + 1][x / 20] != 1) {
                return true;
            }
        }
        return false;
    }

    public boolean sePuedeMoverArri(int minY) {
        if (y - aumento >= minY) {
            if (lab[(y / 20) - 1][x / 20] != 1) {
                return true;
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "posicion en x: " + getX() + " posicion en  y: " + getY();
    }

}
