import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [][] arr;
	static int startTeam, linkTeam;
	static int result = Integer.MAX_VALUE;
	static boolean [] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean [N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(result);
		
	}
	
	//팀 조합 만들기
	static void dfs(int t, int count) {
		//탈출조건
		if(count==N/2) { //팀조합이 완성됐다면
			diff();
			return;
		}
		
		for(int i=t; i<N; i++) {//t부터 시작
			if(!visited[i]) {
				visited[i] = true;	//방문 됐다면 true로 처리하고
				dfs(i+1, count+1);
				visited[i] = false; //다시 false로
			}
		}
	}
	
	static void diff() {
		startTeam = 0;
		linkTeam = 0;
		
		//팀별로 능력치 합 구하기
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				//visited가 true면 startTeam으로 분류
				if(visited[i]&&visited[j]) {
					startTeam += arr[i][j] + arr[j][i];
				}
				//visited가 false면 linkTeam으로 분류
				else if((!visited[i])&&(!visited[j])) {
					linkTeam += arr[i][j] + arr[j][i];
				}
			}
		}
		
		//두 팀간의 능력치 차이 구하기
		int diff = Math.abs(startTeam-linkTeam);
		
		if(diff==0) { //차이가 0이면 무조건 최소값이므로 종료
			System.out.println(diff);
			System.exit(0);
		}
		
		//이전에 구한 값과 비교하여 최소값을 result에 저장
		result = Math.min(result, diff);
	}

}
