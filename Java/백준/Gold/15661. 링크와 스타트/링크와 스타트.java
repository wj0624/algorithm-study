import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int [][] arr;	// 능력치 저장
	static boolean [] visited;	// 스타트팀으로 선택된 팀원 
	static int ans = Integer.MAX_VALUE;	//결과
	static int start, link;	// 각 팀 능력치 합
	
	public static void main(String[] args) throws Exception, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 팀 조합 만들기
		dfs(0, 0);
		
		// 출력
		System.out.println(ans);
	}

	private static void dfs(int idx, int cnt) {
		if(cnt > 0) {	// 선택된 팀원, 1명 이상 N-1 미만
			diff();	// 능력치 차이 계산
		}
		
		if(cnt==N-1) {
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}

	private static void diff() {
		start = link = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				// visited가 true면 start팀
				if(visited[i]&&visited[j]) {
					start += arr[i][j] + arr[j][i];
				}
				
				// visited가 false면 link팀
				else if((!visited[i])&&(!visited[j])) {
					link += arr[i][j] + arr[j][i];
				}
			}
		}
		
		// 차이 계산
		int diff = Math.abs(start-link);
		
		// 차이가 0이면 무조건 최소값이므로 출력 후 종료
		if(diff==0) {
			System.out.println(diff);
			System.exit(0);
		}
		
		// 차이 최소값 계산하기
		ans = Math.min(ans, diff);
	}	
}
