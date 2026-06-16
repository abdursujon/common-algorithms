package sort;

import java.util.Arrays;

/**
 * Quicksort sorts the array in place by repeatedly partitioning it around a
 * pivot value. Each partition pass picks a pivot, then rearranges the range so
 * every element less than the pivot ends up on the left and every element
 * greater ends up on the right. The pivot's value splits the range into two
 * independent sections, and the same process is applied recursively to each
 * section until every section has one element or fewer. No merge step is needed
 * because the partition already places each section on its correct side.
 *
 * Time Complexity is O(N log N) in average and best case, O(N^2) in worst case
 * when partitions are consistently lopsided. Space Complexity is O(log N) for
 * the recursion stack.
 */
public class QuickSort{

    /**
     * Partition rearranges the range [left, right] around the pivot value. Two
     * pointers move inward from each end: the left pointer advances past elements
     * smaller than the pivot, the right pointer retreats past elements larger than
     * the pivot. When both stop, they have each found an element on the wrong side,
     * so those elements are swapped and the pointers step inward. This repeats until
     * the pointers cross. At that point every element left of the crossing is less
     * than or equal to the pivot and every element from it onward is greater than or
     * equal to the pivot. The returned left index is that crossing point, which the
     * caller uses as the boundary between the two sections.
     * Note: pivot refers to a central point on which something turns or balances
     */
    private static int partition(int[] nums, int left, int pivot, int right){
        while(left <= right){
            while(nums[left] < pivot) left++;
            while(nums[right]> pivot) right--;
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


    public static int[] sortRange(int[] nums, int left, int right){
        // nums has only one element or empty so there is nothing to sort
        if(left>= right) return nums;
        int pivot = nums[(left + right) /2];

        // holds left index split boundary return by partition
        int i = partition(nums, left, pivot, right);
        sortRange(nums, left, i - 1);
        sortRange(nums, i, right);
        return nums;
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