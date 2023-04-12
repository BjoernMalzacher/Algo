package de.hska.iwi.ads.sorting;

import de.hska.iwi.ads.solutions.sorting.MergeSort;

public class MergeSortTest extends SortTest{

    @Override
    public AbstractMergesort createMergesort() {
        return new MergeSort();
    }
    
}
