import java.io.*;
import java.util.*;

class day2{
	static int N, T, M, time;
	static int ans_h, ans_m;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans_h = T;
		ans_m = M;
		
		for(int i=0; i<N; i++) {
			time = Integer.parseInt(br.readLine());
			if(time+ans_m<60) {
				ans_m += time;
			}
			else {
				ans_h += time/60;
				ans_m += time%60;
			}
			if(ans_m>=60) {
				ans_h += ans_m/60;
				ans_m = ans_m%60;
			}
			if(ans_h>=24) {
				ans_h -= 24;
			}
		}

		System.out.println(ans_h+" "+ans_m);
		br.close();
	}
}