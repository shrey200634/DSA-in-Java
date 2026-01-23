package maize;
public class obs {
    public static void main(String[] args) {
        boolean [][]board =  {
            {true,true,true},
            {true,false ,true},
            {true,true,true}

        };
        maizerestrictions("", board, 0, 0);
        
    }
    static void maizerestrictions ( String p , boolean [][] maze , int r , int c ){
        if ( r == maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return ;

        }
        if ( !maze [r][c]){
            return ;

        }
        if ( r < maze.length-1){
            maizerestrictions(p + 'D', maze, r+1, c);
        }
        if ( c< maze[0].length-1){
            maizerestrictions(p+'r', maze, r, c+1);
        }

    }
    
}
