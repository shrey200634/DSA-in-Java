package Sorting;
import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {

        int []arr ={5,4,2,1,8,9,63856836,324,5765,435,345,76, 456,45};
        arr=MergeS(arr);
        System.out.println(Arrays.toString(arr));

        
    }
    static int []MergeS (int []arr){
        if ( arr.length==1){
            return arr;

        }
        int mid = arr.length/2;

        int []left=MergeS(Arrays.copyOfRange(arr, 0, mid));
        int []right= MergeS(Arrays.copyOfRange(arr, mid, arr.length));

        return merge (left,right );
    }
    private static int[]merge ( int[]first, int []second ){
        int []mix = new int [first.length +second.length];
        int i=0;
        int j=0;
        int k=0;

        while ( i<first.length && j< second.length ){
            if ( first[i]< second[j]){
                mix [k]= first[i];
                i++;

            }
            else {
                mix [k]= second[j];
                j++;

            }
            k++;
        }
        //it may be possible that one of the possible array is imcomplete 
        // copy remaining array 
        while (i<first.length ){
            mix [k]=first[i];
            i++;
            k++;

        }
        while ( j< second .length ){
            mix[k] =second [j];
            j++;
            k++;

        }
        return mix ;

    }
   
}
