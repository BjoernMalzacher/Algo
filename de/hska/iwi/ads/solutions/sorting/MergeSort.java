package de.hska.iwi.ads.solutions.sorting;
import de.hska.iwi.ads.sorting.AbstractMergesort;


public class MergeSort<E extends Comparable<E>> extends AbstractMergesort<E>{

    @Override
        protected void mergesort(E[] a, int left, int right) {

            if(left <right){
                int middle = (left+right)/2;
                mergesort(a, left, middle);
                mergesort(a, middle+1, right);
                fuse(a, left, middle, right);
            }
        }
        private void fuse(E[] a, int left, int m, int right) {
            int l = left;
            int r = m + 1;
            for (int i = left; i <= right; i++) {
                if (r > right || (l <= m && a[l].compareTo(a[r]) <= 0)) {
                    b[i] = a[l];
                    l+=1;
                } else {
                    b[i] = a[r];
                    r+=1;
                }
            }
            for (int i = left; i <= right; i++) {
                a[i] = b[i];
            }
        }
            
    }
