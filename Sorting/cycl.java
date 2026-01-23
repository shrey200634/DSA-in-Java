package Sorting;
import java.util.Arrays;
public class cycl {
     public static void main(String[] args) {
         
        int []nums = {5,4,3,2,1};
         cyclic(nums);
         System.out.println(Arrays.toString(nums));
       

        
    }
    static void cyclic ( int []nums ){
        int i=0;
        while ( i<nums.length){
            int correct = nums[i]-1;
            if( nums [i]!= nums[correct]){
                swap ( nums,i,correct);
            }
            else {
                i++;
                
            }
                 
            
        }
    }
    static void swap ( int []nums , int start, int end ){
        int temp = nums[start];
        nums[start ]= nums [end ];
        nums[end ]= temp;
        
        
    }
    

   
}
