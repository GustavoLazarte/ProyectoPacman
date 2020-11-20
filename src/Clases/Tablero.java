/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Miguel
 */
public class Tablero{
    public static ObjetoDeJuego[][] elTablero;

    public Tablero() {
        elTablero = generarTablero();
    }

    public void paint(Graphics g) {

        for (int i = 0; i < elTablero.length; i++) {
            for (int j = 0; j < elTablero[i].length; j++) {
                if (elTablero[i][j] instanceof Muro) {
                    Muro aux = (Muro) (elTablero[i][j]);
                    aux.setUbicacion(i, j);
                    aux.paint(g);
                } else if (elTablero[i][j] instanceof Comida_Normal) {
                    Comida_Normal aux = (Comida_Normal) (elTablero[i][j]);
                    aux.setUbicacion(i, j);
                    aux.paint(g);
                } else if (elTablero[i][j] instanceof Portal) {
                    Portal aux = (Portal) (elTablero[i][j]);
                    aux.setUbicacion(i, j);
                    aux.paint(g);
                    //System.out.println(aux.getUbic().getX()+" "+ aux.getUbic().getY());
                }
            }
        }
    }

    private ObjetoDeJuego[][] generarTablero() {
        int[][] t = generarBaseTablero();
        elTablero = new ObjetoDeJuego[t.length][t[0].length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] == 1) {
                    elTablero[i][j] = new Muro();
                } else if (t[i][j] == 7) {
                    elTablero[i][j] = new Comida_Normal();
                } else if(t[i][j] == 8 ){
                    elTablero[i][j] = new  Portal();
                }
            }
        }

        return elTablero;
    }

    private int[][] generarBaseTablero() {
        int[][] t = { 
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 7, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 7, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 1, 1, 7, 7, 7, 1, 1, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0} };
        System.out.println(t.length + "a" + t[0].length);
        boolean res= t[0].equals(t[t.length-1]);
        System.out.println(res);
        return t;
    }

    public static ObjetoDeJuego[][] getElTablero() {
        return elTablero;
    }

}
