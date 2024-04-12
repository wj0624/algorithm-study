import java.io.*;
import java.util.*;

public class Main {
	static class loc {
		int r, c;

		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	
	static int N, K, L, ans=0, time=0;
	static int [][] board; //보드판
	static ArrayList<loc> snake = new ArrayList<>(); //뱀
	static HashMap<Integer, String> turn = new HashMap<>(); //회전 정보
	
	//0: 동, 1: 남, 2: 서, 3 북
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1; //1행1열로 시작
			int col = Integer.parseInt(st.nextToken())-1;
			board[row][col] = 1;	//사과위치
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			turn.put(t, dir);
		}
		//입력 끝
		
		snake.add(new loc(0,0));
		bfs();
		
		System.out.println(time);
		
	}
	
	static void bfs() {
		int dir = 0;
		while(true) {
			time++;
			//뱀의 머리 가지고오기
			loc cur = snake.get(snake.size()-1);
			
			//뱀 이동
			int nr = cur.r + dr[dir];
			int nc = cur.c + dc[dir];
			
			//종료조건 - 범위 벗어나거나 뱀 몸통 만날 때
			if(nr<0||nc<0||nr>=N||nc>=N) return;
			for(int i=0; i<snake.size(); i++) {
				loc tmp = snake.get(i);
				if(tmp.r == nr && tmp.c == nc) {
					return;
				}
			}
			
			//사과가 있을 때
			if(board[nr][nc]==1) {
				board[nr][nc] = 0; //사과 없어지고
				snake.add(new loc(nr, nc)); //꼬리 움지기이지 않고 머리만 이동
			}
			//사과가 없을 때
			else {
				snake.add(new loc(nr, nc)); //머리 이동
				snake.remove(0); //꼬리 움직임
			}
			
			//방향 바뀔 시간
			if(turn.containsKey(time)) { // 해당 시간이라면
				//D일 때 방향전환(오른쪽 90도)
				if(turn.get(time).equals("D")) {
					dir = (dir+1)%4;
				}
				//L일 때 방향전환(왼쪽 90도)
				else {
					dir = (dir+3)%4;
				}
			}
		}
	}
}
