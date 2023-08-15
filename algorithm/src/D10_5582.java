import java.io.*;
import java.util.*;

public class D10_5582 {
	static int ans, cnt;
	static int[][] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String in1 = br.readLine();
		String in2 = br.readLine();
		
		int n = in1.length();
		int m = in2.length();
		
		str = new int[n+1][m+1];
		
		ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(in1.charAt(i-1) == in2.charAt(j-1)) {
					str[i][j] = str[i-1][j-1] + 1;
					ans = Math.max(ans, str[i][j]);
				}
			}
		}
			
		System.out.println(ans);
		br.close();
	}
}
/* DP
 * 2차원 배열로 생각. 입력된 문자열을 문자 한개씩 비교.
 * 왼쪽 위 대각선에 1이 있는지 확인. 있으면 +1
 * dp[i][j] = dp[i-1][j-1] + 1
 */
