package de.hska.iwi.ads.solutions.Hashtabelle;

import java.util.Iterator;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtabelle<K extends Comparable<K>,V> extends AbstractHashMap<K,V>{

    public Hashtabelle(int capacity) {
        super(capacity);
        
    }
    public V get(Object o){
        K key = (K) o;
        Entry<K,V> entry = search(key);
        if( entry!= null){
            return entry.getValue();
        }
        return null;
    }
    private Entry<K,V> search(K key){
        Iterator<Entry<K,V>> iterator = iterator();
        while(iterator.hasNext()){
            Entry<K,V> entry  =iterator.next();
            if(entry.getKey().equals(key)){
                return entry;
            }
        }
        
        return null;

    }
    public V put(K key, V value){
        
        return null;
    }
    
}
