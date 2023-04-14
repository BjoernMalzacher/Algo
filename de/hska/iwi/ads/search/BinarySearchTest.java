package de.hska.iwi.ads.search;

import de.hska.iwi.ads.solutions.search.BinarySearch;

public class BinarySearchTest extends SearchTest{



  @Override
  public <E extends Comparable<E>> Search<E> createSearch() {
    return new BinarySearch<>();
  }


}
