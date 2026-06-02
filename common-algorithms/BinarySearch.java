import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(int[] nums, int target, boolean isSearchingLeft){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while(left <= right){
            // if our array is {1, 2, 3, 4, 4, 5, 6, 7} mid = 8 / 2 = 4
            int mid = (left + right) / 2;

            // if target is 2, mid(4) > target(2)
            if(target < nums[mid]){
                // target is on the left side of the mid, so point right to mid - 1 (in this example index 3)
                right = mid - 1;
            } else if(target > nums[mid]){ // target is > nums[mid] for example target(7) > mid(4)
                left = mid + 1; // since we don't need to look to the left side of the mid, we do mid + 1
            } else{
                // if both target < nums[mid] and target > nums[mid] fails that means target is the mid element so index = mid
                index = mid;

                // when we're searching left right should be point to mid - 1 since right side of mid discared
                if(isSearchingLeft){
                    right = mid -1;
                } else{
                    // if not searching left, we are searching right so left should start from mid + 1
                    left = mid + 1;
                }
            }
        }
        return index;
    }

    /**
     * Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target){
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    /**
     * Given an array of integer, return true if target is found else return false
     */
    public boolean searchTarget(int[] nums, int target){
        int left = binarySearch(nums, target, true);
        return left > -1;
    }

    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();

        System.out.println(Arrays.toString(bs.searchRange(new int[]{1, 3, 7, 7, 7, 7, 8, 9}, 7)));
        System.out.println(Arrays.toString(bs.searchRange(new int[]{1, 3, 7, 8, 9}, 9)));
        System.out.println(Arrays.toString(bs.searchRange(new int[]{1, 1, 1, 3, 7, 8, 9}, 1)));

        System.out.println(bs.searchTarget(new int[]{1, 3, 7, 7, 7, 7, 8, 9}, 0));
        System.out.println(bs.searchTarget(new int[]{1, 3, 7, 7, 7, 7, 8, 9}, 3));
    }
}
