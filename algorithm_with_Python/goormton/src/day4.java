import java.io.*;
import java.util.*;

public class day4 {
	static int N, id, taste, max;;
	static int[] input;	//입력
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		taste = max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			input[i] = Integer.parseInt(st.nextToken());
			//제일 큰 수가 나올 때까지 갱신
			if(max < input[i]){
				max = input[i];
			}
			//갱신이 더이상 이뤄지지 않는다면, 가장 큰 수 기준으로 감소해야함
			else {
				if(input[i]>input[i-1]) {
					System.out.println(0);
					return;
				}
			}
			taste += input[i];
		}
	
		System.out.println(taste);
		br.close();
	}
}