import java.io.*;
import java.util.*;

public class P1759{
	static int L, C;
	static char[] alpha;
	static char[] pwd;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		pwd = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		comb(0, 0);
		br.close();
	}
	static void comb(int cnt, int start) {
		if(cnt==L) {
			if(check(pwd)) {
				System.out.println(String.valueOf(pwd));
			}
			return;
		}
		for(int i=start; i<C; i++) {
			pwd[cnt] = alpha[i];
			comb(cnt+1, i+1);
		}
	}
	//password 가능한지 check
	static boolean check(char[] pwd) {
		int jaeum = 0;
		int moeum = 0;
		for(int i=0; i<pwd.length; i++) {
			if(pwd[i]=='a'||pwd[i]=='e'||pwd[i]=='i'||pwd[i]=='o'||pwd[i]=='u') moeum++;
			else jaeum++;
		}
		//모음 최소 1개, 자음 최소 2개
		if(jaeum >= 2 && moeum >=1) return true;
		else return false;
	}
}

/*
a c i s t w
a c i s
a c i t
a c i w
a c s t
*/