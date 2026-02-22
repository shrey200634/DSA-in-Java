package Sorting;

import java.util.Arrays;

public class RedixSort {

    public static void radixSort(int[] nums){
        int max =Arrays.stream(nums).max().getAsInt();

        //do count sort for every digit place 
         for ( int exp =1; max/exp >0;exp *=10 ) {
            countSort(nums, exp);   
        }
    }
    private static void countSort(int []nums , int exp){
        int n=nums.length;
        int [] output = new int [n];
        int []count = new int[10];

        Arrays.fill(count, 0);
        for(int i=0; i<n ; i++){
            count[(nums[i]/exp) %10]++;

        }
        System.out.println("count array for "+ exp +" :" + Arrays.toString(count) );

        for(int i =1; i<10;i++){
            count[i] =count[i] + count[i-1];
        }

        System.out.println("updated count array " + Arrays.toString(count) );

        for (int i=n-1;i>=0 ; i++  ){
            output[count[(nums[i]/exp)%10]]--;
            count[(nums[i]/exp)%10]--;
          
        }
      //  System.out.println(output,0,nums,0,n);



    }



    public static void main(String[] args) {
        
    }

    
}
