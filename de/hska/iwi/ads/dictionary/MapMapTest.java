package de.hska.iwi.ads.dictionary;

import java.util.Map;

import de.hska.iwi.ads.solutions.Hashtabelle.DoubleLinkedList;

public class MapMapTest extends MapTest{

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new DoubleLinkedList<>();
    }
    
}
