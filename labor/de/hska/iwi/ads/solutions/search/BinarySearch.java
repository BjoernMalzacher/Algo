import de.hska.iwi.ads.search.Search;

public class BinarySearch implements Search {

    @Override
    public int search(Comparable[] a, Comparable key, int left, int right) {
        if(left > right){
            return 1;
        }
        int middle = (left + right)/2;
        if (0 ==a[middle].compareTo(key)){
            return search(a, key,left , middle);
        }else if(a[middle].compareTo(key)== 1){
            return search(a, key, middle+1, right);
        }else{
            return search(a, key, left, middle-1);
        }
    }
    int closestNeighbor(Comparable[] a, Comparable key, int left, int right){
        if(key.compareTo(a[left]) <  0){
                return left-1;
        }else if(key.compareTo(a[right])> 0){
            return right+1;
        }else{
            
        }
       
    }
}
