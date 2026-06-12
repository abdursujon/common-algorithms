package sort;

import java.util.Arrays;

public class MergeSortInPlace <T extends Comparable<T>> {

    private void merge(T[] a, int start, int mid, int end) {
        T[] left = Arrays.copyOfRange(a, start, mid);
        T[] right = Arrays.copyOfRange(a, mid, end);
        int i = 0, j = 0;
        for(int k = start; k < end; k++){
            if(j >= right.length || (i < left.length && left[i].compareTo(right[j]) < 0)){
                a[k] = left[i++];
            } else{
                a[k] = right[j++];
            }
        }
    }

    public void mergeSortInPlace(T[] A, int start, int end){
        if(end - start > 1){
            int mid = (start + end) / 2;
            mergeSortInPlace(A, start, mid);
            mergeSortInPlace(A, mid, end);
            merge(A, start, mid, end);
        }
    }

    public static void main(String[] args) {
        MergeSortInPlace<Integer> merge = new MergeSortInPlace<>();
        Integer[] A = {20, 30, 21, 15, 42, 45, 31, 0, 9};
        merge.mergeSortInPlace(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }
}