package Day_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D4_1210_Ladder1_강혜성 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 10개 // 크기 100
		int T = 10, N = 100;
		for(int t = 0; t < T; ++t) {
			int testcase = Integer.parseInt(br.readLine());
			int[][] ladder = new int[N][N];
			
			for(int y = 0; y < N; ++y) {
				String[] line = br.readLine().split(" ");
				for(int x = 0; x < N; ++x) {
					ladder[y][x] = Integer.parseInt(line[x]);
				}
			}
			
			// 주석 처리 부분은 위에서부터 순차적으로 처리하는 코드임
			
			// 실제 동작 코드는 아래에서 2(도착지점)를 찾은 후
			// 역으로 올라가서 index를 구하는 방식
			
			
//			int answer = 0;
//			for(int x = 0; x < N; ++x) {
//				if (ladder[0][x] == 1 && isGoal(ladder, x) == 1)
//					answer = x;
//			}
//			
//			System.out.println("#" + testcase + " " + answer);
			
			int answer = 0;
			for(int x = 0; x < N; ++x) {
				if (ladder[ladder.length - 1][x] == 2) {
					answer = isGoal(ladder, x);
					break;
				}
			}
			System.out.println("#" + testcase + " " + answer);
			
		}
	}
	
	public static int isGoal(int[][] ladder, int x) {
		
		// 왼쪽, 오른쪽의 경우 한번만 수행해야 하기 때문에 if, else if 구문으로 처리
		// if, if일 경우 왼쪽으로 간 경우 다시 오른쪽으로 돌아가게 됨
		for(int y = ladder.length - 1; y >= 0; --y) {
			if (x - 1 >= 0 && ladder[y][x-1] == 1) {	// 왼쪽으로 갈 수 있는 경우
				while(x - 1 >= 0 && ladder[y][x-1] == 1) {
					x -= 1;
				}
			}
			else if (x + 1 < ladder[y].length && ladder[y][x+1] == 1) {	// 오른쪽
				while (x + 1 < ladder[y].length && ladder[y][x+1] == 1) {
					x += 1;
				}
			}
		}
		
		return x;
	}
	
//	public static int isGoal(int[][] ladder, int x) {
//		
//		// 양 옆 갈 곳이 없는 경우 아래로 내려가기
//		// 갈 곳이 있는 경우 갈 수 있는 곳 까지 가기
//		
//		for(int y = 0; y < ladder.length; ++y) {
//			if (x - 1 >= 0 && ladder[y][x-1] == 1) {	// 왼쪽으로 갈 수 있는 경우
//				while(x - 1 >= 0 && ladder[y][x-1] == 1) {
//					x -= 1;
//				}
//			}
//			else if (x + 1 < ladder[y].length && ladder[y][x+1] == 1) {	// 오른쪽
//				while (x + 1 < ladder[y].length && ladder[y][x+1] == 1) {
//					x += 1;
//				}
//			}
//			
//			if (ladder[y][x] == 2)
//				return 1;
//		}
//
//		
//		
//		return 0;
//	}
}
