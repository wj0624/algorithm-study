import java.io.*;
import java.util.*;

public class Main {
	static class Loc{
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, flowerCnt=0, sum=0;
	static int ans = Integer.MAX_VALUE;
	static int map [][];
	static Queue<Loc> flower = new LinkedList<>();
	static boolean visited [][];
	static int dr [] = {-1, 1, 0, 0};
	static int dc [] = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	private static void dfs(int cnt, int sum) {
		if(cnt==3) {				
			ans = Math.min(ans, sum);
		}
		
		else {
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(!visited[i][j]&&check(i,j)) {
						visited[i][j] = true;
						dfs(cnt+1, sum+flowerSum(i,j));
						visited[i][j] = false;
						visitClear(i, j);
						
					}
				}
				
			}
		}
		
	}
	private static void visitClear(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			visited[nr][nc] = false;
		}
	}
	private static int flowerSum(int r, int c) {
		int sum = map[r][c];
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			visited[nr][nc] = true;
			sum += map[nr][nc];
		}
		
		return sum;
	}
	private static boolean check(int r, int c) {		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(visited[nr][nc]) return false;
		}
		return true;
	}

}
