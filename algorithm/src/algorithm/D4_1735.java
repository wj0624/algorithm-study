package algorithm;
import java.io.*;
import java.util.*;

public class D4_1735{
	static int a, b, c, d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int e = a*d+c*b;
		int f = b*d;
		
		int gcd = getGcd(e, f);
		
		sb.append(e/gcd+" ");
		sb.append(f/gcd);
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	static int getGcd(int x, int y) {
		int r;
		while(y>0) {
			r = x%y;
			x = y;
			y = r;
		}
		return x;
	}
}