/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Interfaz_PanelInicio.Panel_Inicio;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Miguel
 */
public class Audio {
    private Clip clip;

    public Audio(String ubicacion) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(ubicacion)) );
            clip.loop(100);
        } catch (Exception ex) {
            Logger.getLogger(Panel_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pausar(){
        clip.start();
    }
    
    public void stop(){
        clip.stop();
    }
    
}
