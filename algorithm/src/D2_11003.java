import java.io.*;
import java.util.*;
public class D2_11003 {
	static class info{
		public int id;
		public int val;
		info(int id, int val) {
			this.id = id;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//1.입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		ArrayDeque<info> dq = new ArrayDeque<>();
	
		st = new StringTokenizer(br.readLine());
		
		int input;
		
		//2.입력 받으면서 투포인터 실행
		for(int i=0;i<n;i++) {
			input = Integer.parseInt(st.nextToken());
			
			//1)deque의 첫번째 숫자의 id가 i-l 보다 작다면
			// -> id 기준으로 오래된 숫자 제거
			if(!dq.isEmpty() && dq.getFirst().id <= i-l) {
				dq.pollFirst();
			}
			//2)deque의 first숫자를 최솟값으로 만들기
			//  deque의 last부터 제거 (방금 input된 값과 비교)
			//  -> id 기준으로 오래된 숫자 제거
			while(!dq.isEmpty() && dq.getLast().val >= input) {
				dq.pollLast();
			}
			//3)방금 input된 값이 나중에 최솟값이 될 수도 있으므로 무조건 넣기
			dq.addLast(new info(i, input));
			
			//현재 deque의 first값은 최솟값을 보장함
			sb.append(dq.getFirst().val+" ");
		}
		sb.append("\n");
		bw.write(sb.toString());
		
		//시간초과 발생 => 가지치기 필요! 어떻게 할까?
//		minval[0] = arr[0];
//		bw.write(String.valueOf(minval[0])+" ");
//		
//		for(int i=1;i<n;i++) {
//			if (i-l+1<=0){
//				if(arr[i] > minval[i-1]) minval[i] = minval[i-1];
//				else minval[i] = arr[i];
//				bw.write(String.valueOf(minval[i])+" ");
//			}
//			else {
//				minval[i] = arr[i-l+1];
//				for(int j=i-l+1;j<=i;j++) {
//					if(arr[j] < minval[i]) minval[i] = arr[j];
//					else minval[i] = minval[j];
//				}
//				bw.write(String.valueOf(minval[i])+" ");
//			}
//		}
		br.close();
		bw.flush();
		bw.close();
	}
}
