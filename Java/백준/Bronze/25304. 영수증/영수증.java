import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		int n = sc.nextInt();
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum += sc.nextInt() * sc.nextInt();
		}
		
		System.out.println(sum==x?"Yes":"No");
	}

}
