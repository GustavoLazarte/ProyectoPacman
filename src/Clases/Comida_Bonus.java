
package Clases;

import java.awt.Graphics;

/**
 *
 * @author Miguel
 */
public class Comida_Bonus extends Comida{
    private static final int VALOR = 100;

    public Comida_Bonus(Posicion posicion, int valor) {
        super(posicion, valor);
    }
    
    public void aparecerPosicion(Posicion pos){
        posicion = pos;
    }

    @Override
    void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
