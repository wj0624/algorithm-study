import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int [][] arr = new int [2][n];
			int [][] dp = new int [2][n+2];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			for(int i=2; i<n+2; i++) {
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + arr[0][i-2];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + arr[1][i-2];
			}
			
			System.out.println(Math.max(dp[0][n+1], dp[1][n+1]));
		}
	}

}
