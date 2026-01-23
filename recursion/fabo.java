package recursion;
import java.util.*;
public class fabo {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        int n = sc.nextInt();      
        fabonacciSeries(n);
    }
    static void fabonacciSeries( int n){
         if ( n<= 0){
            System.out.println("not good ");
            return ;

         }

            int a=0;
            int b=1;
            for (int i = 1; i <n; i++) {
            System.out.println(a +" ");
            int c= a+b ;
            a=b;
            b=c;

            
         }
    }
    
}
