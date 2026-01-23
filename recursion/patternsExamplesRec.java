package recursion;


public class patternsExamplesRec {
    public static void main(String[] args) {
      
       Trangle(5, 0);
       
        
    }

    static void Trangle(int r , int c ){
        if ( r==0){
            return ;
        }
        if ( c<r){
            System.out.print("*");
            Trangle(r, c+1);
        }
        else {
            System.out.println();
            Trangle(r-1, c);
        }
        
    }
    
    
}
