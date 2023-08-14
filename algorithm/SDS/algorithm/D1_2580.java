package algorithm;
import java.io.*;
import java.util.*;

public class D1_2580 {
	static class loc{
		int y, x;
		public loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] board = new int[10][10];
	static ArrayList<loc> blank;
	
	static boolean isComplete;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		blank = new ArrayList<loc>();
		// 입력
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==0) blank.add(new loc(i,j));
				
			}
		}
		sudoku(0);
		
		return;
	}
	
	//cur = blank 0 ~ size()
	static void sudoku(int cur) {
		//탈출 조건
		//답이 하나라도 나왔으면 종료
		if(isComplete) return;
		
		//모든 시험 통과 = 탈출
		if(cur == blank.size()) {
			isComplete = true;
			print();
			return;
		}
		
		loc curloc = blank.get(cur);
		
		//1부터 9까지 확인
		for(int i=1;i<=9;i++) {
			board[curloc.y][curloc.x] = i;
			if(check(blank.get(cur))) {
				//이 값을 넣어도 문제 없으니 스도쿠 진행
				sudoku(cur+1);
			}
		}
		board[curloc.y][curloc.x] = 0; //불가 시 0
	}
	
	static boolean check(loc point) {
		//1)행 확인
		for(int i=0;i<9;i++) {
			//자기 자신 pass
			if(i==point.x) continue;
			if(board[point.y][point.x] == board[point.y][i])
				return false;
		}
		//2)열 확인
		for(int i=0;i<9;i++) {
			//자기 자신 pass
			if(i==point.y) continue;
			if(board[point.y][point.x] == board[i][point.x])
				return false;
		}
				
		//3) 정사각형 확인
		// 012 / 345 / 678 => 나누기 3했을 때 몫으로 판단
			
		int sy = point.y / 3;
		sy *= 3;
		int sx = point.x / 3;
		sx *= 3;
		for(int i=sy; i<sy+3; i++) {
			for(int j=sx; j<sx+3; j++) {
				if(i==point.y&& j==point.x) continue;
				if(board[point.y][point.x] == board[i][j])
					return false;
			}
		}
		return true;
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
