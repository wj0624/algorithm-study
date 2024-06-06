import java.io.*;
import java.util.*;
public class Main {
	static int N, num=0;
	static int [][] map;
	static boolean [][] visited;
	static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static List<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;
					ans.add(bfs(i, j));
					num++;
				}
			}
		}
		Collections.sort(ans);
		
		System.out.println(num);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	private static int bfs(int r, int c) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(r, c));
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]) continue;
				
				if(map[nr][nc]==1) {
					q.add(new Loc(nr, nc));
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}	
		return cnt;
	}
}