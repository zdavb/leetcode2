/**
 * Created by dave on 2015/10/4.
 */
public class GameOfLife {
    private int countLiveNeigh(int[][] board,int row,int col){
        int count = 0;
        for(int i = row-1;i<=row+1;i++){
            for(int j = col-1;j<=col+1;j++){
                if(i == row && j == col)
                    continue;
                if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&(board[i][j] == 1||board[i][j] == 3))//原先为1的值而非改变后的
                    count++;
            }
        }
        return count;
    }
    private boolean recoverBoard(int[][] board){
        boolean noChange = true;
        for(int row = 0;row<board.length;row++){
            for(int col = 0;col<board[0].length;col++){
                if(board[row][col] == 2){
                    noChange = false;
                    board[row][col] = 1;
                }else if(board[row][col] == 3){
                    noChange = false;
                    board[row][col] = 0;
                }
            }
        }
        return noChange;
    }
    public void gameOfLife(int[][] board) {
        /*
        * 使用0---0-->0
        * 使用1---1-->1
        * 使用2---0-->1
        * 使用3---1-->0
        * */
            for(int row = 0;row<board.length;row++){
                for(int col = 0;col<board[0].length;col++){
                    int count = countLiveNeigh(board,row,col);
                    if(count == 2);
                    else if(count == 3){
                        if(board[row][col] == 0)
                            board[row][col] = 2;//0--->1
                    }else{
                        if(board[row][col] == 1)
                            board[row][col] = 3;//1--->0
                    }
                }
            }
        recoverBoard(board);
    }
    public void test() {
        int[][] board = {
                {1,0,1,0,1,1,0,0,0,0,1,1,1,0,1,1,0,0,1,0,0},
                {1,1,0,1,1,1,0,0,1,1,1,1,1,0,0,1,1,0,1,0,1},
                {0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1},
                {1,0,1,1,0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,0,0},
                {1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,1,1},
                {1,1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,1,1,1,0},
                {0,1,0,1,1,1,1,1,0,0,1,1,0,0,0,1,0,1,1,1,0},
                {0,0,1,0,0,1,1,1,0,1,0,1,0,0,1,1,1,0,1,0,0},
                {0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,0,1,1,1,1,0,0,0,1,0,1,0,1},
                {0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,1,1},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,1,1,1,1,0,0,0,1,0,1,0,0},
                {1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,0,1,1},
                {1,1,0,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,1},
                {0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,0,1,0,1,0},
                {0,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,1},
                {0,0,1,0,1,0,1,0,1,1,0,1,1,0,1,0,0,1,1,0,1},
                {1,0,1,1,0,1,1,0,0,1,0,1,1,0,1,1,0,0,1,0,1},
                {1,0,1,1,0,1,0,0,1,0,0,1,1,0,1,1,1,0,1,1,0},
                {1,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1}};
        //int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        gameOfLife(board);
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
