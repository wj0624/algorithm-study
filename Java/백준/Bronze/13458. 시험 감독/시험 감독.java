import java.io.*;
import java.util.*;

public class Main {
	static int N, B, C;
	static long answer;
	static int [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		//입력 끝
		
		answer += N; //총감독관은 시험장 마다 1명씩 있어야함
		for(int i=0; i<N; i++) {
			arr[i] -= B;
			if(arr[i] <= 0) continue; //총감독관만 있어도 되면 무시
			answer += arr[i]/C;
			if(arr[i]%C != 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
