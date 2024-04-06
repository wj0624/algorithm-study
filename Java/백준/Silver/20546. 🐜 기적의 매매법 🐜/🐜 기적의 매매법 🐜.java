import java.io.*;
import java.util.*;

public class Main {
	static int jh, sm, jhCnt, smCnt = 0;
	static int [] info = new int[14];
	static int yesterday = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		jh = sm = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int upCnt = 0;
		int downCnt = 0;
		for(int i=0; i<14; i++) {
			info[i] = Integer.parseInt(st.nextToken());
			//준현 : 주가가 보유 현금보다 낮으면 무조건 최대한 매수
			if(info[i] <= jh) {
				jhCnt += jh / info[i];
				jh -= info[i]*jhCnt;
			}
			
			//성민 : 3연속 상승 -> 매도, 3연속 하락 -> 매수
			if(i==0) { //첫째날은 넘기자
				yesterday = info[i];
				continue;
			}
			else {
				//가격 상승
				if(info[i]>yesterday) {
					upCnt++;
					downCnt = 0;
				}
				else if(info[i]<yesterday){
					downCnt++;
					upCnt = 0;
				}
				yesterday = info[i];
			}
			
			//3일연속 상승
			if(upCnt >= 3 && info[i] <= sm) {
				sm += info[i] * smCnt;
			}
			if(downCnt >= 3 && info[i] <= sm) {
				smCnt += sm / info[i];
				sm -= info[i]*smCnt;
			}
		}
		
		int jhAsset = jh + info[13] * jhCnt;
		int smAsset = sm + info[13] * smCnt;
		
		if(jhAsset>smAsset) {
			System.out.println("BNP");
		}
		else if(jhAsset<smAsset) {
			System.out.println("TIMING");
		}
		else {
			System.out.println("SAMESAME");
		}
		
	}
}
