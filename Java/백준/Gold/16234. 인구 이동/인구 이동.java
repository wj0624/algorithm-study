//import java.io.*;
//import java.util.*;
//public class P16234 {
//	static class Loc {
//		int r, c;
//
//		public Loc(int r, int c) {
//			this.r = r;
//			this.c = c;
//		}
//	}
//	
//	static int N, L, R;
//	static int [][] A;
//	static int [] dr = {-1, 1, 0, 0};
//	static int [] dc = {0, 0, -1, 1};
//	static ArrayList<Loc> union;
//	static boolean [][] visited;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		L = Integer.parseInt(st.nextToken());
//		R = Integer.parseInt(st.nextToken());
//		
//		A = new int[N][N];
//		
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<N; j++) {
//				A[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		
//		System.out.println(move());
//		
//	}
//	
//	static int move() {
//		int ans = 0;
//		while(true) {
//			boolean isMove = false;
//			visited = new boolean[N][N];
//			
//			// 국경선 확인
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					if(!visited[i][j]) {
//						int sum = bfs(i, j);	//연합찾기
//						if(union.size() > 1) {
//							changePopulation(sum);
//							isMove = true;
//						}
//					}
//				}
//			}
//			if(!isMove) return ans;
//			ans++;	// 이동 있었다면 하루 추가
//		}
//	}
//	
//
//	static int bfs(int r, int c) {
//		Queue<Loc> q = new LinkedList<>();
//		union = new ArrayList<>();
//		
//		q.add(new Loc(r, c));
//		union.add(new Loc(r, c));
//		visited[r][c] = true;
//		int sum = A[r][c];
//		
//		while(!q.isEmpty()) {
//			Loc cur = q.poll();
//			
//			for(int i=0; i<4; i++) {
//				int nr = cur.r+dr[i];
//				int nc = cur.c+dc[i];
//				
//				if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]) continue;
//				
//				int sub = Math.abs(A[r][c]-A[nr][nc]);
//				if(sub >= L && sub <= R) {
//					visited[nr][nc] = true;
//					union.add(new Loc(nr, nc));
//					q.add(new Loc(nr, nc));
//					sum += A[nr][nc];
//				}
//			}
//		}
//		return sum;
//	}
//	static void changePopulation(int sum) {
//		// 인구이동 결과로 배열 갱신
//		int avg = sum / union.size();
//		for(int i=0; i<union.size(); i++) {
//			Loc cur = union.get(i);
//			A[cur.r][cur.c] = avg;
//		}
//	}
//}

import java.util.*;
import java.io.*;

public class Main {
	static int n, l, r;
	static int[][] map;
	static ArrayList<int[]> list;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 동 남 서 북

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());

	}

	static int move() { // 인구이동 발생일 수 구하기
		int result = 0;
		while (true) {
			visit = new boolean[n][n];
			boolean isMove = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						int sum = bfs(i, j);// 연합찾기
						if (list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if (!isMove)
				return result;
			result++;
		}

	}

	static void changePopulation(int sum) {
		int avg = sum / list.size();
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			map[x][y] = avg;
		}
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		list = new ArrayList<>();

		q.add(new int[] { x, y });
		list.add(new int[] { x, y });
		visit[x][y] = true;
		int sum = map[x][y];

		while (!q.isEmpty()) {
			int[] t = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (!visit[nx][ny]) {
						int tmp = Math.abs(map[t[0]][t[1]] - map[nx][ny]);
						if (tmp >= l && tmp <= r) {
							visit[nx][ny] = true;
							q.add(new int[] { nx, ny });
							list.add(new int[] { nx, ny });
							sum += map[nx][ny];
						}

					}
				}
			}
		}
		return sum;
	}

}