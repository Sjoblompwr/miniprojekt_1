package algorithms;


public class JavaBuitInSorter <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(java.util.List<T> list) {
        java.util.Collections.sort(list);
    }

    @Override
    public String toString() {
        return "JavaBuitInSorter";
    }
    
}
