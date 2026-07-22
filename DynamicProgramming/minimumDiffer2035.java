package DynamicProgramming;

    import java.util.*;


public class minimumDiffer2035 {


    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        generateSums(nums, 0, n, 0, 0, left);
        generateSums(nums, n, 2 * n, 0, 0, right);

        for (int i = 0; i <= n; i++) {
            Collections.sort(right.get(i));
        }

        int minDiff = Integer.MAX_VALUE;
        int target = totalSum / 2; 
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = left.get(k);
            List<Integer> rightList = right.get(n - k); 

            for (int x : leftList) {
                int idealY = target - x;
                
                int idx = Collections.binarySearch(rightList, idealY);
                if (idx < 0) idx = -(idx + 1); 

                if (idx < rightList.size()) {
                    int sum1 = x + rightList.get(idx);
                    int sum2 = totalSum - sum1;
                    minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
                }
                
                if (idx > 0) {
                    int sum1 = x + rightList.get(idx - 1);
                    int sum2 = totalSum - sum1;
                    minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
                }
            }
        }
        return minDiff;
    }

    private void generateSums(int[] nums, int start, int end, int count, int currentSum, List<List<Integer>> result) {
        if (start == end) {
            result.get(count).add(currentSum);
            return;
        }
        generateSums(nums, start + 1, end, count, currentSum, result);
        generateSums(nums, start + 1, end, count + 1, currentSum + nums[start], result);
    }
}

    
    

