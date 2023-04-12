package de.hska.iwi.ads.sorting;

import de.hska.iwi.ads.solutions.sorting.ReverseMergesort;

public class ReverseMergeSortTest extends SortTest {

    @Override
    public AbstractMergesort createMergesort() {

        return new ReverseMergesort();
    }
    
}
