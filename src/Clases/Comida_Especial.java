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
public class Comida_Especial extends Comida {

    private static final int VALOR = 50;

    public Comida_Especial() {
        super(VALOR);
        ancho = alto = 15;
        ubic = new Ubicacion();
    }

    @Override
    void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(ubic.y, ubic.x, ancho, alto);
        g.setColor(Color.BLACK);
        g.drawOval(ubic.y, ubic.x, 10, 10);
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }

}
