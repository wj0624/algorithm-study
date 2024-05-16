import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[3];
		int sum = 0;
		
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[0]==arr[1] && arr[1]==arr[2]) {
			sum = 10000 + arr[0]*1000;
		}
		else if(arr[0]==arr[1]||arr[0]==arr[2]||arr[1]==arr[2]) {
			if(arr[0]==arr[1] || arr[0]==arr[2]) {
				sum = 1000 + arr[0]*100;
			}
			else if(arr[1]==arr[2]) {
				sum = 1000 + arr[1]*100;
			}
		}
		else {
			Arrays.sort(arr);
			sum = arr[2]*100;
		}
		
		System.out.println(sum);
		
	}

}
