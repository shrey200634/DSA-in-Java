package Sorting;

import java.util.Arrays;

public class CountSort {

    public static void CountSort(int[]nums){
        if(nums ==null || nums.length <=1){
            return;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] >max){
                max = nums[i];
            }
            
        } 

        int [] countArray =new int [max+1];
        for (int num :nums){
            countArray[num]++;
        }
        int index =0;
        for (int i = 0; i <= max; i++) {
            while(countArray[i]>0){
                nums[index]=i;
                index++;
                countArray[i]--;
            }
            
        }
    }



  public static void main(String[] args) {
    int []arr={5,34,2,7,8};
    CountSort(arr);
    System.out.println(Arrays.toString(arr));
    
  }
    
}
