package algorithm;

import java.io.*;
import java.util.*;

public class P2003 {
	static int N, M, lp, rp, sum, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lp = rp = sum = ans = 0;
		
		while(true) {
			if(sum<M) {
				if(rp==N) {
					break;
				}
				sum += arr[rp];
				rp++;
			}
			else {
				sum -= arr[lp];
				lp++;
			}
			if(sum==M) {
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}

}
