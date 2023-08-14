package algorithm;
import java.io.*;
import java.util.*;

public class D1_1103{
	
	static int N, M, ans;
	static boolean iFlag; //Infinite Flag 무한루프에 빠지면 탈출
	
	static int[] dy = {0, 0, -1, 1};	//행 이동
	static int[] dx = {-1, 1, 0, 0};	//열 이동
	
	static int[][] board, score;
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		board = new int[N][M];
		score = new int[N][M];
		visit = new boolean[N][M];
		
		//입력
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				//int로 맞춰서 map에 넣어줌
				if(str.charAt(j) == 'H') board[i][j] = 10;
				else board[i][j] = str.charAt(j) - 48;
			}
		}
		
		//DFS로 깊이 우선 탐색 + DP로 가지치기
		visit[0][0] = true;	//(0,0) 무한 loop 확인용 true 마킹
		iFlag = false;
		dfs(0,0,1); //(0,0)에서 출발
		
		if(iFlag) bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();		
	}
	static void dfs(int y, int x, int cnt) {
		if(cnt > ans) ans = cnt; //답 최신화
		score[y][x] = cnt; //가지치기용 dp배열에 현재 cnt 마킹
		for(int i=0;i<4;i++) {
			int num = board[y][x]; //보드에 적힌 숫자
			int ny = dy[i] * num + y; //보드에 적인 숫자*방향 만큼 이동
			int nx = dx[i] * num + x;
			
			if(ny<0||nx<0||ny>=N||nx>=M||board[ny][nx]==10) continue;	//보드 범위 넘어서거나 구멍이면 넘어가기
			if(visit[ny][nx]) {
				iFlag = true;
				return; //방문한 지점에 돌아왔으므로 무한 loop가능
			}
			if(score[ny][nx] > cnt) continue; //현재 방문횟수보다 크면 실행 x, 최소 실행횟수 구하기 때문
			visit[ny][nx] = true;
			dfs(ny, nx, cnt+1);
			visit[ny][nx] = false;
		}
	}
}
/*1. 탈출조건
if(탈출조건){
	return;
}
2. 인접한 정점 방문
// 인접좌표(상하좌우)
for(인접정점){
	//2-1. 좌표초과 continue
	 int nr = r+dr[i];
	 int nc = c+dc[i];
	 
	 //2-2. dfs 진행
	 visit[nr][nc] = true;
	 dfs(nr,nc);
	 visit[nr][nc] = false;
}
*/
