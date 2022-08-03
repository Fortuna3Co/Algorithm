package Day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_1873_상호의배틀필드_강혜성 {
	// 전차가 현재 바라보는 방향으로 포탄을 쏜다
	private static char[][] Shoot(char[][] battleMap, int tankY, int tankX, char tankDirection) {
			
			if (tankDirection == 'D') {
				for(int y = tankY + 1; y < battleMap.length; ++y) {
					// 벽돌로 만들어진 벽을 만날 경우 해당 벽을 없앤다
					if(battleMap[y][tankX] == '*') {
						battleMap[y][tankX] = '.';
						// 벽이 없어진 후 종료
						break;
					}
					
					// 강철 벽일 경우 아무일도 일어나지 않음
					else if(battleMap[y][tankX] == '#')
						break;
				}
			}
			
			else if (tankDirection == 'U') {
				for(int y = tankY - 1; y >= 0; --y) {
					// 벽돌로 만들어진 벽을 만날 경우 해당 벽을 없앤다
					if(battleMap[y][tankX] == '*') {
						battleMap[y][tankX] = '.';
						break;
					}
					// 강철 벽일 경우 아무일도 일어나지 않음
					else if(battleMap[y][tankX] == '#')
						break;
				}
			}
			
			else if (tankDirection == 'L') {
				for(int x = tankX - 1; x >= 0; --x) {
					// 벽돌로 만들어진 벽을 만날 경우 해당 벽을 없앤다
					if(battleMap[tankY][x] == '*') {
						battleMap[tankY][x] = '.';
						break;
					}
					// 강철 벽일 경우 아무일도 일어나지 않음
					else if(battleMap[tankY][x] == '#')
						break;
				}
			}
			
			else if (tankDirection =='R') {
				for(int x = tankX + 1; x < battleMap[tankY].length; ++x) {
					// 벽돌로 만들어진 벽을 만날 경우 해당 벽을 없앤다
					if(battleMap[tankY][x] == '*') {
						battleMap[tankY][x] = '.';
						break;
					}
					// 강철 벽일 경우 아무일도 일어나지 않음
					else if(battleMap[tankY][x] == '#')
						break;
				}
			}
			
			return battleMap;
		}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] line = br.readLine().split(" ");
			int Y = Integer.parseInt(line[0]), X = Integer.parseInt(line[1]);

			char[][] battleMap = new char[Y][X];

			// 전차의 상태를 저장할 변수
			int tankX = 0, tankY = 0;
			char tankDirection = ' ';

			// 입력 받으면서 전차의 상태 확인
			for (int y = 0; y < Y; ++y) {
				battleMap[y] = br.readLine().toCharArray();

				for (int x = 0; x < X; ++x) {
					if (battleMap[y][x] == '<') {
						tankX = x;
						tankY = y;
						tankDirection = 'L';
					} else if (battleMap[y][x] == '>') {
						tankX = x;
						tankY = y;
						tankDirection = 'R';
					} else if (battleMap[y][x] == '^') {
						tankX = x;
						tankY = y;
						tankDirection = 'U';
					} else if (battleMap[y][x] == 'v') {
						tankX = x;
						tankY = y;
						tankDirection = 'D';
					}
				}
			}

			// 유저 입력
			int userCommandCount = Integer.parseInt(br.readLine());
			String userComandInput = br.readLine();

			for (int index = 0; index < userCommandCount; ++index) {
				if (userComandInput.charAt(index) == 'U') {
					// 전차가 바라보는 방향을 위쪽으로 바꾼다.
					tankDirection = 'U';
					// 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
					if (tankY - 1 >= 0 && battleMap[tankY-1][tankX] == '.') {
						battleMap[tankY--][tankX] = '.';
						battleMap[tankY][tankX] = '^';
					} 
					// 평지가 아니거나 맵을 벗어나게 되면 방향만 바꾼다
					else {
						battleMap[tankY][tankX] = '^';
					}

				} else if (userComandInput.charAt(index) == 'D') {
					tankDirection = 'D';
					if (tankY + 1 < battleMap.length && battleMap[tankY+1][tankX] == '.') {
						battleMap[tankY++][tankX] = '.';
						battleMap[tankY][tankX] = 'v';
					} else {
						battleMap[tankY][tankX] = 'v';
					}

				} else if (userComandInput.charAt(index) == 'L') {
					tankDirection = 'L';
					if (tankX - 1 >= 0 && battleMap[tankY][tankX-1] == '.') {
						battleMap[tankY][tankX--] = '.';
						battleMap[tankY][tankX] = '<';
					} else {
						battleMap[tankY][tankX] = '<';
					}

				} else if (userComandInput.charAt(index) == 'R') {
					tankDirection = 'R';
					if (tankX + 1 < battleMap[tankY].length && battleMap[tankY][tankX+1] == '.') {
						battleMap[tankY][tankX++] = '.';
						battleMap[tankY][tankX] = '>';
					} else {
						battleMap[tankY][tankX] = '>';
					}

				} else if (userComandInput.charAt(index) == 'S') {
					battleMap = Shoot(battleMap, tankY, tankX, tankDirection);
				}
			}
			
			System.out.print("#" + t + " ");
			for(char[] ba : battleMap) {
				for (char b : ba) {
					System.out.print(b);
				}
				System.out.println();
			}
		}
	}

}
