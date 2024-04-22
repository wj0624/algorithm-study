import java.io.*;
import java.util.*;

public class Main {
	static int L, P, V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		while(true) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			if(L==0 && P==0 && V==0) {
				return;
			}
			ans = (V/P) * L;
			if(L>=(V%P)) {
				ans += V%P;
			}
			else {
				ans += L;
			}
			System.out.println("Case "+tc+": "+ans);
			tc++;
		}
	}
}
