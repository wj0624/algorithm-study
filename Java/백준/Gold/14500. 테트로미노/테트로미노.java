import java.io.*;
import java.util.*;
public class Main {
	
	static int N, M;
	static int ans = Integer.MIN_VALUE;
	static int [][] paper;
	static boolean [][] tetromino;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		tetromino = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tetromino[i][j] = true;
				dfs(i, j, paper[i][j], 1);
				tetromino[i][j] = false;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int row, int col, int sum, int count) {
		//종료 조건
		if(count==4) { //깊이 4까지 탐색
			ans = Math.max(ans, sum);
			return;
		}
		
		//상하좌우 탐색
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			//범위를 벗어났거나 이미 테트로미노의 한 조각이면 무시
			if(nr<0||nr>=N||nc<0||nc>=M||tetromino[nr][nc]==true) continue;
			
			tetromino[nr][nc] = true;
			// ㅗㅜㅏㅓ모양 탐색
			if(count==2) { //2번까지 만들어진 상태에서 상하좌우 탐색
				dfs(row, col, sum+paper[nr][nc], count+1);
			}
			
			// 나머지 테트로미노
			dfs(nr, nc, sum+paper[nr][nc], count+1);
			tetromino[nr][nc] = false;
		}
	}

}
