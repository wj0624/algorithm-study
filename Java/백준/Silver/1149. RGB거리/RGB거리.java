import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int arr[][], dp[][];
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][3];
		dp = new int [N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				if(j == 0) {
					dp[i][j] = Math.min(dp[i-1][1]+arr[i][j], dp[i-1][2]+arr[i][j]);
				}
				else if(j == 1) {
					dp[i][j] = Math.min(dp[i-1][0]+arr[i][j], dp[i-1][2]+arr[i][j]);
				}
				else {
					dp[i][j] = Math.min(dp[i-1][0]+arr[i][j], dp[i-1][1]+arr[i][j]);
				}
			}
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}

}
