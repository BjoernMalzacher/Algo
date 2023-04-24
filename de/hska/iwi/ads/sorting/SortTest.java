package de.hska.iwi.ads.sorting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.charset.Charset;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public abstract class SortTest {
 
 
    public abstract AbstractMergesort createMergesort();
    private AbstractMergesort sort;
    private Comparable[] commonComparableList1;
    private Comparable[] commonComparableList2;
    private Comparable[] commonComparableList3; 
    @BeforeEach
    public void setUp(){
        sort = createMergesort();
        commonComparableList1= new Comparable[]{new Integer(2),new Integer(7),new Integer(1),new Integer(6),new Integer(4),new Integer(10)};
        commonComparableList2 = new Comparable[1000];
        commonComparableList3 = new Comparable[1000];
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            commonComparableList2[i] = new Integer(rand.nextInt(100));
           

        }
        for (int i = 0; i < 1000; i++) {
            byte[] array = new byte[10]; 
            new Random().nextBytes(array);
            
            commonComparableList3[i] = new String(array, Charset.forName("US-ASCII"));
            
        }
    }
    @Test
    public void SortIntArray(){ 
         sort.sort(commonComparableList1);
    assertEquals(new Integer(1),  (Integer)commonComparableList1[0]);
        
    }
    @Test
    public void SortRandomInt(){
        sort.sort(commonComparableList2);
        for (int i = 0; i < commonComparableList2.length-1; i++) {
             
          assertTrue(commonComparableList2[i].compareTo(commonComparableList2[i+1])<=0 );
        }
    } 
    @Test
    public void SortRandomString(){
        sort.sort(commonComparableList3);
        for (int i = 0; i < commonComparableList3.length-1; i++) {
            System.out.println(commonComparableList3[i]);
            assertTrue(commonComparableList3[i].compareTo(commonComparableList3[i+1])<=0 );
        }
    } 
}
