package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort <T extends Comparable< ? super T>> implements Sorter<T>{

    @Override
    public void sort(List<T> list) {

       List<T> sorted = mergeSort(list);
        list.clear();
        list.addAll(sorted);

    }
    //Top down from wiki implementation
    private List<T> mergeSort(List<T> list){
        if(list.size() <= 1){
            return list;
        }
        List<T> left = new ArrayList<T>();
        List<T> right = new ArrayList<T>();
        for(int i = 0;i<list.size();i++){
            if(i<(list.size()/2)){
                left.add(list.get(i));
            }
            else{
                right.add(list.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }

    private List<T> merge(List<T> left,List <T> right){
        List<T> result = new ArrayList<>();
        //index to skip .removeFirst()
        int i = 0,j= 0;
        while(!left.isEmpty() && !right.isEmpty()){
            //if left is greater put first.
            if(left.get(i).compareTo(right.get(j))>= 0)
                result.add(left.get(i++));            
            else
                result.add(right.get(j++));
            
        }
        while(i < left.size()){
            result.add(left.get(i++));
        }
        while(j < right.size()){
            result.add(right.get(j));
        }
        return result;
    }



    @Override
    public String toString() {
        return getClass().getName();
    }
}
