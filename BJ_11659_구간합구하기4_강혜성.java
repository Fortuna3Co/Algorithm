package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4_강혜성 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for(int i = 1; i < numbers.length; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
			if (i > 0)
				dp[i] = dp[i-1] + numbers[i];
			else dp[i] = numbers[i];
		}

		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
			sb.append(dp[j] - dp[i-1]).append("\n");
		}
		System.out.println(sb);
	}
	// BufferedReader + StringTokenizer + StringBuilder 조합이 가장 빨랐음
}
