package de.hska.iwi.ads.solutions.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] a, E key, int left, int right ) {
        if(key.compareTo(a[left]) <0){

            return left-1;
    }else if(key.compareTo(a[right])> 0){
       
        return right+1;
    }
        a[right] = a[right];
        return searchHelper(a, key, left, right);
}
 private  int searchHelper(E[] a, E key, int left, int right){
        if(left > right){
            // return closestNeighbor(a, key, left, right);
             return left;
         }else{
        
         int middle = (left + right)/2;
         if (0 ==a[middle].compareTo(key)){
            if(middle-1>= 0 && a[middle-1].compareTo(key)== 0){
                return searchHelper(a, key, left, middle);
            }  else{
                return middle;
            }
            
         }else if(a[middle].compareTo(key)<0){
             return searchHelper(a, key, middle+1, right);
         }else{
             return searchHelper(a, key, left, middle-1);
         }
        }
     }
    }
    /*private int closestNeighbor(E[] a, E key, int left, int right){
        if(key.compareTo(a[left]) <0){

                return left-1;
        }else if(key.compareTo(a[right])> 0){
           
            return right+1;
        }else{
            
            for (int i = left; i < right; i++) {
                
                if(key.compareTo(a[i])<0)
                    return i;
            }
            return (left+right)/2;
        }
       
    }*/

