import java.io.*;
import java.util.*;

public class Main {
	static int tc;
	static int [] T = new int[45];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		//삼각수 만들기 K가 1000이하 이므로 n=44 까지 가능
		for(int i=1; i<=44; i++) {
			T[i-1] = i*(i+1)/2;
		}
		
		for(int i=0; i<tc; i++) {
			int k = Integer.parseInt(br.readLine());
			if(Eureka(k))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	
	static boolean Eureka(int K) {
		for(int i=0; i<44; i++) {
			for(int j=0; j<44; j++) {
				for(int k=0; k<44; k++) {
					int sum = T[i]+T[j]+T[k];
					if(sum == K) return true;
				}
			}
		}
		return false;
	}
}
