import java.io.*;
import java.util.*;

public class Main {
	static int maxi = Integer.MIN_VALUE;
	static int mini = Integer.MAX_VALUE;
	static int N;
	static int [] arr;
	static int [] operator = new int[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);
		
		System.out.println(maxi);
		System.out.println(mini);
	}
	static void dfs(int num, int idx) {
		//종료조건
		if(idx==N) {
			//최소값, 최대값 구하기
			mini = Math.min(mini, num);
			maxi = Math.max(maxi, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i]>0) { //연산자 개수가 1개 이상인 경우
				operator[i]--; //사용
				
				switch(i) {
				case 0: //더하기 +
					dfs(num+arr[idx], idx+1);
					break;
				case 1: //빼기 -
					dfs(num-arr[idx], idx+1);
					break;
				case 2: //곱하기 *
					dfs(num*arr[idx], idx+1);
					break;
				case 3: // 나누기 /
					dfs(num/arr[idx], idx+1);
					break;
				}
				
				operator[i]++; //다시 채워넣기
			}
		}
	
	}
}
