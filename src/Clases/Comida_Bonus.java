package Clases;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Miguel
 */
public class Comida_Bonus extends Comida {

    private static final int VALOR = 100;

    public Comida_Bonus() {
        super(VALOR);
        ancho = alto = 20;
        ubic = new Ubicacion();
    }

    @Override
    void paint(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(ubic.y, ubic.x, ancho, alto);
        g.setColor(Color.gray);
        g.drawOval(ubic.y, ubic.x, 10, 10);
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }

}
