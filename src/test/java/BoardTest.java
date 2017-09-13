import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * created on 13.09.2017
 */
public class BoardTest {

    @Test
    @DisplayName("Empty Game Board Creation")
    public void showEmptyBoardTest() {
        String board =    " | | \n"
                        + "-+-+-\n"
                        + " | | \n"
                        + "-+-+-\n"
                        + " | | ";
        TicTacToeBoard actualBoard= new TicTacToeBoard();

        Assertions.assertEquals(board, actualBoard.show());
    }
}
