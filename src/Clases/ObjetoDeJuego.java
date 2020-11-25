/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;

/**
 *
 * @author Miguel
 */
public abstract class ObjetoDeJuego {
    protected Ubicacion ubic;
    protected int ancho,alto;
    abstract void paint(Graphics g);
    abstract void setUbicacion(int x, int y);

    public Ubicacion getUbic() {
        return ubic;
    }
    
    
}
