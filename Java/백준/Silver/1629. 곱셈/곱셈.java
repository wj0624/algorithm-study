import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		
		long ans = func(a, b, c);

		
		System.out.println(ans);
	}
	
	static long func(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a % c;
		}
		else if(b % 2 == 0) {
			long tmp = func(a, b/2, c);
			return ((tmp % c) * (tmp % c)) % c;
		}
		else {
			long tmp = func(a, (b-1)/2, c);
			//return ((tmp % c) * (tmp % c) * (a %c)) % c;
			return ((tmp *tmp) % c * a) % c;
		}

	}
}
