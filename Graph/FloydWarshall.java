package Graph;

public class FloydWarshall {

    final static int INF = 99999;
    final static int V =4 ;

    public void floydWarshall(int [][] graph ){
        int dis [][] = new int[V][V];

        for (int i =0 ; i<V ; i++){
            for (int j =0 ; j<V;j++){
                dis[i][j] = graph[j][j];
            }
        }

        for (int k =0 ; k<V ; k++){
            for(int i =0 ; i<V; i++){
                for (int j =0 ; j<V ;j++){
                   if( dis[i][k] + dis[k][j]  < dis[i][j] ){
                    dis[i][j] = dis[j][k] + dis[k][j];
                   }
                }
            }
        }


        print ( dis);
    }

    private void print(int[][] dist) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.printf("%7s", "INF");
                } else {
                    System.out.printf("%7d", dist[i][j]);
                }
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        
    }
    
}
