package Graphs.problems;

public class FloodFillAlgorithm {

    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };
    public  void  dfs(int[][] image , int sr, int sc, int currColor ,  int color , boolean[][] vis , int n , int m , int[][] ans){
        vis[sr][sc] = true;
        ans[sr][sc] = color;
        for(int i=0;i<directions.length;i++){
            int newX = sr+directions[i][0];
            int newY = sc+directions[i][1];
            if(newX >= 0 && newX < n && newY >= 0 && newY <m && image[newX][newY] == currColor && !vis[newX][newY]){
                vis[newX][newY] = true;
                dfs(image , newX , newY ,currColor ,  color , vis , n , m , ans);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = image[i][j];
            }
        }
        int currColor = image[sr][sc];
        dfs(image , sr , sc, currColor ,color , vis , n, m , ans);
        return  image;
    }

}
