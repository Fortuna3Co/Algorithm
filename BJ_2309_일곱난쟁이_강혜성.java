package Day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_2309_일곱난쟁이_강혜성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[9];
		
		int diff = 0;
		for(int i = 0; i < height.length; ++i) { 
			height[i] = Integer.parseInt(br.readLine());
			diff += height[i];
		}
		// 모두 더한 값에 100을 뺀 값
		diff -= 100;
		
		// height 배열 정렬 한 후
		Arrays.sort(height);
		int lowIndex = 0, highIndex = 8;	// 투 포인터를 이용하여 N번 수행하여 결과 도출
		for(int index = 0; index < height.length; ++index) {
			
			if(height[lowIndex] + height[highIndex] == diff) {
				break;
			} else if (height[lowIndex] + height[highIndex] > diff) {
				highIndex--;
			} else {
				lowIndex++;
			}
		}
		
		
		for(int index = 0; index < height.length; ++index) {
			if (index != lowIndex && index != highIndex)
				System.out.println(height[index]);
		}
		
		
	}
}
