package algorithm;
import java.io.*;
import java.util.*;

public class D2_2805 {
	
	static int[] tree;
	static int N, M;
	static long H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree); //배열 정렬
		
		bw.write(String.valueOf(binarySearch(0, tree[N-1])));
		
		br.close();
		bw.close();
		
		return;
	}
	
	static int binarySearch(int start, int end) {
		int mid;
		int ans = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			
			H = 0;
			
			for(int i=0; i<N; i++) {
				if(tree[i] > mid) H += tree[i]-mid;
			}
			if(H == M) return mid;
			else if(H > M) {
				if(ans < mid) {
					ans = mid;
				}
				start = mid + 1;
			}
			else end = mid - 1;
		}
		return ans;
	}
	
}
