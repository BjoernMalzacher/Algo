package de.hska.iwi.ads.solutions.Hashtable;

import java.util.Iterator;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class HashTable<K extends Comparable<K>,V> extends AbstractHashMap<K,V>{

    public HashTable(int capacity) {
        super(capacity);
        
    }
    public V get(Object o){
        if(o == null) {throw new NullPointerException();}
            
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
        Entry<K,V> entry = search(key);
        if(entry!= null){
               return entry.setValue(value);
        }
        entry = new SimpleEntry<K,V>(key, value);
         int entryhash = entry.getKey().hashCode();
         int collision = entryhash % hashtable.length;
        for (int i = 0; i < hashtable.length; i++) {
            collision =  (int) (entryhash + ((int)Math.pow(-1, i+1)*Math.ceil((Math.pow(i/2, 2))))) % hashtable.length;
            if(hashtable[collision] == null){
                hashtable[collision] = entry;
                size+=1;
                return null;
            }
            
            
        }
        throw new DictionaryFullException();
    }
    
}
