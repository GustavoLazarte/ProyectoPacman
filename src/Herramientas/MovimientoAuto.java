/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Clases.Fantasma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Miguel
 */
public class MovimientoAuto implements ActionListener {

    private int contadorDeEspera, contadorReset;
    private Timer t;
    private Fantasma f;
    private boolean arriba = false,
            abajo = false,
            izq = false,
            der = true;
    private int contadorDePasos;

    public MovimientoAuto(Fantasma f) {
        this.f = f;
        t = new Timer(250, this);
        cambiarDireccion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (contadorDePasos < 10) {
            if (arriba) {
                if (f.getPosicion().sePuedeMoverArri()) {
                    f.getPosicion().moverArriba();
                    contadorDePasos++;
                } else {
                    cambiarDireccion();
                }
            } else if (abajo) {
                if (f.getPosicion().sePuedeMoverAba()) {
                    f.getPosicion().moverAbajo();
                    contadorDePasos++;
                } else {
                    cambiarDireccion();
                }

            } else if (der) {
                if (f.getPosicion().sePuedeMoverDer()) {
                    f.getPosicion().moverDerecha();
                    contadorDePasos++;
                } else {
                    cambiarDireccion();
                }

            } else if (izq) {
                if (f.getPosicion().sePuedeMoverIzq()) {
                    f.getPosicion().moverIzquierda();
                    contadorDePasos++;
                } else {
                    cambiarDireccion();
                }

            }
        }else{
            contadorDePasos = 0;
            cambiarDireccion();
        }
        if(contadorDeEspera== 25){
            f.cambiarEstado();
        }
    }

    private void cambiarDireccion() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                if (!arriba) {
                    arriba = true;
                    abajo = false;
                    izq = false;
                    der = false;
                    break;
                }
            case 1:
                if (!abajo) {
                    arriba = false;
                    abajo = true;
                    izq = false;
                    der = false;
                    break;
                }
            case 2:
                if (!der) {
                    arriba = false;
                    abajo = false;
                    izq = false;
                    der = true;
                    break;
                }
            case 3:
                if (!izq) {
                    arriba = false;
                    abajo = false;
                    izq = true;
                    der = false;
                    break;
                }
        }
    }

    public Timer getT() {
        return t;
    }
    
    public void iniciarMovimiento(){
        t.start();
    }

    
}
