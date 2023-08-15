import java.io.*;
import java.util.*;

public class D5_2904 {
	static final int MAXSIZE = 1_000_000;
	static boolean[] isNotPn = new boolean[MAXSIZE];
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		

	}
	
	static void PrimeNumber(int n) {
		//1,000,000 ���� �Ҽ� ���� üũ
		int cnt = 0;
		//�����佺�׳׽��� ü
		for(int i=2; i*i<MAXSIZE;i++) {
			if(!isNotPn[i]) {
				for(int j=i*i;j<MAXSIZE;j+=i) {
					isNotPn[j] = true;
					cnt++;
				}
			}
		}
	}
	
	static int gcd(int a, int b) {
		while(b>0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	

}
