package maize;
import java.util.ArrayList;
public class maize {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        trace("", 9, 2);
        traceDigonally("", 3, 3);
        System.out.println(traceDigonally("", 3, 3));
        
    }
    // backtracking ....maize problem 
    static int count ( int r , int c){
        if (r==1||c==1){
            return 1 ;

        }
        int left = count(r-1, c);
        int right = count(r, c-1);
         return left + right ;


    }
     static void   trace( String  p, int r, int c ){
        if ( r==1&&c==1){
            System.out.println(p);
            return ;

        }
        if ( r>1){
            trace( p+'D', r-1, c);
        }
        if (c>1 ){
            trace( p+'R', r, c-1);
        }
    }

       // ton put these array in list use of array list 

    static ArrayList<String > traceDigonally ( String  p, int r, int c ){
        if ( r==1&&c==1){
            ArrayList<String > list = new ArrayList<>();
            list.add(p);
            return list;
        }
           ArrayList<String > list= new ArrayList<>();


        if ( r>1){
           list.addAll( traceDigonally( p+'V', r-1, c));// Verticle  call
        }
        if ( r>1&&c>1){
            list.addAll(traceDigonally(p+'D', r-1, c-1));  // recursive call for digonally 
                                            // c== digonally cross simbol 
        }
        if (c>1 ){
            list.addAll(traceDigonally( p+'H', r, c-1)); // horizontal call 
        }
        return list;

    }
     

    
}
