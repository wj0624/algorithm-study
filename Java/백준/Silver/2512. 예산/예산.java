import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int budget [];
	static long M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		
		int l = 0, r = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			r = Math.max(r, budget[i]);
		}
		
		M = Integer.parseInt(br.readLine());

		while(l<=r) {
			int mid = (l+r)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(budget[i]>mid) sum += mid;
				else sum += budget[i];
			}
			if(sum<=M) {
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		System.out.println(r);
	}

}
