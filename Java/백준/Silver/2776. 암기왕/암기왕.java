import java.io.*;
import java.util.*;

public class Main {
	static int T, N, M;
	static int [] note1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			note1 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(note1);
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int note2 = Integer.parseInt(st.nextToken());
				sb.append(binarySearch(note2)==1?1:0).append('\n');
			}
			System.out.print(sb);
		}
		
	}
	static int binarySearch(int note2) {
		int l = 0;
		int r = N-1;
		int mid;
		while(l<=r) {
			mid = (l+r)/2;
			if(note1[mid]==note2) {
				return 1;
			}
			else if(note1[mid]<note2) {
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		return 0;
	}
}
