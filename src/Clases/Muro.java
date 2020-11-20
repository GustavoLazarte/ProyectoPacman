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

    public Muro() {
        ubic = new Ubicacion();
    }
    
    

    @Override
    void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(ubic.y, ubic.x, 20, 20);
        g.setColor(Color.blue);
        g.drawRect(ubic.y, ubic.x, 20, 20);
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }

    
    
}
