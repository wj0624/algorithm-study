import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] basket = new int[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for(int j=s-1; j<e; j++) {
				basket[j] = num;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(basket[i]+" ");
		}
	}
}
