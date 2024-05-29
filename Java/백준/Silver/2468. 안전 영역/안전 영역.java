import java.io.*;
import java.util.*;
public class Main {
	static int N, height=0, ans=0;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(height, map[i][j]);
			}
		}
		
		for(int h=0; h<=height; h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>h && !visited[i][j]) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int h) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nr>=N||nc<0||nc>=N) continue;
			if(map[nr][nc]<=h||visited[nr][nc]) continue;
			
			dfs(nr, nc, h);
		}
	}

}
