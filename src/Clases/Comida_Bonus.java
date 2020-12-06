package Clases;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel
 */
public class Comida_Bonus extends Comida {

    private static final int VALOR = 100;
    private boolean aparecer;

    public Comida_Bonus(ImageIcon sp) {        
        super(VALOR,sp);
        aparecer = false;
        ubic = new Ubicacion();
    }

    @Override
    void paint(Graphics g) {
        if(sprite != null && aparecer ){
            g.drawImage(sprite.getImage(),ubic.y, ubic.x, ancho, alto, null);
        }
        
    }

    @Override
    void setUbicacion(int x, int y) {
        ubic.setUbicacion(x, y);
    }
    
    public void aparecer(){
        aparecer = !aparecer;
    }
    
    @Override
    public int getValor() {
        if(aparecer){
            return valor;
        }
        
        return 0;
    }
}
