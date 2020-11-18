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
public abstract class Comida extends ObjetoDeJuego{
    protected Posicion posicion;
    protected int valor;

    public Comida(Posicion posicion, int valor) {
        this.posicion = posicion;
        this.valor = valor;
    }
    
    

    public int getValor() {
        return valor;
    }

    public Posicion getPosicion() {
        return posicion;
    }
    
    
}
