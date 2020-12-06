/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Miguel
 */
public class PuntuacionTest {
    
    public PuntuacionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class Puntuacion.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Puntuacion otra = null;
        Puntuacion instance = null;
        int expResult = 0;
        int result = instance.compareTo(otra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntos method, of class Puntuacion.
     */
    @Test
    public void testGetPuntos() {
        System.out.println("getPuntos");
        Puntuacion instance = null;
        int expResult = 0;
        int result = instance.getPuntos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Puntuacion.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Puntuacion instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Puntuacion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Puntuacion instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
