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
		
		//�Է�
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//1-1) sum < m, rp ������(rp < N�϶�)
		//1-2) sum >= m, lp ������
		//2) sum == m �̸� cnt ++
	
		while(true) {
			if(sum < m) {
				//Ż������
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