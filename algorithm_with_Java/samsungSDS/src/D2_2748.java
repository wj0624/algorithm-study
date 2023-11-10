import java.io.*;
import java.util.*;

public class D2_2748 {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(fibonacci(n)));
		
		br.close();
		bw.close();
	}
	//런타임 에러 왜일까? => index 확인! 0부터 시작
	static long fibonacci(int N) {
		long [] fibo = new long[N+2];	//int에서 long으로 변경
		fibo[0] = 0;
		fibo[1] = fibo[2] = 1;
		for(int i=3; i<=N; i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		return fibo[N];
	}
}
