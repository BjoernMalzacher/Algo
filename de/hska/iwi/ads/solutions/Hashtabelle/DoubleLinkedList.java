package de.hska.iwi.ads.solutions.Hashtabelle;

import java.util.AbstractMap;

import javax.xml.namespace.QName;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K,V> {
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object o){
        K key = (K) o;
       Entry<K,V> entry= search(key);
        if(entry == null){
            return null;
        }else{
            return entry.getValue();
        }
    }
    private Entry<K,V> search(K key){
        
        while(iterator().hasNext()){
            Entry<K,V> val = iterator().next();
            if(val.getKey().equals(key)){
                 return val;
 
             }     
        }
        return null;
    } 

    @Override
    public V put(K key, V value) {
        Entry<K,V> entry = new SimpleEntry<K, V>(key, value);
        if(head == null){
            ListElement l = new ListElement(entry, null, null);
            head = l;
            return null;
        }else{
            Entry<K,V> s = search(key);
            if(s != null){
                return s.setValue(value);
            }else{
                ListElement l = new ListElement(entry, null, head);
                head.previous = l;
                head = l;
                return null;
            }
        }
    }
}
