import java.io.*;
import java.util.*;

public class P2143 {
	static int T, n, m;
	static int[] A, B;
	static List<Integer> subA, subB;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�Է�
		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		//�� �迭 ���ϱ�
		subA = new ArrayList<>();
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = 0;
			for(int j=i; j<n; j++) {
				sum += A[j];
				subA.add(sum);
			}
		}
		
		subB = new ArrayList<>();
		for(int i=0; i<m; i++) {
			sum = 0;
			for(int j=i; j<m; j++) {
				sum += B[j];
				subB.add(sum);
			}
		}
		
		//�ι迭 ����
		Collections.sort(subA);
		Collections.sort(subB);
		
		//��������
		int pa = 0;	//�ּڰ����� ����
		int pb = subB.size()-1;	//�ִ񰪺��� ����
		long ans = 0; 
		while(pa<subA.size()&&pb>=0) {//������ �ʰ����� �ʰ� ����
			int tmpA = subA.get(pa);
			int tmpB = subB.get(pb);
			if(tmpA+tmpB==T) {
				//���� ���� Ȯ��, int ���� �ʰ��� �� ������ long���� ����
				long cntA = 0;
				long cntB = 0;
				while(pa<subA.size() && subA.get(pa)==tmpA) {
					cntA++;
					pa++;
				}
				while(pb>=0 && subB.get(pb)==tmpB) {
					cntB++;
					pb--;
				}
				ans += cntA * cntB;
			}
			else if(tmpA+tmpB>T) {
				pb--;
			}
			else {
				pa++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}