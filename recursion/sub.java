package recursion;
import java.util.ArrayList;

public class sub {
    public static void main(String[] args) {
        // subseq("", "abs");
        System.out.println(subseqRet("", "abs"));
        
    }
    static void subseq( String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return ;

        }
        char ch = up.charAt(0);
        subseq( p+ch, up.substring(1));
         subseq( p, up.substring(1));
    }

    // solve through array list 
    // pass array list in the argument 
    static ArrayList<String > subseqRet( String p, String up ){
        if( up.isEmpty()){
        ArrayList<String > List = new ArrayList<>();
        List.add(p);
        return List;
    }
     char ch = up.charAt(0);
         ArrayList<String > left =subseqRet( p+ch, up.substring(1));
         ArrayList<String > right =subseqRet ( p, up.substring(1));

         left.addAll(right );
         return left ;


    
}
}