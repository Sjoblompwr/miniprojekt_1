package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSorterInPlace <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(List<T> list) {
        if(list.size() > 1)
            QuickSort(list, 0, list.size() -1);
    }

    private void QuickSort(List<T> list, int low, int high){
        T first;
        T last;
        T middle;
        T pivot;
        int pivotIndex;
        if(list.size() > 2){
            first = list.get(0);
            middle = list.get(list.size() / 2);
            last = list.get(list.size() - 1);

            if(first.compareTo(middle) >= 0 && first.compareTo(last) <= 0 || first.compareTo(middle) <= 0 && first.compareTo(last) >= 0  ){     
                pivot = first;
                pivotIndex = 0;
            }
            else if(middle.compareTo(first) >= 0 && middle.compareTo(last) <= 0 || middle.compareTo(first) <= 0 && middle.compareTo(last) >= 0 ){
                pivot = middle;
                pivotIndex = list.size() / 2;
            }
            else{
                pivot = last;
                pivotIndex = list.size() -1;
            }



        }
        else if(list.size() == 2){
            if(list.get(0).compareTo(list.get(1)) <= 0){
                pivot = list.get(1);
                pivotIndex = 1;
            }
            else{
                pivot = list.get(0);
                pivotIndex = 0;
            }
        }
        else if (list.size() == 1){
            return;
        }
        else
            return;    

        
    
    }

    @Override
    public String toString(){
        return "QuickSorter";
    }
    
}

