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
public class Comida_Normal extends Comida {

    private static final int VALOR = 20;

    public Comida_Normal() {
        super(VALOR);
        ubic= new Ubicacion();
    }

    @Override
    void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(ubic.y, ubic.x, 20, 20);
        g.setColor(Color.blue);
        g.drawOval(ubic.y, ubic.x, 10, 10);
        
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }
    
    

}
