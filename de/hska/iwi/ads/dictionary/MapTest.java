package de.hska.iwi.ads.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MapTest {

  /**
  Creates and returns an implementation of the Dictionary interface.
  Override this method in the super class
  with, for instance, a BinarySearchTree implementation
  <pre>
  @override
  public &lt;K extends Comparable&lt;K>, V> Dictionary&lt;K, V> createSearch() {
    return new BinarySearchTree&lt;K, V>();
  }
  </pre>
  */
 public abstract <K extends Comparable<K>, V> Map<K,V> createMap();
 
   private Map<Integer, String> commonTestMap;
   
   @BeforeEach
   void setUp() {
     // Map with 1,2,3,4, 6,7,8
     commonTestMap = createMap();
     commonTestMap.put(6, "Sechs");
     commonTestMap.put(3, "Drei");
     commonTestMap.put(1, "Eins");
     commonTestMap.put(7, "Sieben");
     commonTestMap.put(8, "Acht");
     commonTestMap.put(4, "Vier");
     commonTestMap.put(2, "Zwei");
   }
   
   @Test 
   void commonTestDictionary() {
     assertNotNull(commonTestMap);
     assertEquals(7, commonTestMap.size());
     assertEquals("Eins", commonTestMap.get(1));
     assertEquals("Zwei", commonTestMap.get(2));
     assertEquals("Drei", commonTestMap.get(3));
     assertEquals("Vier", commonTestMap.get(4));
     assertEquals("Sechs", commonTestMap.get(6));
     assertEquals("Sieben", commonTestMap.get(7));
     assertEquals("Acht", commonTestMap.get(8));
   }
   
   @Test
   void testSize0() {
     Map<Integer, String> dictionary = createMap();
   
     assertEquals(0, dictionary.size());
   }

 
  @Test
  void testSize1() {
    Map<Integer, String> dictionary = createMap();
    
    dictionary.put(5, "F�nf");
    dictionary.put(3, "Drei");
    dictionary.put(7, "Vier");
    dictionary.put(11, "Elf");
    dictionary.put(1, "Eins");
    dictionary.put(9, "Neun");
    assertEquals(6, dictionary.size());
  }

  @Test
  void testSize2() {
    Map<Integer, String> map = createMap();
    
    map.put(5, "F�nf");
    map.put(3, "Drei");
    map.put(1, "Eins");
    map.put(9, "Neun");
    map.put(3, "Drei");
    map.put(1, "Eins");
    assertEquals(4, map.size());
  }

  @Test
  void testPut() {
    commonTestMap.put(9, "Neun");
    assertEquals(8, commonTestMap.size());    
    assertEquals("Neun", commonTestMap.get(9));
  }
  
  @Test
  void testPut2() {
    commonTestMap.put(9, "Neun");
    commonTestMap.put(5, "F�nf");
    assertEquals(9, commonTestMap.size());    
    assertEquals("Neun", commonTestMap.get(9));
    assertEquals("F�nf", commonTestMap.get(5));
  }
  
  @Test
  void testPut3() {
    commonTestMap.put(9, "Neun");
    commonTestMap.put(5, "F�nf");
    commonTestMap.put(2, "Two");
    commonTestMap.put(9, "Neun");
    
    assertEquals(9, commonTestMap.size());    
    assertEquals("Neun", commonTestMap.get(9));
    assertEquals("F�nf", commonTestMap.get(5));
  }
  
  @Test
  void testGet() {
    assertNull(commonTestMap.get(5));
  }
  
  @Test
  void testGet1() {
    assertEquals("Sieben", commonTestMap.get(7));
  }
  
  @Test
  void testGet2() {
    assertEquals("Sechs", commonTestMap.get(6));
  }
  
  @Test
  void testGetNull() {
    assertThrows(NullPointerException.class, () -> commonTestMap.get(null));
  }
  
  @Test
  void testPutNull() {
    assertThrows(NullPointerException.class, () -> commonTestMap.put(null, "Null"));
  }

  @Test
  void testManyEntries(){
     Map<Integer,String> map2 = createMap();
     for (int i = 0; i < 100; i++) {
      byte[] p = new byte[10];
      new Random().nextBytes(p);
      map2.put(new Random().nextInt(900), new String(p , Charset.forName("US-ASCII")));
      
     }

     byte[] p = new byte[10];
     new Random().nextBytes(p);
     int i = new Random().nextInt(900);
     map2.put(i, new String(p , Charset.forName("US-ASCII")));
     assertEquals(new String(p,Charset.forName("US-ASCII")), map2.get(i));


  }
  

  
}
