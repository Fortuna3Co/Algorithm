package Day_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기_강혜성 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			
			for (int n = 0; n < N; ++n) {
				String line = br.readLine();
				for(int x = 0; x < N; ++x) {
					farm[n][x] = line.charAt(x) - '0';
				}
			}
			
			int sum = 0;
			for(int y = 0; y < N / 2 + 1; ++y) {
				for(int index = 0; index < y + 1; ++index) {
					if (index == 0)
						sum += farm[y][(N / 2) + index];
					else {
						sum += farm[y][(N / 2) + index];
						sum += farm[y][(N / 2) - index];
					}
				}
			}
			
			for(int y = N / 2 - 1; y >= 0; --y) {
				for(int index = y; index >= 0; --index){
					if (index == 0)
						sum += farm[N - y - 1][(N / 2) + index];
					else {
						sum += farm[N - y - 1][(N / 2) + index];
						sum += farm[N - y - 1][(N / 2) - index];
					}
				}
			}

			
			System.out.println("#" + t + " " + sum);
			
		}
	}
}
