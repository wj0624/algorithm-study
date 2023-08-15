import java.io.*;
import java.util.*;

public class D1_9663 {
	static int N, ans;
	static int [] xLoc = new int[16];	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		nQueen(0);
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void nQueen(int y) {
		//탈출조건
		if (y==N) {	//퀸을 다 두는데 성공
			ans++;
			return;
		}
		
		//i행 j열
		for(int j=0; j<N; j++) {
			boolean isPossible = true;
			for(int i=0;i<y;i++) {
				//안되는 모든 경우의 수
				//1)같은 열에 존재하는 경우
				if( xLoc[i] == j ||
						//2) 왼쪽 위 대각선에 존재
						(xLoc[i] - (y-i) == j) ||
						//3) 오른쪽 위 대각선에 존재
						(xLoc[i] + (y-i) == j)) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				xLoc[y] = j;
				nQueen(y+1);
			}
		}
	}
}