package de.hska.iwi.ads.solutions.Hashtable;

import java.util.AbstractMap;
import java.util.Iterator;

import javax.xml.namespace.QName;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K,V> {
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object o){
        if(o == null){
            throw new NullPointerException();
        }
        K key = (K) o;
       Entry<K,V> entry= search(key);
        if(entry == null){
            return null;
        }else{
            return entry.getValue();
        }
    }
    private Entry<K,V> search(K key){
        
      
        ListElement currentElement= head;
        while(currentElement != null){
            Entry<K,V> val = currentElement.entry;
            if(val.getKey().equals(key)){
                 return val;
 
             }
             currentElement = currentElement.next;     
        }
        return null;
    } 

    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            throw new NullPointerException();
        }
        Entry<K,V> entry = new SimpleEntry<K, V>(key, value);
        if(head == null){
            ListElement l = new ListElement(entry, null, null);
            head = l;
            size+=1;
            return null;
            
        }else{
            Entry<K,V> s = search(key);
            if(s != null){
                return s.setValue(value);
            }else{
                ListElement l = new ListElement(entry, null, head);
                head.previous = l;
                head = l;
                size+=1;
                return null;
                
            }
            
        }
    }
}


