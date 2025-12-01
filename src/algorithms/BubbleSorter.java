package algorithms;

import java.util.List;

public class BubbleSorter <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(List<T> list) {
        for(int i = 0;i < list.size();i++){
            System.err.println("Iteration:" + i + " of " + list.size());
            for(int j = 0; j < list.size() - 1 - i;j++){
                //if j is bigger than j+1 swap, we want biggest last I think?
                if(list.get(j).compareTo(list.get(j+1)) > 0){
                    //swap
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1,temp);

                }
            }
        }
    }

    @Override
    public String toString() {
        return "BubbleSorter";
    }
}