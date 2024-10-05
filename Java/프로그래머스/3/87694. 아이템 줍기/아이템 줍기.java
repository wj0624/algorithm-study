import java.io.*;
import java.util.*;
class Solution {
    static class Loc{
        int x, y, dist;
        public Loc(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static boolean[][] map = new boolean[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle) {
            for(int i=rect[0]*2; i<=rect[2]*2; i++){
                for(int j=rect[1]*2; j<=rect[3]*2; j++){
                    map[i][j] = true;
                }
            }
        }
        
        for(int[] rect : rectangle) {
            for(int i=rect[0]*2+1; i<rect[2]*2; i++){
                for(int j=rect[1]*2+1; j<rect[3]*2; j++){
                    map[i][j] = false;
                }
            }
        }  
        
        Queue<Loc> q = new ArrayDeque<>();
        q.add(new Loc(characterX*2, characterY*2, 0));
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()){
            Loc cur = q.poll();
            if(cur.x == itemX*2 && cur.y == itemY*2){
                return cur.dist / 2;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<0||nx>=101||ny<0||ny>=101) continue;
                if(map[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Loc(nx, ny, cur.dist+1));
                }
            }
        }
        return -1;
    }
}