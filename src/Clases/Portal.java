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
public class Portal extends ObjetoDeJuego{

    public Portal() {
        super();
        ubic= new Ubicacion();
    }
    
    

    @Override
    void paint(Graphics g) {
        
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }
    
}
