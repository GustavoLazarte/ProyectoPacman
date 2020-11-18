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
public abstract class Comida extends ObjetoDeJuego{
    protected int valor;

    protected int i;
    protected int j;
    
    public Comida(int valor) {
        this.valor = valor;
    }

    @Override
    void paint(Graphics g) {
        
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
    
    
    public int getValor() {
        return valor;
    }

    
    
}
