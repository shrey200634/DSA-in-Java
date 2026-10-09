package DynamicProgramming;
    import java.util.Arrays;


public class LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] tails = new int[nums.length];
        int len = 0;
        
        for (int x : nums) {
            
            int i = Arrays.binarySearch(tails, 0, len, x);
            
           
            if (i < 0) {
                i = -(i + 1);
            }
            
           
            tails[i] = x;
            if (i == len) {
                len++; 
            }
        }
        
        return len;
    }
}
    

