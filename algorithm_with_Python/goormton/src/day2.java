import java.io.*;
import java.util.*;

//프로젝트 매니징
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
			//입력된 시간(분단위) 더해주기
//			if(time+ans_m<60) {
//				ans_m += time;
//			}
//			else {
				ans_h += time/60;
				ans_m += time%60;
//			}
			
			//더하고 난 후 시간 다시 한 번 계산
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