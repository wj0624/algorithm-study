import java.io.*;
import java.util.*;

public class P1072{
	static long X, Y, Z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		Z = Y*100/X;
		//99%, 100% 일 때는 값이 더 이상 변하지 않음
		if(Z>=99) {
			System.out.println(-1);
			return;
		}
		//이분탐색
		long start = 1;
		long end = X;
		long mid = 0;
		while(start<end) {
			mid = (start+end)/2;
			long tmpZ = (Y+mid)*100/(X+mid);
			if(tmpZ>Z) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(end);
		br.close();
	}
}