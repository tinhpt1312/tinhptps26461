/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft2041slide4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class calTest {
    
    public calTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cong method, of class cal.
     */
    @Test
    public void testCong() {
        System.out.println("cong");
        int a = 3;
        int b = 2; 
        cal instance = new cal();
        int expResult = 5;
        int result = instance.cong(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tru method, of class cal.
     */
    @Test
    public void testTru() {
        System.out.println("tru");
        int a = 3;
        int b = 2;
        cal instance = new cal();
        int expResult = 1;
        int result = instance.tru(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nhan method, of class cal.
     */
    @Test
    public void testNhan() {
        System.out.println("nhan");
        int a = 0;
        int b = 0;
        cal instance = new cal();
        int expResult = 0;
        int result = instance.nhan(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chia method, of class cal.
     */
    @Test
    public void testChia() {
        System.out.println("chia");
        int a = 0;
        int b = 0;
        cal instance = new cal();
        int expResult = 0;
        int result = instance.chia(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
