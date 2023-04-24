package de.hska.iwi.ads.solutions.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {
    @Override
    public void reverse(E[] a, int from, int to) {
        E save;
        while( from < to){
            save = a[from];
            a[from] = a[to];
            a[to] = save;
            from +=1;
            to-=1;
        }
  

    }
    
}
