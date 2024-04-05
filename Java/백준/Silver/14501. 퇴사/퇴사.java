import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int [][] schedule;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		schedule = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		//0일 부터 시작
		dfs(0, 0);
		
		System.out.println(result);
		
	}
	
	static void dfs(int idx, int pay) {
		if(idx>=N) {
			result = Math.max(pay, result);
			return;
		}
		
		if(idx+schedule[idx][0]<=N) {
			dfs(idx+schedule[idx][0], pay+schedule[idx][1]);
		}
		else {
			dfs(idx+schedule[idx][0], pay);
		}

		//이어서 상담하지 않고 날짜 건너뛰기
		dfs(idx+1, pay);
	}

}
