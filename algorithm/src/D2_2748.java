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
	//��Ÿ�� ���� ���ϱ�? => index Ȯ��! 0���� ����
	static long fibonacci(int N) {
		long [] fibo = new long[N+2];	//int���� long���� ����
		fibo[0] = 0;
		fibo[1] = fibo[2] = 1;
		for(int i=3; i<=N; i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		return fibo[N];
	}
}
