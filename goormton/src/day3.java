import java.io.*;
import java.util.*;

//합 계산기
class day3{
	static int T, x, y, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		ans = 0;
		for(int i=0; i<T; i++) {
			//input 공백으로 구분하여 String 배열에 입력
			String[] in = br.readLine().split(" ");
			//in[1] : 연산자
			switch(in[1]) {
			case "+" :
				x = Integer.parseInt(in[0]);
				y = Integer.parseInt(in[2]);
				ans += x + y;
				break;
			case "-" :
				x = Integer.parseInt(in[0]);
				y = Integer.parseInt(in[2]);
				ans += x - y;
				break;
			case "*" :
				x = Integer.parseInt(in[0]);
				y = Integer.parseInt(in[2]);
				ans += x * y;
				break;
			case "/" :
				x = Integer.parseInt(in[0]);
				y = Integer.parseInt(in[2]);
				ans += x / y;
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
}