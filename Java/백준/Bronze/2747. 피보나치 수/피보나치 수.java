import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(fibonacci(N)));
		
		br.close();
		bw.close();
	}
	
	static long fibonacci(int n) {
		long [] fibo = new long[n+2];
		fibo[0] = 0;
		fibo[1] = fibo[2] = 1;
		for(int i=3; i<=n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		return fibo[n];
	}
}
