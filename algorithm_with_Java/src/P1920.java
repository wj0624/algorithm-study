import java.io.*;
import java.util.*;

public class P1920{
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(x));
		}
		br.close();		
	}
	static int binarySearch(int x) {
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid] == x) {
				return 1;
			}
			else if(arr[mid] < x) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return 0;
	}
}