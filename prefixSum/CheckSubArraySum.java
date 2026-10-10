package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class CheckSubArraySum {


    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer > rem = new HashMap<>();

        rem.put(0,-1);
        int runningSum =0 ;

        for ( int i =0 ; i< nums.length ; i++){
            runningSum+=nums[i];
            int reminder = runningSum%k;
            if (reminder <0){
                reminder+=k;
            }

            if ( rem.containsKey(reminder)){
                if (i-rem.get(reminder) >= 2){
                    return true ;
                }
            }
            else {
                    rem.put(reminder , i);
                }
        }
            return false ;
        }
        
    }

    
}
