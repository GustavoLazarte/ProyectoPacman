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
public class Fantasma extends ObjetoDeJuego{
    private boolean comible;
    private int valor;
    private Posicion posicion;

    public Fantasma() {
        comible = false;
    }
    
    public void cambiarEstado(){
        comible = !comible;
    }
    public boolean esComible() {
        return comible==true;
    }

    public int getValor() {
        return valor;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
