import java.io.*;
import java.util.*;
public class day7 {
	static int N, K, ans;
	static int[][] board;
	//왼쪽, 왼쪽위, 위, 오른쪽위, 오른쪽, 오른쪽아래, 아래, 왼쪽아래
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static class loc {
		int r, c;

		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static Queue<loc> blank;
	static PriorityQueue<Integer> flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		board = new int[N][N];
		blank = new ArrayDeque<>();
		flag = new PriorityQueue<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==0){
					blank.add(new loc(i, j));
				}
			}
		}
		bfs();
		while(!flag.isEmpty()) {
			int tmp = flag.poll();
			if(tmp==K){
				ans++;
			}
			else if(tmp>K){
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
	static void bfs(){
		while(!blank.isEmpty()){
			int cnt = 0;
			loc cur = blank.poll();
			for(int i=0; i<8; i++){
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(board[nr][nc]==1){
					cnt++;
				}
			}
			flag.add(cnt);
		}
	}
}