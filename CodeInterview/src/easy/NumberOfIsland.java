package easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
class Point{
        
        public Point(int a, int b){
            this.x = a;
            this.y = b;
        }
        
        public boolean equal(Point other){
            if (this.x == other.x && this.y == other.y){
                return true;
            }
            return false;
        }
        public int x;
        public int y;
    }
    private int cnt = 0;
    private int[][] visited;
    private Queue<Point> is;//learn to use Queue 
    
    private  int row;
    private  int col;
    public int numIslands(char[][] grid) {
        
    row = grid.length;
    if (row == 0) return 0;
    col = grid[0].length;
    
    visited = new int[row][col];
    is = new LinkedList<Point>();
    
        for( int i = 0 ; i < row; i ++){
            for( int j = 0 ; j < col; j ++){
       
                    if(visited[i][j] != 1 && grid[i][j] == '1'){
                    	is.add(new Point(i,j));
                        cnt++;

                        while(is.size() > 0){
                                Point cur = is.remove();
                           System.out.println(cnt+ ", " +cur.x+", "+cur.y);
                                	visited[cur.x][cur.y] = 1;//please remember only mark as visited here
                                	//not right after it got added 
                                 if(cur.x- 1 >= 0)//if(cur.x- 1 > 0)a very bad mistake
                                   if(visited[cur.x- 1][cur.y] != 1) {;
                                     if( grid[cur.x- 1][cur.y] == '1'){
                                    	 is.add(new Point(cur.x- 1,cur.y));
                                     }
                                   }
                                   if(cur.y - 1 >= 0)
                                   if(visited[cur.x][cur.y - 1] != 1) {
                                        if( grid[cur.x][cur.y - 1] == '1'){
                                        	is.add(new Point(cur.x,cur.y - 1));
                                        }
                                   }
                                   
                                   if(cur.x+ 1 < row)
                                   if(visited[cur.x+ 1][cur.y] != 1) {
                                       if( grid[cur.x+1][cur.y] == '1'){
                                    	   is.add(new Point(cur.x+ 1,cur.y));
                                       }
                                       
                                   }
                                   
                                   if(cur.y + 1 < col)
                                   if(visited[cur.x][cur.y + 1] != 1) {
                                         if( grid[cur.x][cur.y+1] == '1'){
                                       is.add(new Point(cur.x,cur.y + 1));
                                       }
                                   }
                       
                        
                                       }
                                   }
                               
                       
                        
                
            }
        }
    return cnt;
    }
    
    
    public static void main(String[] args){
    	NumberOfIsland num = new NumberOfIsland();
    	
    	char[][] grid = { {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    

    	char[][] grid2 = { {'1','1','1'},{'0','1','0'},{'1','1','1'}};
    
    	
    	System.out.println(num.numIslands(grid2));
    }
}
