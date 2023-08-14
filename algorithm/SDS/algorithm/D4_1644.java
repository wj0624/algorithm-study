package algorithm;
import java.io.*;
import java.util.*;

public class D4_1644 {
	
	static final int MAXSIZE = 4_000_000;
	static boolean[] isNotPrime = new boolean[MAXSIZE];
	static ArrayList<Integer> plist = new ArrayList<Integer>();
	static int n;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(0);
			return;
		}
		
		//에라토스테네스의 체(소수 구하기)
		for(int i=2;i*i<MAXSIZE;i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i;j<MAXSIZE;j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		//n보다 작은 소수 리스트 만들기
		plist.add(2);
		for(int i=3; i<=n; i+=2) {
			if(!isNotPrime[i]) plist.add(i);
		}
		
		//누적합을 이용한 투포인터
		
		
		

	}
	
	static void primeNum() {
		
	}
}
