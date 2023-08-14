package algorithm;
import java.io.*;
import java.util.*;

public class D5_1256 {
	
	static final int MAX = 1_000_000_000;
	static int n, m, k;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new long[n+1][m+1];

		for(int i=1; i<=n; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=m; i++) {
			dp[0][i] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = Math.min(dp[i-1][j] + dp[i][j-1], MAX);
			}
		}
		
		//예외 조건 (k번째의 값이 없을 때)
		if(dp[n][m] < k) {
				System.out.println(-1);
				return;
		}
		
		int aCnt = n;
		int zCnt = m;
		
		for(int i=0; i<n+m; i++) {
			//a가 다 떨어졌을 때
			if(aCnt==0) {
				//z 사용 후 z의 개수 차감
				sb.append("z");
				zCnt--;
				continue;
			}
			//z가 다 떨어졌을 때
			else if(zCnt==0) {
				//a 사용 후 a의 개수 차감
				sb.append("a");
				aCnt--;
				continue;
			}
			
			//a로 시작하는 개수가 k보다 크거나 같다면 a로 시작하겠네
			if(dp[aCnt-1][zCnt]>=k) {
				sb.append("a");
				aCnt--;
			}
			else { //아니면 z부터 시작하겠군
				k -= dp[aCnt-1][zCnt];
				sb.append("z");
				zCnt--;
			}
		}
		System.out.println(sb.toString());		
		br.close();		
	}
	
	
	//메모리초과
//	static void permutation(int cnt, String cur) {
//		kcnt++;
//		if(kcnt == k) return;
//		if(cnt == 0) {
//			dictionary.add(cur);
//			return;
//		}
//		for (int i=0; i<n+m; i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				permutation(cnt-1, cur+str[i]);
//				visited[i] = false;
//			}
//		}
//	}
	
}
