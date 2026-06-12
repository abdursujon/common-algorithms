package sort;

import java.util.Arrays;

/**
 * Time Complexity is O(NLogN) for every cases.
 * Merging in every level takes O(N).
 * There are logN level.
 *
 * Space Complexity is O(N)
 */
public class MergeSort<T extends Comparable<T>> {

    @SuppressWarnings("unchecked")
    private T[] merge(T[] a, T[] b) {
        T[] mergeResult = (T[]) java.lang.reflect.Array.newInstance(b.getClass().getComponentType(), a.length + b.length);
        // i tracks index of array a, j tracks index of b, k tracks next empty slot
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            // if element in a[i] index less then b[i] it is the smaller element therefor we add to the result array
            if (a[i].compareTo(b[j]) < 0) {
                mergeResult[k++] = a[i++];
            } else {
                // b[j] is smaller element in a[i]  therefor we add it to the result
                mergeResult[k++] = b[j++];
            }
        }

        // since there is a possibility either a or b has left over elements we need to copy them
        // here only one while loop will run depends on which one has remaining elements
        while (i < a.length) {
            mergeResult[k++] = a[i++];
        }

        while (j < b.length) {
            mergeResult[k++] = b[j++];
        }

        return mergeResult;
    }

    public T[] mergeSort(T[] nums){
        if(nums == null || nums.length <= 1) return nums;
        int m = nums.length / 2;
        T[] left = mergeSort(Arrays.copyOfRange(nums, 0, m));
        T[] right = mergeSort(Arrays.copyOfRange(nums, m, nums.length));
        return merge(left, right);
    }

    public static void main(String[] args) {
        MergeSort<Integer> sort = new MergeSort<>();
        Integer[] test = {21, 4, 1, 3, 9, 20, 25, 6, 21, 14};
        System.out.println(Arrays.toString(sort.mergeSort(test)));
    }
}