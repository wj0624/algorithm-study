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
		
		//1.�Է�
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		ArrayDeque<info> dq = new ArrayDeque<>();
	
		st = new StringTokenizer(br.readLine());
		
		int input;
		
		//2.�Է� �����鼭 �������� ����
		for(int i=0;i<n;i++) {
			input = Integer.parseInt(st.nextToken());
			
			//1)deque�� ù��° ������ id�� i-l ���� �۴ٸ�
			// -> id �������� ������ ���� ����
			if(!dq.isEmpty() && dq.getFirst().id <= i-l) {
				dq.pollFirst();
			}
			//2)deque�� first���ڸ� �ּڰ����� �����
			//  deque�� last���� ���� (��� input�� ���� ��)
			//  -> id �������� ������ ���� ����
			while(!dq.isEmpty() && dq.getLast().val >= input) {
				dq.pollLast();
			}
			//3)��� input�� ���� ���߿� �ּڰ��� �� ���� �����Ƿ� ������ �ֱ�
			dq.addLast(new info(i, input));
			
			//���� deque�� first���� �ּڰ��� ������
			sb.append(dq.getFirst().val+" ");
		}
		sb.append("\n");
		bw.write(sb.toString());
		
		//�ð��ʰ� �߻� => ����ġ�� �ʿ�! ��� �ұ�?
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
