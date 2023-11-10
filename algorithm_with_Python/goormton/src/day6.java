import java.io.*;
import java.util.*;
public class day6 {
	static int N, max;
	static ArrayList<String[]> word;
	static Set<String> P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		word = new ArrayList<>();
		P = new HashSet<>();
		for(int i=1; i<N; i++){
			for(int j=i+1; j<N; j++){
				String a = input.substring(0, i);
				String b = input.substring(i, j);
				String c = input.substring(j);
				word.add(new String[]{a, b, c});
				P.add(a);
				P.add(b);
				P.add(c);
			}
		}
		List<String> Plist = new ArrayList<>(P);
		Collections.sort(Plist);
		
		Map<String, Integer> score = new HashMap<>();
		for(int i=0; i<Plist.size(); i++){
			score.put(Plist.get(i), i+1);
		}
		
		max = -1;
		for(String[] cur : word) {
			int tmp = 0;
			for(String str : cur){
				tmp += score.get(str);
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);
	}
}