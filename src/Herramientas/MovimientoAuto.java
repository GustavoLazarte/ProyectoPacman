/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Clases.Fantasma;
import Clases.Pacman;
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
    private int limite;
    private Pacman p;

    public MovimientoAuto(Fantasma f) {
        this.f = f;
//        t = new Timer(155, this);
        cambiarDireccion();
        limite = 15;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (t.isRunning()) {
            //if (contadorDePasos < limite) {
            if (arriba) {
                if (f.getPosicion().sePuedeMoverArri()) {
                    f.getPosicion().moverArriba();
                    contadorDePasos++;
                    if (hayColisionAbajo()) {
                        p.setVivo();
//                        detenerTiempo();
                    }
                } else {
                    cambiarDireccion();
                }
            } else if (abajo) {
                if (f.getPosicion().sePuedeMoverAba()) {
                    f.getPosicion().moverAbajo();
                    contadorDePasos++;
                    if (hayColisionArriba()) {
                        p.setVivo();
//                        detenerTiempo();
                    }
                } else {
                    cambiarDireccion();
                }

            } else if (der) {
                if (f.getPosicion().sePuedeMoverDer()) {
                    f.getPosicion().moverDerecha();
                    contadorDePasos++;
                    if (hayColisionIzq()) {
                        p.setVivo();
//                        detenerTiempo();
                    }
                } else {
                    cambiarDireccion();
                }

            } else if (izq) {
                if (f.getPosicion().sePuedeMoverIzq()) {
                    f.getPosicion().moverIzquierda();
                    contadorDePasos++;
                    if (hayColisionDer()) {
                        p.setVivo();
//                        detenerTiempo();
                    }
                } else {
                    cambiarDireccion();
                }
            }

//                contadorDePasos++;
//            } else {
//                contadorDePasos = 0;
//                cambiarDireccion();
//            }
//        }
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

//    public void detenerTiempo() {
//        t.stop();
//    }

    public boolean hayColision(Pacman p) {
        return hayColisionIzq() || hayColisionDer() || hayColisionArriba() || hayColisionAbajo();
    }

    private boolean hayColisionArriba() {
        if (f.getPosicion().getX() == p.getPosicion().getX()) {
            if (f.getPosicion().getY() == p.getPosicion().getY() - 20) {
                if ((p.getControles().isArriba() || p.getControles().isAbajo()) && (abajo)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la arri");
                        return true;
                    }
                } else if ((p.getControles().isDer() || p.getControles().isIzq()) && (abajo)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la arri");
                        return true;
                    }
                } else if ((izq || der) && (p.getControles().isArriba())) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la arri r");
                        return true;
                    }
                } else if (abajo && p.getControles().isAbajo()) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la arri r");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hayColisionAbajo() {
        if (f.getPosicion().getX() == p.getPosicion().getX()) {
            if (f.getPosicion().getY() == p.getPosicion().getY() + 20) {
                if ((p.getControles().isArriba() || p.getControles().isAbajo()) && (arriba)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la abajo");
                        return true;
                    }
                } else if ((p.getControles().isDer() || p.getControles().isIzq()) && (arriba)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la abajo");
                        return true;
                    }
                } else if ((izq || der) && (p.getControles().isAbajo())) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la abajo");
                        return true;
                    }
                } else if (arriba && p.getControles().isArriba()) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la abajo r");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hayColisionIzq() {
        if (f.getPosicion().getY() == p.getPosicion().getY()) {
            if (f.getPosicion().getX() == p.getPosicion().getX() - 20) {
                if ((p.getControles().isArriba() || p.getControles().isAbajo()) && (der)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la izq");
                        return true;
                    }
                } else if ((p.getControles().isDer() || p.getControles().isIzq()) && (der)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la izq");
                        return true;
                    }
                } else if ((arriba || abajo) && (p.getControles().isIzq())) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la izq r");
                        return true;
                    }
                } else if (der && p.getControles().isDer()) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la izq r");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean hayColisionDer() {
        if (f.getPosicion().getY() == p.getPosicion().getY()) {
            if (f.getPosicion().getX() == p.getPosicion().getX() + 20) {
                if ((p.getControles().isArriba() || p.getControles().isAbajo()) && (izq)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la der");
                        return true;
                    }
                } else if ((p.getControles().isDer() || p.getControles().isIzq()) && (izq)) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la der");
                        return true;
                    }
                } else if ((arriba || abajo) && (p.getControles().isDer())) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la der r");
                        return true;
                    }
                } else if (izq && p.getControles().isIzq()) {
                    if (!f.esComible()) {
                        p.setImg(4);
                        System.out.println("hay colision por la der r");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Timer getT() {
        return t;
    }

//    public void iniciarMovimiento() {
//        t.start();
//    }

    public boolean isArriba() {
        return arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public boolean isIzq() {
        return izq;
    }

    public boolean isDer() {
        return der;
    }

    public void setP(Pacman p) {
        this.p = p;
    }

}
