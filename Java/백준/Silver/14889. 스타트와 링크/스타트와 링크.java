import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int [][] arr;
	static boolean [] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(result);
	}
	
	static void dfs(int t, int count) {
		//팀 조합 완성될 경우
		if(count == N/2) {
			diff();
			return;
		}
		
		for(int i=t; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, count+1);
				visited[i] = false;
			}
		}
	}
	
	static void diff() {
		int team_start = 0;
		int team_link = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				//true면 스타트팀
				if(visited[i]==true&&visited[j]==true) {
					team_start += arr[i][j] + arr[j][i];
				}
				//flase면 링크팀
				if(visited[i]==false&&visited[j]==false) {
					team_link += arr[i][j] + arr[j][i];
				}
			}
		}
		
		int val = Math.abs(team_start-team_link);
		
		if(val==0) { //차이가 0이면 최소값이므로 종료
			System.out.println(val);
			System.exit(0);
		}
		
		result = Math.min(result, val);
	}

}