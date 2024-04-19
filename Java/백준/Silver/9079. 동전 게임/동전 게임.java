import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static int [][] coin;
	static boolean check=false;
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		coin = new int[3][3];
		
		for(int i=0; i<T; i++) {
			ans = Integer.MAX_VALUE;
			for(int j=0; j<3; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<3; k++) {
					String s = st.nextToken();
					if(s.equals("H")) {
						coin[j][k] = 1;
					}
					else {
						coin[j][k] = 0;
					}
				}
			}
			
			// 탐색 수행
			dfs(0, 0, coin);
			
			if(ans==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(ans);
		}
		
		
	}
	
	static void dfs(int idx, int count, int [][] c) {
		// 종료조건
		if(checkCoin(c)) {
			ans = Math.min(ans, count);
			return;
		}
		if(idx==8) {
			return;
		}
		
		
		// 1. 행 뒤집기
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				c[i][j] = (c[i][j]==1? 0: 1);
			}
			dfs(idx+1, count+1, c);
			for(int j=0; j<3; j++) {
				c[i][j] = (c[i][j]==1? 0: 1);
			}
		}
		
		// 2. 열 뒤집기
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				c[j][i] = (c[j][i]==1? 0: 1);
			}
			dfs(idx+1, count+1, c);
			for(int j=0; j<3; j++) {
				c[j][i] = (c[j][i]==1? 0: 1);
			}
		}
		
		// 3. 왼쪽위에서 오른쪽아래 대각선
		for(int i=0; i<3; i++) {
			c[i][i] = (c[i][i]==1? 0: 1);
		}
		dfs(idx+1, count+1, c);
		for(int i=0; i<3; i++) {
			c[i][i] = (c[i][i]==1? 0: 1);
		}
		
		// 4. 오른쪽위에서 왼쪽아래 대각선
		for(int i=0; i<3; i++) {
			c[i][2-i] = (c[i][2-i]==1? 0: 1);
		}
		dfs(idx+1, count+1, c);
		for(int i=0; i<3; i++) {
			c[i][2-i] = (c[i][2-i]==1? 0: 1);
		}
	}

	static boolean checkCoin(int[][] c) {
		int x = c[0][0];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(x!=c[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
