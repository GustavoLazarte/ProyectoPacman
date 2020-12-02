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
                if (elTablero[i][j] != null){
                    elTablero[i][j].setUbicacion(i, j);
                    elTablero[i][j].paint(g);
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
                }else if(t[i][j] == 9){
                    elTablero[i][j] = new  Comida_Especial();
                }else if(t[i][j] == 6){
                    elTablero[i][j] = new  Comida_Bonus();
                }else{
                    elTablero[i][j] = null;
                }
            }
        }

        return elTablero;
    }

    private int[][] generarBaseTablero() {
        int[][] t = { 
                { 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0},
                { 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 7, 7, 7, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 0, 7, 0, 1, 0, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0} };
        return t;
    }

    public static ObjetoDeJuego[][] getElTablero() {
        return elTablero;
    }
    
    public boolean hayComida(){
        boolean hay= false;
        for (int i = 0; i < elTablero.length && !hay ; i++) {
            for (int j = 0; j < elTablero[i].length && !hay; j++) {
                if (elTablero[i][j] instanceof Comida){
                    hay = true;
                } 
            }
        }
        
        return hay;
    }

    public static void setElTablero(ObjetoDeJuego[][] elTablero) {
        Tablero.elTablero = elTablero;
    }
    
    

}
