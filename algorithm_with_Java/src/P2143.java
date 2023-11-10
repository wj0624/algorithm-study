import java.io.*;
import java.util.*;

public class P2143 {
	static int T, n, m;
	static int[] A, B;
	static List<Integer> subA, subB;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력
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
		
		//부 배열 구하기
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
		
		//부배열 정렬
		Collections.sort(subA);
		Collections.sort(subB);
		
		//투포인터
		int pa = 0;	//최솟값부터 시작
		int pb = subB.size()-1;	//최댓값부터 시작
		long ans = 0; 
		while(pa<subA.size()&&pb>=0) {//범위가 초과되지 않게 설정
			int tmpA = subA.get(pa);
			int tmpB = subB.get(pb);
			if(tmpA+tmpB==T) {
				//동일 개수 확인, int 범위 초과할 수 있으니 long으로 선언
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