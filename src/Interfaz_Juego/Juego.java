/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Juego;

import Clases.Pacman;
import Clases.Posicion;
import Clases.Tablero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author Miguel
 */
public class Juego extends JPanel{
    private Tablero tab;
    private Pacman p;
    private Timer timer;
    private boolean arriba = false,
                    abajo  = false,
                    izq    = false,
                    der    = true;
                    

    public Juego() {
        setLayout(null);
        setOpaque(false);
        LineBorder borde= new LineBorder(Color.RED, 1);
        setBorder(borde);
        setBounds(10,10,501, 501);
        ImageIcon img= new ImageIcon("OIP.jpg");
        p = new Pacman(img, new Posicion(300,260));
        tab = new Tablero();
        
        darAccion();
        setFocusable(true);
        
    }
    public void paint(Graphics g){
        super.paint(g);
        p.paint(g);
        
        
    }



    public void darAccion() {
        
    timer = new Timer(125, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                if(arriba){
                    p.getPosicion().moverArriba(0);
                }else if(abajo){
                    p.getPosicion().moverAbajo(getHeight());
                }else if(der){
                    p.getPosicion().moverDerecha(getWidth());
                }else if(izq){
                    p.getPosicion().moverIzquierda(0);
                }
                System.out.println(p.getPosicion().toString());
                repaint();
            }
        });
        timer.start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    arriba = true;
                    abajo  = false;
                    izq    = false;
                    der    = false;
                    //repaint();
                }else if(e.getKeyCode()  == KeyEvent.VK_DOWN){
                    arriba = false;
                    abajo  = true;
                    izq    = false;
                    der    = false;
                }else if(e.getKeyCode()  == KeyEvent.VK_LEFT){
                    arriba = false;
                    abajo  = false;
                    izq    = true;
                    der    = false;
                }else if(e.getKeyCode()  == KeyEvent.VK_RIGHT){
                    arriba = false;
                    abajo  = false;
                    izq    = false;
                    der    = true;
                }  
                
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    
    
}
