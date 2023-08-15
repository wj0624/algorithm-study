import java.io.*;
import java.util.*;

public class D5_1010 {
	static int t, n, m;
	static int[][] comb = new int[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb.append(combination(m,n)+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static int combination(int x, int y) {
		for(int i=0; i<=x; i++) {
			comb[i][0] = comb[i][i] = 1;
		}
		//ÆÄ½ºÄ®ÀÇ »ï°¢Çü ÀÌ¿ë
		for(int i=1; i<=x; i++) {
			for(int j=1; j<i; j++) {
				//nCk = n-1Ck-1 + n-1Ck
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		return comb[x][y];
	}

}
