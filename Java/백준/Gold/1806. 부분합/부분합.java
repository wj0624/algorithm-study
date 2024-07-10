import java.io.*;
import java.util.*;

public class Main{
	static int N, S, sum;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(sol());
		br.close();
	}
	static int sol() {
		int lp = 0;
		int rp = 0;
		int sum = 0;
		while(lp<=rp && rp<=N)
		{
			if(sum<S) {
				sum += arr[rp++];
			}
			else if(sum>=S) {
				min = Math.min(min, rp-lp);
				sum -= arr[lp++];
			}
		}
		return min==Integer.MAX_VALUE ? 0 : min;
	}
}