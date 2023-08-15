import java.io.*;
import java.util.*;

//운동 중독 플레이어
public class day1 {
	static double W, R;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Double.parseDouble(st.nextToken());
		R = Double.parseDouble(st.nextToken());
		
		//double끼리 연산할 때는 숫자도 소숫점으로 나타내어야 함
		//int로 casting하면 소숫점이하 버림
		ans = (int) ((1+R/30.0)*W);
		
		System.out.println(ans);
		br.close();
	}
}