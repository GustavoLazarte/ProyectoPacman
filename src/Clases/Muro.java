/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Miguel
 */
public class Muro extends ObjetoDeJuego {

    private int i;
    private int j;

    @Override
    void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(j * 20, i * 20, 20, 20);
        g.setColor(Color.blue);
        g.drawRect(j * 20, i * 20, 20, 20);
    }

    public void setUbicacion(int i, int j){
        setI(i);
        setJ(j);
    }
    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    
}
