package prefixSum;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map <Integer , Integer> map = new HashMap<>();
        int n = nums.length ;
        map.put(0,1 );
        int currSum =0 ;
        int count =0 ;
        for ( int num : nums ){
            currSum += num ;

            if (map.containsKey(currSum-k)){
            count += map.get(currSum-k);
        }
        map.put(currSum , map.getOrDefault(currSum ,0) +1 );
        }
        

        return count ;
        
    }
}