package DynamicProgramming;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        int cost =0 ;
        int profit =0 ;
       int min = prices[0];
       for ( int i =1 ; i< n ; i++){
        cost = prices[i] - min ;
        profit = Math.max(profit , cost );
        min = Math.min(min , prices[i]);
       }
       return profit ;  
    }
}