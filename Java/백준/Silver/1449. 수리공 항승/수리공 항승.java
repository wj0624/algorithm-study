import java.io.*;
import java.util.*;
public class Main {
	static int N, L;
	static int [] arr;
	static int ans=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		double l = arr[0] - 0.5;
		double r = l+L;
		ans++;
		
		for(int i=1; i<N; i++) {
			if(l<=arr[i]-0.5 && arr[i]+0.5<=r) {
				continue;
			}
			else {
				ans++;
				l = arr[i] - 0.5;
				r = l+L;
			}
		}
		System.out.println(ans);
	}	
}