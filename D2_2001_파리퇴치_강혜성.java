package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치_강혜성 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
			
			
			int[][] matrix = new int[M][M];
			
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxValue = 0;
			for (int r = 0; r < M - N + 1; ++r) {
				for(int c = 0; c < M - N + 1; ++c) {
					int sum = 0;
					for(int x = 0; x < N; ++x) {
						for(int y = 0; y <N; ++y) {
							sum += matrix[r+y][c+x];
						}
					}
					maxValue = Math.max(maxValue, sum);
				}
			}

			System.out.println("#"+ t + " " + maxValue);
		}
	}
}
