package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort{

    public static int[] radixSort(int[] nums){
        int maxNumberOfDigits = String.valueOf(Arrays.stream(nums).max().getAsInt()).length();

        for(int d = 0; d < maxNumberOfDigits; d++){
            List<List<Integer>> buckets = new ArrayList<>();
            for(int k = 0; k < 10; k++){
                buckets.add(new ArrayList<>());
            }

            for(int n: nums){
                int digit = (n / (int) Math.pow(10, d)) % 10;
                buckets.get(digit).add(n);
            }

            int i = 0;
            for(List<Integer> bucket: buckets){
                for(int n: bucket){
                    nums[i] = n;
                    i++;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(Arrays.toString(radixSort(nums)));

        int[] nums2 = {5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 5,2,4,1,3,6,0, 90, 55, 11, 22, 33};
        System.out.println(Arrays.toString(radixSort(nums2)));
    }
}