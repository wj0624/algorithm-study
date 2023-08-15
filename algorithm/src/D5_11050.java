import java.io.*;
import java.util.*;

public class D5_11050 {
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//nCk = n! / ( k! * (n-k)!)
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] facList = new int[n+1];

		System.out.println(factorial(n) / (factorial(k) * factorial(n-k)));
		br.close();
	}

	static int factorial(int num) {
		if(num <= 1) return 1;
		return num * factorial(num-1);
	}
}
