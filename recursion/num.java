package recursion;
public class num {
   public static void main(String[] args) {
      
      System.out.println(sum(5472) );


   }
   static int sum( int n){
      if ( n==0){
         return 0;

      }
      return  n%10 + sum(n/10);

   }


}
