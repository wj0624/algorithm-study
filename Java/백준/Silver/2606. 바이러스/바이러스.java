import java.io.*;
import java.util.*;
public class Main {
	static int N, L;
	static int [][] arr;
	static boolean [] visited;
	static int ans=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		L = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(ans-1);
	}
	private static void dfs(int st) {
		visited[st] = true;
		ans++;
		
		for(int i=0; i<=N; i++) {
			if(arr[st][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
