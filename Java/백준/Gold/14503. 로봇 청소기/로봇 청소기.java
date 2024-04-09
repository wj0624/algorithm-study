import java.io.*;
import java.util.*;


public class Main {
	
	static int N, M, cleanCount=0;
	static int [][] room; // 방
	
	//0: 북, 1: 동, 2: 남, 3: 서
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};	

	public static void main(String[] args) throws Exception {
		//입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int robotR = Integer.parseInt(st.nextToken());
		int robotC = Integer.parseInt(st.nextToken());
		int robotDir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		//dfs로 탐색
		dfs(robotR, robotC, robotDir);
		
		System.out.println(cleanCount);
	}
	
	static void dfs(int r, int c, int dir) {
		boolean blank = false;
			
		//현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
		if(room[r][c]==0) {
			room[r][c] = -1; //청소함 : -1
			cleanCount++;	//청소한 칸 수 증가
		}
			
		//현재 칸 주변 4칸 탐색
		for(int i=0; i<4; i++) {
			int ndir = (dir+3)%4;	//반시계 방향으로 90도 회전한 방향 확인
			//바라보는 방향 기준 앞쪽 칸
			int nr = r + dr[ndir];  
			int nc = c + dc[ndir];
			
			//방의 범위를 벗어나면 무시
			if(nr<0||nr>=N||nc<0||nc>=M) continue;
				
			if(room[nr][nc] == 0) {
				dfs(nr, nc, ndir); //청소
				blank = true; //빈칸이 있는 경우
				break;
			}
			dir = (dir+3)%4;	//반시계 방향으로 90도 회전
		}
			
			
		//현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
		if(!blank) {
			int ndir = (dir+2)%4;	//후진(즉, 180도 돈 방향으로 직진)
			//바라보는 방향 기준 앞쪽 칸
			int nr = r + dr[ndir];  
			int nc = c + dc[ndir];
			if(nr>=0 && nr<N && nc>=0 && nc<M) { //방의 범위 내에 있을 때
				if(room[nr][nc]!=1) { //벽이 아닌 경우
					dfs(nr, nc, dir); //방향은 그대로 유지
				}
			}
		}
	}
}