package sort;

import java.util.Arrays;

public class HeapSort{
    // n is size of nums
    private static void heapify(int[] nums, int n, int i){
        int largest = i;
        int left = largest * 2 + 1;
        int right = largest * 2 + 2;

        if(left < n && nums[left] > nums[largest]) largest = left;
        if(right < n && nums[right] > nums[largest]) largest = right;
        if(largest != i){
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(nums, n, largest);
        }
    }

    public static int[] heapSort(int[] nums){
        int n = nums.length;

        // build max heap, O(n Log n)
        for(int i = (n / 2) - 1; i >= 0; i--){
            heapify(nums, n, i);
        }

        // keep swaping the largest
        for(int i = n - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(Arrays.toString(heapSort(nums)));

        int[] nums2 = {5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 90, 55, 11, 22, 33};
        System.out.println(Arrays.toString(heapSort(nums2)));
    }
}