import java.io.*;
import java.util.*;

//� �ߵ� �÷��̾�
public class day1 {
	static double W, R;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Double.parseDouble(st.nextToken());
		R = Double.parseDouble(st.nextToken());
		
		//double���� ������ ���� ���ڵ� �Ҽ������� ��Ÿ����� ��
		//int�� casting�ϸ� �Ҽ������� ����
		ans = (int) ((1+R/30.0)*W);
		
		System.out.println(ans);
		br.close();
	}
}