import java.io.*;
import java.util.*;
class day5 {
	static class num implements Comparable<num>{
		int x;	//10진수
		int cnt;	//2진수에 포함된 1의 개수
		public num(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(num o){
			if(this.cnt==o.cnt){
				return o.x - this.x;
			}
			else {
				return o.cnt-this.cnt;
			}
		}
	}
	static int N, K;
	static ArrayList<num> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>(N+1);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			int input = Integer.parseInt(st.nextToken());
			String binary = Integer.toBinaryString(input);
			arr.add(new num(input, countOne(binary)));
		}
		Collections.sort(arr);
		System.out.println(arr.get(K-1).x);
		br.close();
	}
	static int countOne(String str){
		int ret = 0;
		for (int i = 0; i < str.length(); i++) {
    	if (str.charAt(i) == "1".charAt(0)) {
				ret++;
			}
		}
		return ret;
	}
}