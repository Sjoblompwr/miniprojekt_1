package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSorter <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(List<T> list) {
        List<T> sorted = QuickSort(list);
        Collections.reverse(sorted);
        list.clear();
        list.addAll(sorted);
    }

    private List<T> QuickSort(List<T> list){
        List<T> leftList = new ArrayList<T>();
        List<T> rightList = new ArrayList<T>();
        List<T> sortedList = new ArrayList<T>();
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
            return List.of(list.get(0));
        }
        else
            return sortedList;    
        for(int i = 0;i<list.size();i++){
            // if smaller than pivot left-list
            if(i == pivotIndex)
                continue;
            if(list.get(i).compareTo(pivot) < 0)
                leftList.add(list.get(i));
            else
                rightList.add(list.get(i));
        }

        sortedList.addAll(QuickSort(leftList));
        sortedList.add(pivot);
        sortedList.addAll(QuickSort(rightList));

        return sortedList;
    }

    @Override
    public String toString(){
        return "QuickSorter";
    }
    
}
