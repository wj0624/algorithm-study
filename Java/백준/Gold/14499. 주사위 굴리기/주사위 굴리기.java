import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, diceR, diceC;
	static int [][] map;
	//1 동 2 서 3 북 4 남
	static int [] dr = {0, 0, -1, 1};
	static int [] dc = {1, -1, 0, 0};
	static int [] dice = new int [6]; //주사위, 인덱스 0이 가장 윗면
	
	public static void main(String[] args) throws Exception {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		diceR = Integer.parseInt(st.nextToken());
		diceC = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//지도
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			moveDice(d); //주사위 이동
		}
		
	}
	
	//주사위 움직이기
	static void moveDice(int dir) {
		int nr = diceR + dr[dir-1];
		int nc = diceC + dc[dir-1];
		
		//지도 바깥일 경우 return
		if(nr<0||nr>=N||nc<0||nc>=M) return;
		
		//주사위 굴려서 이동
		rollDice(dir);
		
		//이동한 칸에 쓰여 있는 수가 0이면
		if(map[nr][nc]==0) {
			//주사위 바닥면에 쓰여 있는 수가 칸에 복사
			map[nr][nc] = dice[5];
		}
		
		//0이 아닌 경우
		else {
			//칸에 쓰여 있는 수가 주사위 바닥면으로 복사
			dice[5] = map[nr][nc];
			//칸에 쓰여 있는 수는 0이 됨
			map[nr][nc] = 0;
		}
		
		//주사위 상단에 쓰인 값 출력
		System.out.println(dice[0]);
		
		//위치 갱신
		diceR = nr;
		diceC = nc;
	}
	
	//주사위 회전
	//  2
	// 413
	//  5
	//  6
	static void rollDice(int dir) {
		int top = dice[0];
		//동쪽으로 굴리기
		if(dir==1) {
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = top;
		}
		//서쪽으로 굴리기
		else if(dir==2) {
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = top;
		}
		//북쪽으로 글리기
		else if(dir==3) {
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = top;
		}
		//남쪽으로 굴리기
		else {
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = top;
		}
	}
}
