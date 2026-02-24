package Sorting;

import java.util.Arrays;

public class RedixSort {

    public static void RedixSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }

        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, exp);
        }
    }

    private static void countSort(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(nums[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        
        for (int i = n - 1; i >= 0; i--) {
            int digit = (nums[i] / exp) % 10;
            output[count[digit] - 1] = nums[i];
            count[digit]--;
        }

        
        for (int i = 0; i < n; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RedixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}