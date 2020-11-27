/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Opciones;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class Opciones extends JPanel{

    private Rectangle tamaño;
    private JMenuBar barraDeMenu; 

    public Opciones() {
        tamaño = new Rectangle(0, 0, 500, 500);
        setLayout(null);
        setOpaque(true);
        setVisible(false);
        setBounds(tamaño);
        barraDeMenu = new JMenuBar();
        barraDeMenu.setBackground(Color.red);
        barraDeMenu.setBounds(0,0,500,50);
        add(barraDeMenu);
        JMenu skin= new JMenu("Apariencia");
        barraDeMenu.add(skin);
        skin.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel nsd= new JPanel();
            }
        });
    }
    
}
