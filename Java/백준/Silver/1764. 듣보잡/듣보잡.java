import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				result.add(str);
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(String s : result) {
			System.out.println(s);
		}
	}
}