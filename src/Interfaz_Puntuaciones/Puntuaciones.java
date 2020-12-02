
package Interfaz_Puntuaciones;

import Clases.Puntuacion;
import Herramientas.BotonesPersonalizados;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Puntuaciones extends JPanel{
   
    private ArrayList<Puntuacion> puntuaciones;
    private ArrayList<Puntuacion> listaO;
    private Rectangle tamaño;
    private JLabel titulo, gif;
    private BotonesPersonalizados btn_regresar;
    private ArrayList<TextField> txtNombres;
    private ArrayList<TextField> txtPuntuaciones;
    public Puntuaciones() {
        
        puntuaciones = new ArrayList<>();
        tamaño = new Rectangle(0, 0, 500, 800);
        setLayout(null);
        setOpaque(true);
        setVisible(false);
        setBounds(tamaño);
        setBackground(Color.BLACK);
        agregarTitulo();
        agregarGif();
        agregarStickers();
        agregarBotonRegresar();
        Puntuacion p = new Puntuacion("Moni", 535);
        Puntuacion p2 =  new Puntuacion("Jesi", 132);
        Puntuacion p3 = new Puntuacion("Tom", 170);
        agregarPuntuacion(p);
        
        agregarPuntuacion(p2);
        agregarPuntuacion(p3);
        //listaO = ordenar(puntuaciones);
        mostrarPuntuaciones();
        //getPuntuaciones();
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
    
    private void agregarTitulo() {
        int x,y;
        ImageIcon ico= new ImageIcon("TituloPacman.png");
        x = 5;
        y = 5 ;
        titulo = new JLabel(ico);
        titulo.setBounds(x, y,ico.getIconWidth(),ico.getIconHeight());
        
        add(titulo);
    }
    private void agregarGif(){
        int x = 100;
        int y = 684;
        ImageIcon ico = new ImageIcon("pacmanComiendo.gif");      
        gif = new JLabel(ico);
        gif.setBounds(x ,y, 200, 150);
        //gif.setIcon(new ImageIcon(ico.getImage().getScaledInstance(300, 50, Image.SCALE_SMOOTH)));
        add(gif);
    }
    private void agregarStickers(){
        //agregarPac();
        //agregarPac2();
        agregarStickersT();
        agregarStickersD();
        agregarStickersE();
        agregarStickersC();
        agregarStickersE2();
        agregarStickersP();
    }
    private void agregarPac(){
        int x = 25;
        int y = 160;
        ImageIcon ico = new ImageIcon("PacmanNeon.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 100, 180);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(100,180, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarStickersT(){
        int x = 35;
        int y = 340;
        ImageIcon ico = new ImageIcon("Trebol.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarStickersD(){
        int x = 35;
        int y = 440;
        ImageIcon ico = new ImageIcon("Diamante.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarStickersE(){
        int x = 35;
        int y = 540;
        ImageIcon ico = new ImageIcon("Estrella.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarPac2(){
        int x = 380;
        int y = 460;
        ImageIcon ico = new ImageIcon("PacmanNeon2.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 100, 180);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(100,180, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarStickersC(){
        int x = 390;
        int y = 160;
        ImageIcon ico = new ImageIcon("Corazon.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    
    private void agregarStickersE2(){
        int x = 390;
        int y = 260;
        ImageIcon ico = new ImageIcon("Estrella.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarStickersP(){
        int x = 390;
        int y = 360;
        ImageIcon ico = new ImageIcon("Espada.png");
        JLabel s = new JLabel(ico);
        s.setBounds(x, y, 70, 100);
        s.setIcon(new ImageIcon(ico.getImage().getScaledInstance(70,100, Image.SCALE_SMOOTH)));
        add(s);
    }
    private void agregarBotonRegresar() {
        int x = 15;
        int y = 700;
        ImageIcon imgico = new ImageIcon("Regresar.png");
        ImageIcon imgico2 = new ImageIcon("Regresar.png");
        btn_regresar = new BotonesPersonalizados(x, y, imgico, imgico2);
        btn_regresar.setBounds(x, y, 100, 100);
        add(btn_regresar);
        
    }
    public ArrayList<Puntuacion> getPuntuaciones() {
        for(int i=0;i < puntuaciones.size();i++){
           txtNombres.get(i).setText(puntuaciones.get(i).getNombre());
           txtPuntuaciones.get(i).setText("" + puntuaciones.get(i).getPuntos());
          }
        return puntuaciones;
    }
    public BotonesPersonalizados getBtn_regresar(){
        return btn_regresar;
    }
    
    boolean isSorted;
    Puntuacion cache;
    public ArrayList<Puntuacion> ordenar(ArrayList<Puntuacion> lista){
        if(lista.size()<= 1){ 
            return lista;
        }
        isSorted = false;
        cache = null;
        while(!isSorted){
            isSorted = true;
            
            sortForward(lista);
            
            if(isSorted){
                return lista;
            }
            
            sortBackward(lista);
        }
        return lista;
    }
    
    private ArrayList<Puntuacion> sortForward(ArrayList<Puntuacion> lista){
        int a = 0;
        
        for(int b = 1; b < lista.size(); b++){
            Puntuacion p = lista.get(b);
            Puntuacion p1 = lista.get(a);
            if(p.getPuntos() > p1.getPuntos()){
                cache = p1;
                p1 = p;
                p = cache;
                isSorted = false;
            }
            a++;
        }
        return lista;
    }
    
    private ArrayList<Puntuacion> sortBackward(ArrayList<Puntuacion> lista){
        int b = lista.size() - 1;
        for(int a = lista.size()- 2; a > 0; a--){
            Puntuacion p = lista.get(b);
            Puntuacion p1 = lista.get(a);
            if(p1.getPuntos() < p.getPuntos()){
                cache = p;
                p = p1;
                p1 = cache;
                isSorted = false;
            }
            b--;
        }
        return lista;
    } 


   /* public void mostrarPuntuaciones(ArrayList<Puntuacion> listaPuntuaciones){
        int a = 150;
        int b = 160;
        Puntuacion[] puntuacionesA = new Puntuacion[10];
        for(int j = 0; j < listaPuntuaciones.size(); j++){
           puntuacionesA[j] = listaPuntuaciones.get(j);
        }
        for(int i = 0; i < puntuacionesA.length; i++){
            Puntuacion p = puntuacionesA[i];
            JLabel puntaje = new JLabel();
            if(p  != null){
            puntaje.setText (i+1 + ".-" + "  " + p.getNombre() + "...." + p.getPuntos()); 
            puntaje.setBackground(Color.BLACK);
            puntaje.setForeground(Color.WHITE);
            puntaje.setBounds( a, b, 350, 80);
            puntaje.setFont(new Font("arial",Font.BOLD,30));
            b = b + 50;
            }else{
                puntaje.setText(i+1 + ".-" + "  " + "...........");
                puntaje.setBackground(Color.BLACK);
                puntaje.setForeground(Color.WHITE);
                puntaje.setBounds( a, b, 350, 80);
                puntaje.setFont(new Font("arial",Font.BOLD,30));
                b = b + 50;
            }
            add(puntaje);
        }
     }*/
    
    public void mostrarPuntuaciones(){
        int a = 150;
        int b = 160;
        Puntuacion[] puntuacionesA = new Puntuacion[10];
        for(int j = 0; j < puntuaciones.size(); j++){
           puntuacionesA[j] = puntuaciones.get(j);
        }
        for(int i = 0; i < puntuacionesA.length; i++){
            Puntuacion p = puntuacionesA[i];
            JLabel puntaje = new JLabel();
            if(p  != null){
            puntaje.setText (i+1 + ".-" + "  " + p.getNombre() + "...." + p.getPuntos()); 
            puntaje.setBackground(Color.BLACK);
            puntaje.setForeground(Color.WHITE);
            puntaje.setBounds( a, b, 350, 80);
            puntaje.setFont(new Font("arial",Font.BOLD,30));
            b = b + 50;
            }else{
                puntaje.setText(i+1 + ".-" + "  " + "...........");
                puntaje.setBackground(Color.BLACK);
                puntaje.setForeground(Color.WHITE);
                puntaje.setBounds( a, b, 350, 80);
                puntaje.setFont(new Font("arial",Font.BOLD,30));
                b = b + 50;
            }
            add(puntaje);
        }
     }
    
}