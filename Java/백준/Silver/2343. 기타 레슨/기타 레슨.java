import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [] lect;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lect = new int [N];
		
		int l = 0;
		int r = 0;
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<N; i++) {
			lect[i] = Integer.parseInt(st.nextToken());
			r += lect[i];
			l = Math.max(l, lect[i]);
		}

		while(l<=r) {
			int mid = (l+r)/2;
			int cnt = getCnt(N, mid);
			
			if (cnt>M) {
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
		
		System.out.println(l);
	}
	
	static int getCnt(int n, int mid) {
		int tmp = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			if(tmp + lect[i] > mid) {
				tmp = 0;
				count++;
			}
			tmp += lect[i];
		}
		if(tmp!=0) count++;
		return count;
	}

}
