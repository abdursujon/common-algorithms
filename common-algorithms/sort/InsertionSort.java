package sort;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>>{

    /**
     * Insertion sort builds a sorted region at the front of the array one element
     * at a time. Each iteration takes the first element of the unsorted region and
     * shifts every larger element in the sorted region one position to the right,
     * then places the element in the gap that opens up. The array is sorted in place.
     *
     * Time Complexity is O(N^2) in average and worst case, O(N) in best case.
     * Space Complexity is O(1).
     */
    public T[] insertionSort(T[] nums){
        for(int i = 1; i < nums.length; i++){
            // current element
            T n = nums[i];
            // last index of sorted array
            int j = i - 1;

            // when j points to index 0 or greater, and object in j index is greater than object in i index
            while( j >= 0 && nums[j].compareTo(n) > 0){
                // shift nums[j] one slot right
                nums[j + 1] = nums[j];
                // move left to check next elements
                j--;
            }
            // when loop condition is false we find the right position for unsorted element then enter it in that position
            nums[j + 1] = n;
        }
        return nums;
    }

    public static void main(String[] args){
        InsertionSort<Integer> insert = new InsertionSort<>();
        System.out.println(Arrays.toString(insert.insertionSort(new Integer[] {90, 1, 3, 41, 12, 3, 4})));
    }
}