package de.hska.iwi.ads.solutions.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search {

    @Override
    public int search(Comparable[] a, Comparable key, int left, int right ) {
         a[right] = a[right];
        if(left >= right){
            return closestNeighbor(a, key, left, right);
        }
        int middle = (left + right)/2;
        if (0 ==a[middle].compareTo(key)){
            
            return search(a, key, left, middle);
        }else if(a[middle].compareTo(key)<0){
            return search(a, key, middle+1, right);
        }else{
            return search(a, key, left, middle-1);
        }
    }
    private int closestNeighbor(Comparable[] a, Comparable key, int left, int right){
        if(key.compareTo(a[left]) <0){

                return left-1;
        }else if(key.compareTo(a[right])> 0){
            System.out.println("hallo"); 
            return right+1;
        }else{
            
            for (int i = left; i < right; i++) {
                
                if(key.compareTo(a[i])<0)
                    return i;
            }
            return (left+right)/2;
        }
       
    }
}
