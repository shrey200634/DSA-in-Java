package recursion;
public class arrRecursion {
    // array recursion problem, 
    public static void main(String[] args) {
        // we have to check weathrt the array is sorted or not 
        int []arr = {1,2,3,4,96,7,8,9};
        System.out.println(sorted(arr, 0));
        
    }
       static boolean sorted ( int []arr,int index ){
        // base condition 
        if (index== arr.length-1){
            return true ;

        }
        return arr[index ] <arr[index+1] && sorted(arr, index+1);

       }

       }

    

