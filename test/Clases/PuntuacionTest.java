package Clases;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PuntuacionTest {
    
    public PuntuacionTest() {
    }

    
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Puntuacion otra = new Puntuacion("Pablo", 85);
        Puntuacion instance = new Puntuacion("Juan", 560);
        int expResult = 1;
        int result = instance.compareTo(otra);
        assertEquals(expResult, result);
        if(result != expResult){
           fail("Existe un error");
        }
    }

    
    @Test
    public void testGetPuntos() {
        System.out.println("getPuntos");
        Puntuacion instance = new Puntuacion("Pedro", 652);
        int expResult = 652;
        int result = instance.getPuntos();
        assertEquals(expResult, result);
        if(result != expResult){
           fail("Existe un error");
        }
    }

    
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Puntuacion instance = new Puntuacion("Juan", 160);
        String expResult = "Juan";
        String result = instance.getNombre();
        assertSame(expResult, result);
        if(expResult.equals(result) == false){
            fail("Existe un error");
        }
    }

    
    @Test
    public void testToString() {
        System.out.println("toString");
        Puntuacion instance = new Puntuacion("Julia", 950);
        String expResult = "" +950;
        String result = instance.toString();
        Assert.assertEquals(expResult, result);
        if(expResult.equals(result) == false){
            fail("Existe un error");
        }
    }
}