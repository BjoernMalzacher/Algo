package de.hska.iwi.ads.solutions.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class ReverseMergesort extends AbstractMergesort {

    @Override
    protected void mergesort(Comparable[] a, int left, int right) {

    
        if(a[left].compareTo(a[right]) == 1){
            int middle = (left+right)/2;
            mergesort(a, left, middle);
            mergesort(a, middle+1, right);
            fuse(a, left, middle, right);
        }
    }
    private void fuse(Comparable[] a, int left, int m,int right){
        int l = left; 
        int r = right-1;
        ReverseArray rv = new ReverseArray();
        rv.reverse(a, m, right);
        int n = 0;
        for (int i = left; i < right; i++) {
            
                if( r <right || l <= m && a[l].compareTo( a[r]) <= 0){
                    b[i] = a[l];
                    l+=1;
                }else{
                    b[i] = a[r];
                    r-=1;
                }
            
        for (int j = left; j < right; j++) {
            a[j] = b[j];   
        }
        }
    }
}
