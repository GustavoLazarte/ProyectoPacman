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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel
 */
public class Tablero{
    public static ObjetoDeJuego[][] elTablero;
    private ImageIcon comidaNormal;
    private ImageIcon comidaEspecial;
    private ImageIcon comidaBonus;
    private ImageIcon muro;
    private ImageIcon suelo;
    private ArrayList<ImageIcon> img;

    public Tablero(ArrayList<ImageIcon> img) {
        this.img = img;
        comidaNormal = img.get(0);
        comidaEspecial = img.get(1);
        comidaBonus = img.get(2);
        muro = img.get(3);
        suelo = new ImageIcon("Suelo.png");
        elTablero = generarTablero();
        
        
    }

    public void paint(Graphics g) {

        for (int i = 0; i < elTablero.length; i++) {
            for (int j = 0; j < elTablero[i].length; j++) {
                if (elTablero[i][j] != null){
                    elTablero[i][j].setUbicacion(i, j);
                    elTablero[i][j].paint(g);
                }else{
                    g.drawImage(suelo.getImage(), j*20, i*20, 20, 20, null);
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
                    elTablero[i][j] = new Muro(img.get(3));
                } else if (t[i][j] == 7) {
                    elTablero[i][j] = new Comida_Normal(img.get(0));
                } else if(t[i][j] == 8 ){
                    elTablero[i][j] = new  Portal(suelo);
                }else if(t[i][j] == 9){
                    elTablero[i][j] = new  Comida_Especial(img.get(1));
                }else if(t[i][j] == 6){
                    elTablero[i][j] = new  Comida_Bonus(img.get(2));
                }else{
                    elTablero[i][j] = null;
                }
            }
        }

        return elTablero;
    }

    private int[][] generarBaseTablero() {
        int[][] t = { 
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 0},
                { 0, 1, 1, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 9, 7, 7, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 7, 7, 7, 9, 1, 0},
                { 1, 1, 1, 1, 1, 1, 7, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 7, 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1, 1, 7, 1, 0, 1, 1, 1, 1, 1, 1, 0, 7, 7, 7, 1, 1, 1, 1, 1},
                { 8, 0, 0, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 7, 0, 0, 0, 0, 8},
                { 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1, 1},
                { 0, 1, 9, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 9, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 1, 7, 1, 1, 7, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 7, 1, 1, 7, 1, 1, 0},
                { 0, 1, 7, 7, 7, 7, 7, 1, 7, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
                { 0, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 0},
                { 0, 1, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 1, 0},
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
