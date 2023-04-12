package de.hska.iwi.ads.solutions.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray implements Reverse {
    @Override
    public void reverse(Comparable[] a, int from, int to) {
        Comparable save;
        while( from < to){
            save = a[from];
            a[from] = a[to];
            a[to] = save;
            from +=1;
            to-=1;
        }
  

    }
    
}
