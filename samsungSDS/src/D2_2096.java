import java.io.*;
import java.util.*;

public class D2_2096 {
	
	static int N, minval, maxval;
	static int[][] board, mini, maxi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][3];
		mini = new int[N][3];
		maxi = new int[N][3];
		
		//1.입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		goDown();
		
		//출력
		System.out.println(maxval+" "+minval);
		
		br.close();
	}
	
	static void goDown() {
		int tmp;
		//초기화
		for(int i=0;i<3;i++) {
			maxi[0][i] = mini[0][i] = board[0][i];
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				switch(j) {
				case 0 : 
					maxi[i][0] = Math.max(maxi[i-1][0], maxi[i-1][1])+board[i][0];
					mini[i][0] = Math.min(mini[i-1][0], mini[i-1][1])+board[i][0];
					break;
				case 1 :
					tmp = Math.max(maxi[i-1][0], maxi[i-1][1]);
					maxi[i][1] = Math.max(tmp , maxi[i-1][2])+board[i][1];
					tmp = Math.min(mini[i-1][0], mini[i-1][1]);
					mini[i][1] = Math.min(tmp, mini[i-1][2])+board[i][1];
					break;
				case 2 : 
					maxi[i][2] = Math.max(maxi[i-1][1], maxi[i-1][2])+board[i][2];
					mini[i][2] = Math.min(mini[i-1][1], mini[i-1][2])+board[i][2];
					break;
				}
			}
		}
		Arrays.sort(maxi[N-1]);
		Arrays.sort(mini[N-1]);
		maxval = maxi[N-1][2];
		minval = mini[N-1][0];
		
//		tmp = Math.max(maxi[N-1][0], maxi[N-1][1]);
//		maxval = Math.max(tmp , maxi[N-1][2]);
//		tmp = Math.min(mini[N-1][0], mini[N-1][1]);
//		minval = Math.min(tmp , mini[N-1][2]);
	}
	
}
