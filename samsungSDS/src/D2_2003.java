import java.io.*;
import java.util.*;

public class D2_2003 {
	static int n, m, cnt, sum, lp, rp;
	static int [] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = sum = lp = rp = 0;
		 
		A = new int[n];
		
		//입력
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//1-1) sum < m, rp 앞으로(rp < N일때)
		//1-2) sum >= m, lp 앞으로
		//2) sum == m 이면 cnt ++
	
		while(true) {
			if(sum < m) {
				//탈출조건
				if(rp==n) break;
				sum += A[rp];
				rp++;
			}
			else {
				sum -= A[lp];
				lp++;
			}
			if(sum == m) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}