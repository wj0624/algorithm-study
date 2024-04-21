import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> card = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			 int key = Integer.parseInt(st.nextToken());
			 card.put(key, card.getOrDefault(key, 0)+1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int tgt = Integer.parseInt(st.nextToken());
			sb.append(card.getOrDefault(tgt, 0)).append(' ');
		}
		System.out.println(sb);
	}
}
