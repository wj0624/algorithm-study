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
	static int M, N, K, cnt;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int [][] arr;
	static boolean [][] visited;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==1 & !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(r, c));
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			visited[cur.r][cur.c] = true;
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=M||nc<0||nc>=N||visited[nr][nc]) continue;
				if(arr[nr][nc]==1) {
					visited[nr][nc] = true;
					q.add(new Loc(nr, nc));
				}
			}
		}
		
	}

}
