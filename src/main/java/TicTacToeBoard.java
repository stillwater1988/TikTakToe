import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeBoard {

    private Map<Integer, Map<Integer, String>> board = null;

    public TicTacToeBoard() {
        Map<Integer, Map<Integer, String>> board = new HashMap<Integer, Map<Integer, String>>();
        Map<Integer, String> row1 = new HashMap<Integer, String>();
        row1.put(1, "");
        row1.put(2, "");
        row1.put(3, "");
        board.put(1, row1);
        Map<Integer, String> row2 = new HashMap<Integer, String>();
        row2.put(1, "");
        row2.put(2, "");
        row2.put(3, "");
        board.put(2, row2);
        Map<Integer, String> row3 = new HashMap<Integer, String>();
        row3.put(1, "");
        row3.put(2, "");
        row3.put(3, "");
        board.put(3, row3);
        setBoard(board);
    }

    public String show() {
        Map<Integer, String> row1 = getBoard().get(1);
        Map<Integer, String> row2 = getBoard().get(2);
        Map<Integer, String> row3 = getBoard().get(3);
        String board = row1.get(1) + "|" + row1.get(2) + "|" + row1.get(1) + "\n"
            + "-+-+-\n"
            + row2.get(1) + "|" + row2.get(2) + "|" + row2.get(1) + "\n"
            + "-+-+-\n"
            + row3.get(1) + "|" + row3.get(2) + "|" + row3.get(1) + "\n";
        return board;
    }

    public String getValue(int col, int row) {
        Map<Integer, String> currRow = getBoard().get(row);
        if (currRow == null) {
            throw new MoveOutOfGridException();
        } else {
            String currCell = currRow.get(col);
            if (currCell == null) {
                throw new MoveOutOfGridException();
            }
        }
        return getBoard().get(row).get(col);
    }

    public void setValue(String currentPlayer, int col, int row) {
        getBoard().get(row).put(col, currentPlayer);
    }

    public  Map<Integer, Map<Integer, String>> getBoard() {
        return board;
    }

    public void setBoard( Map<Integer, Map<Integer, String>> board) {
        this.board = board;
    }
}
