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

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverArriba(int minY) {
        int[][] lab = Tablero.elTablero;
        if (y - aumento >= minY) {
            try {
                if (lab[(y / 20) - 1][x / 20] != 1) {
                    y = y - aumento;
                }
            } catch (Exception e) {
            }

        }
    }

    public void moverAbajo(int maxY) {
        int[][] lab = Tablero.elTablero;
        if ((y + 20) + aumento <= maxY) {
            try {
                if (lab[(y / 20) + 1][x / 20] != 1) {
                    y = y + aumento;
                }
            } catch (Exception e) {
            }

        }
    }

    public void moverIzquierda(int minX) {
        int[][] lab = Tablero.elTablero;
        if (x - aumento >= minX) {
            try {
                if (lab[(y / 20)][(x / 20) - 1] != 1) {
                    x = x - aumento;
                }
            } catch (Exception e) {
            }

        }
    }

    public void moverDerecha(int maxX) {
        int[][] lab = Tablero.elTablero;
        if ((x + 20) + aumento <= maxX) {
            try {
                if (lab[(y / 20)][(x / 20) + 1] != 1) {
                    x = x + aumento;
                }
            } catch (Exception e) {
            }

        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public String toString(){
        return "posicion en x: "+ getX()+" posicion en  y: "+getY();
    }

}
