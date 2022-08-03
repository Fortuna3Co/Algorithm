package Day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1594_달팽이숫자_강혜성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			int xIndex = 0, yIndex = 0, count = 1;
			char direction = 'd';

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			for (int index = 0; index < N; ++index) {
				arr[0][index] = count++;
			}
			
			xIndex = N - 1;
			yIndex = 0;
			for (int i = N - 1; i >= 0; --i) {
				for (int x = 0; x < 2; ++x) {
					if (direction == 'd') {
						direction = 'l';
						while (yIndex + 1 < N && arr[yIndex + 1][xIndex] == 0) {
							arr[++yIndex][xIndex] = count++;
						}
					} else if (direction == 'l') {
						direction = 'u';
						while(xIndex - 1 >= 0 && arr[yIndex][xIndex - 1] == 0) {
							arr[yIndex][--xIndex] = count++;
						}
					} else if (direction == 'u') {
						direction = 'r';
						while(yIndex - 1 >= 0 && arr[yIndex - 1][xIndex] == 0) {
							arr[--yIndex][xIndex] = count++;
						}
					} else if (direction == 'r') {
						direction = 'd';
						while(xIndex + 1 < N && arr[yIndex][xIndex + 1] == 0) {
							arr[yIndex][++xIndex] = count++;
						}
					}
				}
			}

			System.out.println("#"+t);
			for (int[] ar : arr) {
				for (int a : ar)
					System.out.print(a + " ");
				System.out.println();
			}

		}

	}
}
