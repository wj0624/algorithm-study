import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int [] sum = new int[N-X+1];
		int max = 0, cnt = 0;
		for(int i=0; i<N-X+1; i++) {
			sum[i] = arr[i+X] - arr[i];
		}
		
		for(int i=0; i<sum.length; i++) {
			if(sum[i] > max) {
				max = sum[i];
			}
		}
		
		for(int i=0; i<sum.length; i++) {
			if(max == sum[i]) cnt++;
		}		
		
		if(max==0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
