package Graphs.problems;

public class SurroundedRegions {

    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };

    public  void  dfs(char[][] board , int x , int y , boolean[][]  vis , int n , int m  ){
        vis[x][y] = true;
        for (int d[]:directions){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && board[nx][ny] == 'O'){
                dfs(board , nx , ny , vis , n , m);
            }
        }
    }
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        boolean[][]  vis= new boolean[n][m];
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O' && !vis[0][j]){
                dfs(board , 0 , j , vis , n , m);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(board , i , 0 , vis , n , m);
            }
        }

        for(int j=0;j<m;j++){
            if(board[n-1][j] == 'O' && !vis[n-1][j]){
                dfs(board , n-1 , j , vis , n , m);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][m-1] == 'O' && !vis[i][m-1]){
                dfs(board , i , m-1 , vis , n , m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }


    }
}
