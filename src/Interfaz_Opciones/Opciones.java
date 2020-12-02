/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Opciones;

import Herramientas.Controles;
import Interfaz_MenuJuego.Menu;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Miguel
 */
public class Opciones extends JPanel{

    private Rectangle tamaño;
    private JMenuBar barraDeMenu;
    final private Hashtable<String, Integer> teclas;
    private JTextField arribaUno;
    private JTextField abajoUno;
    private JTextField izquierdaUno;
    private JTextField derechaUno;
    private JTextField arribaDos;
    private JTextField abajoDos;
    private JTextField izquierdaDos;
    private JTextField derechaDos;
    private JButton guardar;
    private JButton cancelar;

    public Opciones(Controles c1, Controles c2, Menu menu) {
        teclas = new Hashtable();
        crearDictTeclas();
        crearOpcionesJugador(1, c1);
        crearOpcionesJugador(2, c2);
        crearCampos(c1, c2);
        crearBotones(c1, c2, menu);
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

    private void crearDictTeclas(){
        teclas.put("A", KeyEvent.VK_A);
        teclas.put("B", KeyEvent.VK_B);
        teclas.put("C", KeyEvent.VK_C);
        teclas.put("D", KeyEvent.VK_D);
        teclas.put("E", KeyEvent.VK_E);
        teclas.put("F", KeyEvent.VK_F);
        teclas.put("G", KeyEvent.VK_G);
        teclas.put("H", KeyEvent.VK_H);
        teclas.put("I", KeyEvent.VK_I);
        teclas.put("J", KeyEvent.VK_J);
        teclas.put("K", KeyEvent.VK_K);
        teclas.put("L", KeyEvent.VK_L);
        teclas.put("M", KeyEvent.VK_M);
        teclas.put("N", KeyEvent.VK_N);
        teclas.put("O", KeyEvent.VK_O);
        teclas.put("P", KeyEvent.VK_P);
        teclas.put("Q", KeyEvent.VK_Q);
        teclas.put("R", KeyEvent.VK_R);
        teclas.put("S", KeyEvent.VK_S); 
        teclas.put("T", KeyEvent.VK_T);
        teclas.put("U", KeyEvent.VK_U);
        teclas.put("V", KeyEvent.VK_V);
        teclas.put("W", KeyEvent.VK_W);
        teclas.put("X", KeyEvent.VK_X);
        teclas.put("Y", KeyEvent.VK_Y);
        teclas.put("Z", KeyEvent.VK_Z);
        teclas.put("Arriba", KeyEvent.VK_UP);
        teclas.put("Abajo", KeyEvent.VK_DOWN);
        teclas.put("Izquierda", KeyEvent.VK_LEFT);
        teclas.put("Derecha", KeyEvent.VK_RIGHT);
        teclas.put("1", KeyEvent.VK_1);
        teclas.put("2", KeyEvent.VK_2);
        teclas.put("3", KeyEvent.VK_3);
        teclas.put("4", KeyEvent.VK_4);
        teclas.put("5", KeyEvent.VK_5);
        teclas.put("6", KeyEvent.VK_6);
        teclas.put("7", KeyEvent.VK_7);
        teclas.put("8", KeyEvent.VK_8);
        teclas.put("9", KeyEvent.VK_9);
        teclas.put("0", KeyEvent.VK_0);
        teclas.put("Numpad 0", KeyEvent.VK_NUMPAD0);
        teclas.put("Numpad 1", KeyEvent.VK_NUMPAD1);
        teclas.put("Numpad 2", KeyEvent.VK_NUMPAD2);
        teclas.put("Numpad 3", KeyEvent.VK_NUMPAD3);
        teclas.put("Numpad 4", KeyEvent.VK_NUMPAD4);
        teclas.put("Numpad 5", KeyEvent.VK_NUMPAD5);
        teclas.put("Numpad 6", KeyEvent.VK_NUMPAD6);
        teclas.put("Numpad 7", KeyEvent.VK_NUMPAD7);
        teclas.put("Numpad 8", KeyEvent.VK_NUMPAD8);
        teclas.put("Numpad 9", KeyEvent.VK_NUMPAD9);
    }

    private void crearOpcionesJugador(int numJugador, Controles controles){
        JLabel jugador = new JLabel("Controles Jugador " + numJugador);
        jugador.setBounds(20 + 170*(numJugador -1), 50, 150, 30);
        jugador.setVisible(true);
        add(jugador);
        
        crearOpcion("Arriba", 20 + 170*(numJugador -1), 80, controles);
        crearOpcion("Abajo", 20 + 170*(numJugador -1), 130, controles);
        crearOpcion("Izquierda", 20 + 170*(numJugador -1), 180, controles);
        crearOpcion("Derecha", 20 + 170*(numJugador -1), 230, controles);
    }

    private void crearOpcion(String direccion, int x, int y, Controles controles){
        JLabel tecla = new JLabel(direccion);
        tecla.setBounds(x, y, 55, 30);
        tecla.setVisible(true);
        add(tecla);
    }

    private void crearCampos(Controles c1, Controles c2){
        int campo = 0;
        String llave = "";
        campo = getCampo("Arriba", c1);
        llave = getLlave(campo);
        arribaUno = new JTextField(llave);
        arribaUno.setBounds(80, 80, 55, 30);
        arribaUno.setVisible(true);

        campo = getCampo("Abajo", c1);
        llave = getLlave(campo);
        abajoUno = new JTextField(llave);
        abajoUno.setBounds(80, 130, 55, 30);
        abajoUno.setVisible(true);

        campo = getCampo("Izquierda", c1);
        llave = getLlave(campo);
        izquierdaUno = new JTextField(llave);
        izquierdaUno.setBounds(80, 180, 55, 30);
        izquierdaUno.setVisible(true);

        campo = getCampo("Derecha", c1);
        llave = getLlave(campo);
        derechaUno = new JTextField(llave);
        derechaUno.setBounds(80, 230, 55, 30);
        derechaUno.setVisible(true);
        add(arribaUno);
        add(abajoUno);
        add(izquierdaUno);
        add(derechaUno);

        campo = getCampo("Arriba", c2);
        llave = getLlave(campo);
        arribaDos = new JTextField(llave);
        arribaDos.setBounds(250, 80, 55, 30);
        arribaDos.setVisible(true);

        campo = getCampo("Abajo", c2);
        llave = getLlave(campo);
        abajoDos = new JTextField(llave);
        abajoDos.setBounds(250, 130, 55, 30);
        abajoDos.setVisible(true);

        campo = getCampo("Izquierda", c2);
        llave = getLlave(campo);
        izquierdaDos = new JTextField(llave);
        izquierdaDos.setBounds(250, 180, 55, 30);
        izquierdaDos.setVisible(true);

        campo = getCampo("Derecha", c2);
        llave = getLlave(campo);
        derechaDos = new JTextField(llave);
        derechaDos.setBounds(250, 230, 55, 30);
        derechaDos.setVisible(true);
        add(arribaDos);
        add(abajoDos);
        add(izquierdaDos);
        add(derechaDos);
    }

    private int getCampo(String direccion, Controles controles){
        int campo = 0;
        switch(direccion){
            case "Arriba":
                campo = controles.getTeclaArriba();
                break;
            case "Abajo":
                campo = controles.getTeclaAbajo();
                break;
            case "Izquierda":
                campo = controles.getTeclaIzq();
                break;
            case "Derecha":
                campo = controles.getTeclaDer();
        }
        return campo;
    }

    private String getLlave(int campo){
        String llave = "";
        for(Entry<String, Integer> elemento: teclas.entrySet()){
            if(elemento.getValue() == campo){
                llave = elemento.getKey();
            }
        }
        return llave;
    }

    private void crearBotones(Controles c1, Controles c2, Menu menu){
        guardar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");

        guardar.setBounds(380, 450, 100, 25);
        guardar.setVisible(true);
        add(guardar);
        
        cancelar.setBounds(20, 450, 100, 25);
        cancelar.setVisible(true);
        add(cancelar);

        darFuncionesBotones(c1, c2, menu);
    }

    private void darFuncionesBotones(Controles c1, Controles c2, Menu menu){
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.updateControles(teclas.get(arribaUno.getText()), teclas.get(abajoUno.getText()), teclas.get(izquierdaUno.getText()), teclas.get(derechaUno.getText()));
                c2.updateControles(teclas.get(arribaDos.getText()), teclas.get(abajoDos.getText()), teclas.get(izquierdaDos.getText()), teclas.get(derechaDos.getText()));
                setVisible(false);
                menu.setVisible(true);
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menu.setVisible(true);
            }
        });
    }
}
