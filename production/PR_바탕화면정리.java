package production;

public class PR_바탕화면정리 {
    public static void main(String[] args) {

//        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper = {"#"};

        // 컴퓨터 화면 상태 wallpaper
        // (lux, luy) (rdx, rdy)

        // 파일 중 제일 위에 있는 파일은 luy, 파일 중 제얼 왼쪽에 있는 파일은 lux
        // 파일 중 제일 아래에 있는 파일은 rdy, 파일 중 제일 오른쪽에 있는 파일은 rdx

        // 바탕 화면에는 적어도 하나의 파일이 있다.
        // 1 ≤ wallpaper의 길이, wallpaper[i] ≤ 50

        int ldx = wallpaper[wallpaper.length - 1].length() - 1, ldy = wallpaper.length - 1, rdx = 0, rdy = 0;
        for(int y = 0; y < wallpaper.length; ++y) {
            for(int x = 0; x < wallpaper[y].length(); ++x) {
                if(wallpaper[y].charAt(x) == '#') {
                    if(ldx > x) ldx = x;
                    if(ldy > y) ldy = y;
                    if(rdx < x) rdx = x;
                    if(rdy < y) rdy = y;
                }
            }
        }

        int[] answer = new int[4];
        answer[0] = ldy;
        answer[1] = ldx;
        answer[2] = rdy;
        answer[3] = rdx;

        System.out.println(answer);
    }
}
