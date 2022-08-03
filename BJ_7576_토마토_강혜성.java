package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_7576_토마토_강혜성 {

	// 주변에 익은 토마토가 있을 경우 1, 없을 경우 0;
	private static int isRipe(int[][][] tomatos, int y, int x, int h) {

		int[] dx = { 1, -1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 }, dh = {0, 0, 0, 0, 1, -1}; // 사방 검색 + 위, 아래

		for (int d = 0; d < dx.length; ++d) {
			int nx = x + dx[d], ny = y + dy[d], nh = h + dh[h];

			if (0 <= nx && nx < tomatos[0].length && 0 <= ny && ny < tomatos.length) {
				if (tomatos[h][y][x] == 0 && tomatos[nh][ny][nx] == 1)
					return 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int M = Integer.parseInt(line[0]), N = Integer.parseInt(line[1]), H = Integer.parseInt(line[2]);

		int[][][] tomatos = new int[H][N][M];

		for (int h = 0; h < H; ++h) {
			for (int n = 0; n < N; ++n) {
				line = br.readLine().split(" ");
				for (int m = 0; m < M; ++m) {
					tomatos[h][n][m] = Integer.parseInt(line[m]);
				}
			}
		}

		int day = 0;
		while (true) {
			boolean flag = true;
			int tomatoCount = 0;

			// deepcopy
			int[][][] temp = new int[H][N][M];
			for(int h = 0; h < H; ++h) {
				for (int n = 0; n < N; ++n) {
					temp[h][n] = Arrays.copyOf(tomatos[h][n], tomatos[h][n].length);
				}
			}
			for(int h = 0; h < H; ++h) {
				for (int y = 0; y < tomatos.length; ++y) {
					for (int x = 0; x < tomatos[y].length; ++x) {
						if (isRipe(tomatos, y, x, h) == 1) {
							temp[h][y][x] = 1;
							flag = false;
						}
						if (tomatos[h][y][x] != 0)
							tomatoCount += 1;
					}
				}
			}

			tomatos = temp;
			for(int[][] h : tomatos)
				for (int[] t : h) {
					for (int x : t)
						System.out.print(x + " ");
					System.out.println();
				}
			System.out.println();

			if (tomatoCount == M * N) { // 안익은게 없는 경우
				System.out.println(day);
				return;
			} else if (flag) { // 안 익은게 있고 바뀐게 없는 경우
				System.out.println(-1);
				return;
			}

			day += 1;
		}

	}
}
