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
public class Comida_Especial extends Comida{
    private static final int VALOR = 50;
    public Comida_Especial(Posicion posicion, int valor) {
        super(posicion, valor);
    }

    @Override
    void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
