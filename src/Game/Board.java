package Game;

public class Board {
    private String[][] board;

    public Board(String[][] board){
        this.board = board;
    }
    public void edit(String replace, int row, int column){
        board[row][column] = replace;
    }

    public void fill(String str){
        for (int i=0;i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                board[i][j] = str;
            }
        }
    }

    public String toString(){
        String output = "";
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++) {
                output += board[i][j];
            }
            output+= "\n";
        }
        return output;
    }
}