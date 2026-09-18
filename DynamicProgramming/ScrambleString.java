package DynamicProgramming;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length())return false ;
        if(s1.equals(s2)) return true ;

        int n = s1.length();

        Boolean[][][] memo = new Boolean [n][n][n+1];
        return dfs(0,0,n, s1,s2,memo);
        
    }
    private boolean dfs(int i , int j , int len , String s1 , String s2 , Boolean[][][] memo){

        String temps1 = s1.substring(i , i+len);
        String temps2 =s2.substring(j,j+len);
        if(temps1.equals(temps2)){
            return true ;
        }
        if(!hasSameCharacter(i,j,len,s1,s2)){
            return false ;
        }
        if (memo[i][j][len] != null){
            return memo[i][j][len];
        }
        for (int h =1 ; h< len ; h ++){
            if (dfs(i, j, h, s1, s2, memo) && dfs(i + h, j + h, len - h, s1, s2, memo)) {
                return memo[i][j][len] = true;
            }
            if (dfs(i, j + len - h, h , s1,s2,memo) && dfs(i + h, j, len - h,s1,s2,memo)) {
                return memo[i][j][len] = true;
            }
        }
        return memo[i][j][len] = false;


    }
    private boolean hasSameCharacter( int i , int j , int len , String s1 , String s2){

        int [] count = new int[26];
        for (int k =0 ; k< len ; k++){
            count[s1.charAt(i+k)-'a']++;
            count[s2.charAt(j+k)-'a']--;
        }
        for(int c : count){
            if (c!= 0)return false ;
        }
        return true ;

    } 





    
}
