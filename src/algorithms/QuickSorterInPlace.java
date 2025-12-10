package algorithms;

import java.util.List;

public class QuickSorterInPlace <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(List<T> list) {
        if(list.size() > 1)
            QuickSort(list, 0, list.size() -1);
    }

    private void QuickSort(List<T> list, int low, int high){
        if(low >= high || low < 0)
            return;

        int p = partition(list, low, high);
        QuickSort(list, low, p -1);
        QuickSort(list, p + 1, high);


    }
    private int partition(List<T> list,int low, int high){
        T first,middle,last,pivot;
        int pivotIndex;
        if(list.size() > 2){
            int mid = low + (high - low) / 2;
            first = list.get(low);
            middle = list.get(mid);
            last = list.get(high);

            if(first.compareTo(middle) >= 0 && first.compareTo(last) <= 0 || first.compareTo(middle) <= 0 && first.compareTo(last) >= 0  ){     
                pivot = first;
                pivotIndex = low;
            }
            else if(middle.compareTo(first) >= 0 && middle.compareTo(last) <= 0 || middle.compareTo(first) <= 0 && middle.compareTo(last) >= 0 ){
                pivot = middle;
                pivotIndex = mid;
            }
            else{
                pivot = last;
                pivotIndex = high;
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
        else
            return low;
        int i = low;
        for(int j = low;j < high;j++){
            if(list.get(j).compareTo(pivot) >= 0){
                swap(list,list.get(i),list.get(j));
                i++;
            }
        }
        return i;
    }

    private void swap(List<T> list, T a, T b){
        int indexA = list.indexOf(a);
        int indexB = list.indexOf(b);
        T temp = a;
        list.set(indexA, b);
        list.set(indexB, temp);
    }

    @Override
    public String toString(){
        return "QuickSorter";
    }
    
}

