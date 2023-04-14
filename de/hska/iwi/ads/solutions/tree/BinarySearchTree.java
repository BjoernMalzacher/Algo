package de.hska.iwi.ads.solutions.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>,V> extends AbstractBinaryTree<K,V>{

    
    public V get(Object o) {
        if (root == null) {
            return null;
        } else {
            
            return getHelper(root, o);
        }
    }
    private V getHelper(Node node, Object key) {
        if (node == null) {
            return null;
        } else if (key.equals(node.entry.getKey())) {
            return node.entry.getValue();
        } else if (((Comparable<K>) key).compareTo(node.entry.getKey()) < 0) {
            return getHelper(node.left, key);
        } else {
            return getHelper(node.right, key);
        }
    }
    
    public V put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size+=1;
            return null;
        } else {
            return putHelper(root, key, value);
        }
    }

    private V putHelper(Node node, K key, V value) {
        if (key.compareTo(node.entry.getKey()) < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size+=1;
            } else {
                putHelper(node.left, key, value);
            }
        } else if (key.compareTo(node.entry.getKey()) > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size+=1;
            } else {
                putHelper(node.right, key, value);
            }
        } else {
            return node.entry.setValue(value);
        }
        return null;
    }
    
}
