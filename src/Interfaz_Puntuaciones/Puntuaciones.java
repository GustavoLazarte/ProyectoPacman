/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Puntuaciones;

import Clases.Puntuacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class Puntuaciones extends JPanel {

    private ArrayList<Puntuacion> puntuaciones;
    private Rectangle tamaño;

    public Puntuaciones() {
        puntuaciones = new ArrayList<>();
        tamaño = new Rectangle(0, 0, 500, 500);
        setLayout(null);
        setOpaque(true);
        setVisible(false);
        setBounds(tamaño);
        setBackground(Color.yellow);
    }

    public void agregarPuntuacion(Puntuacion nueva) {
        boolean agregado = false;

        if (puntuaciones.isEmpty()) {
            puntuaciones.add(nueva);
        }else {
            for (int i = 0; i < puntuaciones.size() && !agregado; i++) {
                if (nueva.compareTo(puntuaciones.get(i)) > 0) {
                    puntuaciones.add(i, nueva);
                    agregado = true;
                }
            }
            if(!agregado){
                puntuaciones.add(nueva);
            }
        }
    }

    public ArrayList<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

}
