import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class KjedetBSTest {   

    private KjedetBinaerSokeTre<Integer> bs;  
    // Testdata som legges inn i treet
    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;
    private Integer e5 = 6;
    private Integer e6 = 7;
    
    //Data som ikke legges inn i treet
    private Integer e7 = 8;

    /**
     * Opprett en tomt tre for hver test.
     * 
     * @throws Exception exception
     */
    @Before
    public final void setup() throws Exception {
      bs = new KjedetBinaerSokeTre<Integer>();
    }
           
    /**
     * Tester  finn
     * 
     */
    @Test
    public final void erElementIBSTre() { 
    /* Her legger du inn e0...e6 i treet i en vilk�rlig rekkef�lge.
     * Etterp� sjekker du om elementene fins og til slutt sjekker du
     * at e7 ikke fins
     */
    bs.leggTil(e0);
    bs.leggTil(e1);
    bs.leggTil(e2);
    bs.leggTil(e3);
    bs.leggTil(e4);
    bs.leggTil(e5);
    bs.leggTil(e6);
    assertEquals(e0, bs.finn(e0));
    assertEquals(e1, bs.finn(e1));
    assertEquals(e2, bs.finn(e2));
    assertEquals(e3, bs.finn(e3));
    assertEquals(e4, bs.finn(e4));
    assertEquals(e5, bs.finn(e5));
    assertEquals(e6, bs.finn(e6));
    assertFalse(e7.equals(bs.finn(e7)));
                       
   }
        
    /**
     *1.  Tester ordning  ved � legge til elementer og fjerne minste
     * 
     */
     @Test
    public final void erBSTreOrdnet() { 
     /* Her legge du f�rst inn e0...e6 i en vilk�rlig rekkef�lge
      * og s� fjerne du minste hele tiden    
      */  
    	 bs.leggTil(e0);
    	 bs.leggTil(e1);
    	 bs.leggTil(e6);
    	 bs.leggTil(e4);
    	 bs.leggTil(e3);
    	 bs.leggTil(e5);
    	 bs.leggTil(e2);
    	 assertEquals(e0, bs.fjernMin());
    	 assertEquals(e1, bs.fjernMin());
    	 assertEquals(e2, bs.fjernMin());
    	 assertEquals(e3, bs.fjernMin());
    	 assertEquals(e4, bs.fjernMin());
    	 assertEquals(e5, bs.fjernMin());
    	 assertEquals(e6, bs.fjernMin());
   }
     
    /**
     * 2 Tester ordning ved � bruke en inordeniterator
     *  Her studerer du alt om bruk av inordeniterator.
     */
     @Test
    public final void erBSTreOrdnet2() { 
     bs.leggTil(e3); 
     bs.leggTil(e2); 
     bs.leggTil(e4); 
     bs.leggTil(e1); 
     bs.leggTil(e5); 
     bs.leggTil(e0);
     bs.leggTil(e6);
     
     Integer el[] = {e0, e1, e2, e3, e4, e5, e6};
     int i = 0;
     for (Integer e : bs ) {
       assertEquals(el[i], e);
       i++;
     }
              
   }
         
     
}//class
