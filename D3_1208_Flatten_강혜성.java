package Day_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class D3_1208_Flatten_강혜성 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 가로 길이는 항상 100
		// 모든 위치에서 상자의 높이는 1이상 100 이하
		int width = 100;
		
		// 테스트 케이스는 총 10개
		int T = 10;
		for(int t = 1; t <= T; ++t) {
			
			// PriortyQueue를 이용하면 성능이 더 좋아질거라 판단
			// 하나는 숫자가 크면 우선순위를 갖는 PriorityQueue => pq
			// 다른 하나는 숫자가 작으면 우선순위를 갖는 PriorityQueue를 생성 => pqTemp
			// 다음과 같이 수행
			// 1. pq.add(pq.poll() -1)
			// 2. pqTemp (pqTemp.poll() + 1)
			// 3. dump 번 반복
			// 출력 시 pq.peek() - pqTemp.peek() 실행
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> pqTemp = new PriorityQueue<>();
			
			int dump = Integer.parseInt(br.readLine());
			String[] Line = br.readLine().split(" ");
			
			for(int l = 0; l < Line.length; ++l) {
				pq.add(Integer.parseInt(Line[l]));
				pqTemp.add(Integer.parseInt(Line[l]));
			}
			
			int count = 0;
			for(int d = 0; d < dump; ++d) {
				pq.add(pq.poll() - 1);
				pqTemp.add(pqTemp.poll() + 1);
			}
			
			System.out.println("#" + t + " " + (pq.peek() - pqTemp.peek()));
			
		}
		
	}
}
