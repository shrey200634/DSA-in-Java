package DynamicProgramming;

import java.util.Scanner;

public class fiboTabulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()){
            int n = sc.nextInt();

            if (n==0){
                System.out.println(0);
                return;
            }

            int prev2 =0 ;
            int prev1 =1 ;

            for (int i =2  ; i<=n; i++){
                int curri = prev1 + prev2;

                prev2= prev1;
                prev1=curri;
            }
            System.out.println(prev1);
        }
        sc.close();
    }
    
}
