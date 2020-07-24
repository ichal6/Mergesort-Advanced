package com.codecool.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        if(toSort == null){
            throw new IllegalArgumentException();
        }

        if(toSort.size() <= 1){
            return;
        }

        int length = toSort.size();
        int medium = (int) Math.ceil(length/2.0);

        List<Integer> leftList = new ArrayList<>(toSort.subList(0, medium));
        List<Integer> rightList = new ArrayList<>(toSort.subList(medium, length));

        sort(leftList);
        sort(rightList);

        merge(toSort, leftList, rightList);
    }

    private void merge(List<Integer> toSort, List<Integer> leftList, List<Integer> rightList){
        int indexMain = 0;
        int indexLeft = 0;
        int indexRight = 0;

        while(indexLeft < leftList.size() && indexRight < rightList.size()){
            if(leftList.get(indexLeft) < rightList.get(indexRight)){
                toSort.set(indexMain++, leftList.get(indexLeft++));
            }else{
                toSort.set(indexMain++, rightList.get(indexRight++));
            }
        }

        while(indexLeft < leftList.size()){
            toSort.set(indexMain++, leftList.get(indexLeft++));
        }

        while(indexRight < rightList.size()){
            toSort.set(indexMain++, rightList.get(indexRight++));
        }
    }
}
