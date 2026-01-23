package Sorting;
import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int []nums ={5,4,3,2,1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        int []arr={5,4,3,2,1};
        bubble(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
        
    }
    /// solve this sorting using normal method 
    static void bubbleSort( int []nums ){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if ( nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]= temp;


                }
                
            }
            
        }
       
    }

    /// solve this problem via recursion
     static void bubble(int []arr, int r , int c ){
        if ( r==0){
            return ;
        }
        if ( c<r){
            if ( arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c]= arr[c+1];
                arr[c+1]=temp;
            }
           
            bubble(arr,r, c+1);
        }
        else {
           
            bubble(arr,r-1, 0 );
        }
        
    }
    
}
