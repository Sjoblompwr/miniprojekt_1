package algorithms;

import java.util.List;

public class InsertionSorter <T extends Comparable < ? super T>> implements Sorter <T> {

    @Override
    public void sort(List<T> list) {
        //Assume first element sorted, take next compare with earlier, swap if smaller continue until stop
        if(!(list.size() == 0 || list.size() == 1))
            for(int i = 1;i<list.size();i++){
                int j = i;
                while(j > 0 && list.get(j - 1).compareTo(list.get(j)) < 0){
                    T temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1 , temp);
                    j--;
                }
            }
    }
    
}
