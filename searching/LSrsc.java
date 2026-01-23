package searching;
import java.util.ArrayList;
public class LSrsc {
    public static void main(String[] args) {
        int []nums ={1,2,3,4,5,6};
        System.out.println(LN(nums, 8,0));
        // System.out.println(findIndex(nums, 4, 0));
        findIndex(nums, 4, 0);
      System.out.println(list);
    }
    static boolean LN( int []nums , int target,int index){
        if  (index==nums.length){
            return false ;

        }
        return  nums [index]  == target || LN(nums, target, index+1);

       
    }
    
    // add in array list and create it .
        static ArrayList<Integer> list = new ArrayList<>();

        static  void findIndex( int []nums , int target,int index){
        if  (index==nums.length){
            return ;

        }
        if ( nums[index ]== target ){
            list.add(index);

        }
        findIndex(nums, target, index+1);
         

       
    }
    
}
