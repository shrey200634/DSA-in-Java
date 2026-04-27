import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length ;
        int col = heights[0].length ;

       int [][] diff = new int[rows ][col ];
        for (int[] row : diff){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        diff[0][0] =0 ;


        int [][ ] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()){
            int []curr = pq.poll();
            int currDiff = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == rows -1 && c == col-1){
                return currDiff;
            }

            if (currDiff >diff[r][c]){
                continue;
            }
            for (int[] direction : dir){
                int newRow = r + direction[0];
                int newCol = c + direction[1];

                if (newRow>=0 && newRow < rows && newCol >=0 && newCol < col){
                  int effortToNeighbor = Math.abs(heights[r][c] - heights[newRow][newCol]);  
                  int maxEffortForPath = Math.max(currDiff, effortToNeighbor);
                  if (maxEffortForPath < diff[newRow][newCol]) {
                        diff[newRow][newCol] = maxEffortForPath;
                        pq.offer(new int[]{maxEffortForPath, newRow, newCol});
                    }
                }

            }
        }
              return 0 ;
        
    }
    
}
