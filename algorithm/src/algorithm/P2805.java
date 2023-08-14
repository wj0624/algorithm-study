package algorithm;

import java.io.*;
import java.util.*;

public class P2805 {
	static int N, M, H;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		
		System.out.println(bSearch(0, tree[N-1]));
		br.close();
	}

	static int bSearch(int s, int e) {
		int ans = 0;
		int mid;
		while(s<=e) {
			mid = (s+e) / 2;
			
			H = 0;
			
			for(int i=0; i<N; i++) {
				if(tree[i] > mid) H += tree[i] - mid;
			}
			
			if(H == M) return mid;
			else if(H > M) {
				if(ans < mid) {
					ans = mid;
				}
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		return ans;
	}

}
