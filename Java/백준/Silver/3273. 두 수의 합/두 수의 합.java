import java.io.*;
import java.util.*;
public class Main {
	static int n, x, ans=0;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		x = Integer.parseInt(br.readLine());
		
		int l=0, r=n-1;
		while(l<r) {
			int sum = arr[l] + arr[r];
			if(sum >= x) {
				if(sum == x) {
					ans++;
				}
				r--;
			}
			else {
				l++;
			}
		}
		
		System.out.println(ans);
		
	}

}
