package maize;
public class pat {
    public static void main(String[] args) {
        tr(4, 0);
        
    }
    static void tr( int r , int c){
        if ( r==0){
            return ;

        }
        if (c<r){
            System.out.print("*");
            tr(r, c+1);
        }else{
            System.out.println();
            tr( r-1, 0);
        }
    }
    
}
