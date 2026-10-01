package DynamicProgramming;
import java.util.*;


public class WildCardMatching {

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        // uses the memo problem 

        int [][] memo = new int [n][m];
        for ( int [] row : memo){
            Arrays.fill(row , -1 );
        }

        return isWidk(n-1 , m-1 , s,p,memo);
    }
    private boolean isWidk( int i , int j , String s1 , String s2 , int [][] dp ){
        if (i< 0 && j< 0 ) return true ;
       if (i >= 0 && j < 0) return false;
        
        if (i<0 && j>=0){
            for ( int k =0 ; k<= j ; k++){
                if (s2.charAt(k) != '*' ) return false  ;
            }
            return true ;
        }

        if (dp[i][j] != -1 ){
            return dp[i][j] ==1 ;
        }
        boolean res = false ;

        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(i) =='?'){
            res = isWidk(i-1 , j-1 , s1,s2,dp );
        }else if (s2.charAt(j)=='*'){

            boolean match = isWidk(i-1 , j , s1,s2,dp);
            boolean nonMatch = isWidk(i,j-1,s1,s2,dp);

            res = match || nonMatch ;


        }
        dp [i][j] = res ? 1:0;
        return res ;
    }
}









    

