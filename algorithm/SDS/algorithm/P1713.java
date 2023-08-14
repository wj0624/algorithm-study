package algorithm;

import java.io.*;
import java.util.*;

public class P1713 {
	static class info implements Comparable<info>{
		int id, cnt, time;

		public info(int id, int cnt, int time) {
			this.id = id;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(info o) {
			if(this.cnt == o.cnt) {
				return this.time - o.time;
			}
			else if(this.cnt < o.cnt) {
				return -1;
			}
			else return 1;
		}
	}
	static int N, M;
	static int[] student;
	static ArrayList<info> frame;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		student = new int[101];
		frame = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(student[in]>0) {
				student[in] += 1;
				for(int j=0; j<frame.size(); j++) {
					if(frame.get(j).id == in) {
						frame.get(j).cnt += 1;
						break;
					}
				}
			}
			else {
				if(frame.size()>=N) {
					Collections.sort(frame);
					int num = frame.get(0).id;
					student[num] = 0;
					frame.remove(0);
					frame.add(new info(in, 1, i));
					student[in] = 1;
				}
				else {
					frame.add(new info(in, 1, i));
					student[in] = 1;
				}
			}
		}
		
		Collections.sort(frame, Comparator.comparingInt(s->s.id));
		
		
		for(int i=0; i<frame.size(); i++) {
			System.out.print(frame.get(i).id+" ");
		}
		
		br.close();
	}
}
