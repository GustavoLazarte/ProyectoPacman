/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Miguel
 */
public class Fantasma {
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
    
    
}
