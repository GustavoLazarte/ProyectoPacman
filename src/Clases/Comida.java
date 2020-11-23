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
    
    public Comida(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
    
}
