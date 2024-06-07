import java.io.*;
import java.util.*;
public class Main {
	static int N, S, ans=0;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(S==0 ? ans-1 : ans);
	}
	
	private static void dfs(int id, int sum) {
		if(id == N) {
			if(sum == S) ans++;
			return;
		}
		dfs(id+1, sum+arr[id]);
		dfs(id+1, sum);
	}
}
