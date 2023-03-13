public class PR_혼자서하는틱택토 {
    public static int main(String[] args) {
        // 게임이 끝난 경우
        // ".'를 제외한 동일한 문양이 가로, 세로, 대각선인 경우
        // O가 이겼을 경우 X보다 한 개 더 많아야 한다.
        // X가 이겼을 경우 O와 개수가 똑같고 O가 승리하지 않았어야 한다.

        // 순서가 다른 경우
        // X의 개수가 O의 개수보다 더 많은 경우
        // O의 개수가 X의 개수보다 2개 이상 많은 경우

        String[] board = {"O..", ".OX", "X.O"};

        int oCount = 0, xCount = 0;
        for(int y = 0; y < board.length; ++y) {
            for(int x = 0; x < board[y].length(); ++x) {
                if(board[y].charAt(x) == 'O') oCount++;
                if(board[y].charAt(x) == 'X') xCount++;
            }
        }

        if(oCount > xCount + 1) return 0;
        if(oCount < xCount) return 0;

        int oWinCount = 0, xWinCount = 0;
        for(int y = 0; y < board.length; ++y) {
            int oWidthWinCount = 0, xWidthWinCount = 0, oHeightWindCocunt = 0, xHeightWinCount= 0;
            for(int x = 0; x < board[y].length(); ++x) {
                if(board[y].charAt(x) == 'O') oWidthWinCount++;
                if(board[y].charAt(x) == 'X') xWidthWinCount++;
                if(board[x].charAt(y) == 'O') oHeightWindCocunt++;
                if(board[x].charAt(y) == 'X') xHeightWinCount++;
            }

            if(oWidthWinCount == 3 || oHeightWindCocunt == 3) {
                if(oWidthWinCount == 3 && oHeightWindCocunt == 3)
                    oWinCount += 2;
                else oWinCount++;
                if(oCount - 1 != xCount) return 0;
            }

            if(xWidthWinCount == 3 || xHeightWinCount == 3) {
                if(xWidthWinCount == 3 && xHeightWinCount == 3)
                    xWinCount += 2;
                else xWinCount++;
                if(oCount != xCount) return 0;
            }
        }

        // 대각선으로 이기는 경우
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[0].charAt(0) != '.') {
            if(board[0].charAt(0) == 'O' && oCount - 1 != xCount) {
                oWinCount++;
                return 0;
            }
            if (board[0].charAt(0) == 'X' && oCount != xCount) {
                xWinCount++;
                return 0;
            }
        }

        // 대각선으로 이기는 경우
        if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0) && board[0].charAt(2) != '.') {
            if(board[0].charAt(2) == 'O' && oCount - 1 != xCount) {
                oWinCount++;
                return 0;
            }
            if (board[0].charAt(2) == 'X' && oCount != xCount) {
                xWinCount++;
                return 0;
            }
        }

        if(xWinCount > 1) return 0;

        return 1;
    }
}
