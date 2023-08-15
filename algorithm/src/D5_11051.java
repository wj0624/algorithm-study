import java.io.*;
import java.util.*;

public class D5_11051 {
	static final int modnum = 10_007;
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		int [][] comb = new int[n+1][n+1];
		
		//comb[0][0] = comb[1][0] = comb[1][1] = 1;
		
		for(int i=0; i<=n; i++) {
			comb[i][0] = comb[i][i] = 1;
		}

		//ÆÄ½ºÄ®ÀÇ »ï°¢Çü ÀÌ¿ë
		for(int i = 1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				//nCk = n-1Ck-1 + n-1Ck
				comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % modnum;
			}
		}
		
		System.out.println(comb[n][k]);
		br.close();
	}
}
//	static int factorial(int num) {
//		if(num <= 1) return 1;
//		return num * factorial(num-1);
//	}