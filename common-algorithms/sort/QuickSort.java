package sort;

import java.util.Arrays;

public class QuickSort{

    public static int[] sortRange(int[] nums, int left, int right){
        if(left>= right) return nums;
        int midValue = nums[(left + right) /2];
        int i = partition(nums, left, midValue, right);
        sortRange(nums, left, i - 1);
        sortRange(nums, i, right);
        return nums;
    }

    private static int partition(int[] nums, int left, int midValue, int right){
        while(left <= right){
            while(nums[left] < midValue) left++;
            while(nums[right]> midValue) right--;
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static int[] quickSort(int[] nums){
        return sortRange(nums, 0, nums.length - 1);
    }

    public static void main(String[] args){
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(Arrays.toString(quickSort(nums)));

        int[] nums2 = {5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 90, 55, 11, 22, 33};
        System.out.println(Arrays.toString(quickSort(nums2)));
    }
}