import java.io.*;
import java.util.*;

public class P2578 {
	
	static int [][] bingo = new int [5][5];
	static int bCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//철수 빙고
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//사회자가 숫자 부르기 시작
		int num = 0; //몇번째 숫자인지
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				num++;
				
				//부르는 숫자 지우기
				delNum(Integer.parseInt(st.nextToken()));
				
				//빙고 체크
				checkBingo();
				if(bCount >= 3) {
					System.out.println(num);
					return;
				}
			}
		}
		
	}
	
	//숫자 지우기 함수
	public static void delNum(int num) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j]==num) {
					bingo[i][j] = -1;
				}
			}
		}
	}
	
	//빙고 체크
	public static void checkBingo() {
		bCount = 0;
		int row = 0;
		int col = 0;
		int lDiag = 0; //왼쪽에서 오른쪽 아래로 가는 대각선
		int rDiag = 0; //오른쪽에서 왼쪽 아래로 가는 대각선
		for(int i=0; i<5; i++) {
			row = 0;
			col = 0;
			for(int j=0; j<5; j++) {
				row += bingo[i][j];
				col += bingo[j][i];
				
				//왼->오 대각선
				if(i==j) {
					lDiag += bingo[i][j];
				}
				if(j==4-i) {
					rDiag += bingo[i][j];
				}
			}
			//빙고가 있으면
			if(row == -5) bCount++;
			if(col == -5) bCount++;
			if(lDiag == -5) bCount++;
			if(rDiag == -5) bCount++;
		}
		
		
	}
	

}
