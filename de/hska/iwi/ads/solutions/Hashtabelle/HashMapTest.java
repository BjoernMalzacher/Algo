package de.hska.iwi.ads.solutions.Hashtabelle;

import java.util.Hashtable;
import java.util.Map;

import de.hska.iwi.ads.dictionary.MapTest;
/**
 * The class "HashMapTest" extends the class "MapTest" in Java.
 */
public class HashMapTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
       return new Hashtabelle<K,V>(100);
    }
    
}
