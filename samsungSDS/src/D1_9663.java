import java.io.*;
import java.util.*;

public class D1_9663 {
	static int N, ans;
	static int [] xLoc = new int[16];	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		nQueen(0);
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void nQueen(int y) {
		//Ż������
		if (y==N) {	//���� �� �δµ� ����
			ans++;
			return;
		}
		
		//i�� j��
		for(int j=0; j<N; j++) {
			boolean isPossible = true;
			for(int i=0;i<y;i++) {
				//�ȵǴ� ��� ����� ��
				//1)���� ���� �����ϴ� ���
				if( xLoc[i] == j ||
						//2) ���� �� �밢���� ����
						(xLoc[i] - (y-i) == j) ||
						//3) ������ �� �밢���� ����
						(xLoc[i] + (y-i) == j)) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				xLoc[y] = j;
				nQueen(y+1);
			}
		}
	}
}