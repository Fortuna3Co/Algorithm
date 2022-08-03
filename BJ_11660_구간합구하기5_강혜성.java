package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_강혜성 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[N + 1][N + 1];
		// 누적 합
		int[][] accumulate = new int[N + 1][N + 1];

		for (int ny = 1; ny < N + 1; ++ny) {
			st = new StringTokenizer(br.readLine());
			for (int nx = 1; nx < N + 1; ++nx) {
				matrix[ny][nx] = Integer.parseInt(st.nextToken());
				accumulate[ny][nx] = matrix[ny][nx] + accumulate[ny][nx - 1] + accumulate[ny - 1][nx] - accumulate[ny - 1][nx - 1];
			}
		}


		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
					x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			
			int sum = accumulate[x2][y2] - accumulate[x2][y1-1] - accumulate[x1-1][y2] + accumulate[x1-1][y1-1];
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
