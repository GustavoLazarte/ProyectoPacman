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
public class Posicion{

    private int x, y;
    private static final int aumento = 20;
    private ObjetoDeJuego[][] lab;
    private Rectangle area;
    private final int columnas;
    private final int filas;

    public Posicion(int x, int y, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        lab = Tablero.elTablero;
        area = new Rectangle(0, 0, maxX, maxY);
        filas = lab.length;
        columnas = lab[0].length;
    }

    public void moverArriba() {
        if (sePuedeMoverArri()) {
            y = y - aumento;
        }
    }

    public void moverAbajo() {
        if (sePuedeMoverAba()) {
            y = y + aumento;
        }
    }

    public void moverIzquierda() {
        if (sePuedeMoverIzq()) {
            x = x - aumento;
        }
    }

    public void moverDerecha() {
        if (sePuedeMoverDer()) {
            x = x + aumento;
        }
    }

    public boolean sePuedeMoverDer() {
        try {
            if (estaAdentroX()) {
                if (((x / 20) + 1) < columnas && !(lab[(y / 20)][(x / 20) + 1] instanceof Muro)) {
                    return true;
                } else if (lab[(y / 20)][(x / 20)] instanceof Portal) {
                    if (lab[(y / 20)][0] instanceof Portal) {
                        x = lab[y / 20][0].getUbic().getY();
                        return true;
                    }

                }
            } else {
                if (((x + aumento) + aumento / 20) < filas) {
                    return true;
                }
                System.out.println("estoy fuera der");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(x + " " + y + " derecha");
        }
        return false;
    }

    public boolean sePuedeMoverIzq() {
        //int minX = (int) (area.getMinX());
        try {
            if (estaAdentroX()) {
                if (((x / 20) - 1) >= 0 && !(lab[(y / 20)][(x / 20) - 1] instanceof Muro)) {
                    return true;
                } else if (lab[(y / 20)][(x / 20)] instanceof Portal) {
                    if (lab[(y / 20)][lab[y / 20].length - 1] instanceof Portal) {
                        x = lab[y / 20][lab[y / 20].length - 1].getUbic().getY();
                        return true;
                    }
                }
            } else {
                if (((x - aumento) / 20) > 0) {
                    return true;
                }
                System.out.println("estoy fuera izq");
            }
        } catch (Exception e) {
            System.out.println(x + " " + y + " izquierda");
        }
        return false;
    }

    public boolean sePuedeMoverAba() {
        //int maxY = (int) (area.getMaxY());
        try {
            if (estaAdentroY()) {
                if (((y / 20) + 1) < filas && !(lab[(y / 20) + 1][x / 20] instanceof Muro)) {
                    return true;
                } else if (lab[(y / 20)][(x / 20)] instanceof Portal) {
                    if (lab[0][(x / 20)] instanceof Portal) {
                        y = lab[0][x / 20].getUbic().getX();
                        return true;
                    }
                }
            } else {
                if (((y + aumento) + aumento / 20) < columnas) {
                    return true;
                }
                System.out.println("estoy fuera aba");
            }
        } catch (Exception e) {
            System.out.println(x + " " + y + " abajo");
        }
        return false;
    }

    public boolean sePuedeMoverArri() {
        //int minY = (int) (area.getMinY());
        try {
            if (estaAdentroY()) {
                if (((y / 20 - 1) >= 0) && !(lab[(y / 20) - 1][x / 20] instanceof Muro)) {
                    return true;
                } else if (lab[(y / 20)][(x / 20)] instanceof Portal) {
                    if (lab[lab[x / 20].length - 1][x / 20] instanceof Portal) {
                        y = lab[lab[x / 20].length - 1][x / 20].getUbic().getX();
                        return true;
                    }
                }

            } else {
                if (((y - aumento) / 20) > 0) {
                    return true;
                }
                System.out.println("estoy fuera arri");
            }
        } catch (Exception e) {
            System.out.println(x + " " + y + " arriba");
        }
        return false;
    }

    public boolean estaAdentroX() {
        return (x + aumento <= area.getMaxX() && x >= area.getMinX());
    }

    public boolean estaAdentroY() {
        return ((y + aumento <= area.getMaxY()) && y >= area.getMinY());
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
