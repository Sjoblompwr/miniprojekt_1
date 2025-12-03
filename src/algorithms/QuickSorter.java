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


// Chats version of quicksort check for changes this should be "in place quicksort"
// public void sort(List<T> list) {
//     quicksort(list, 0, list.size() - 1);
// }

// private void quicksort(List<T> list, int low, int high) {
//     if (low < high) {
//         int pivotIndex = partition(list, low, high);
//         quicksort(list, low, pivotIndex - 1);
//         quicksort(list, pivotIndex + 1, high);
//     }
// }

// private int partition(List<T> list, int low, int high) {
//     T pivot = list.get(high);
//     int i = low - 1;

//     for (int j = low; j < high; j++) {
//         if (list.get(j).compareTo(pivot) <= 0) {
//             i++;
//             Collections.swap(list, i, j);
//         }
//     }

//     Collections.swap(list, i + 1, high);
//     return i + 1;
// }