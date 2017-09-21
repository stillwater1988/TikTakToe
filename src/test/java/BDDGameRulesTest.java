import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BDDGameRulesTest {

    private Game game;

    @BeforeEach
    public void startGame() {
        this.game = new Game();
    }

    @Test
    public void testGameSequence() {
        game.move(Player.NAME_X, 1, 1);
        Assertions.assertThrows(WrongSequenceException.class, game.move(Player.NAME_X, 1, 2));
    }

    @Test
    public void testCellEmptiness() {
        game.move(Player.NAME_X, 1, 1);
        Assertions.assertThrows(CellNotEmptyException.class, game.move(Player.NAME_O, 1, 1));
    }

    @Test
    public void testOutsideMove() {
        Assertions.assertThrows(MoveOutOfGridException.class, () -> game.move(Player.NAME_X, 10, 10));
    }

    @Test
    public void testPlayerXWinsV1() {
        game.move(Player.NAME_X, 1, 1);
        game.move(Player.NAME_O, 2, 1);
        game.move(Player.NAME_X, 1, 2);
        game.move(Player.NAME_O, 2, 2);
        game.move(Player.NAME_X, 1, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsV2() {
        game.move(Player.NAME_X, 2, 1);
        game.move(Player.NAME_O, 1, 1);
        game.move(Player.NAME_X, 2, 2);
        game.move(Player.NAME_O, 1, 2);
        game.move(Player.NAME_X, 2, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsV3() {
        game.move(Player.NAME_X, 3, 1);
        game.move(Player.NAME_O, 2, 1);
        game.move(Player.NAME_X, 3, 2);
        game.move(Player.NAME_O, 2, 2);
        game.move(Player.NAME_X, 3, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsH1() {
        game.move(Player.NAME_X, 1, 1);
        game.move(Player.NAME_O, 1, 2);
        game.move(Player.NAME_X, 2, 1);
        game.move(Player.NAME_O, 2, 2);
        game.move(Player.NAME_X, 3, 1);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsH2() {
        game.move(Player.NAME_X, 1, 2);
        game.move(Player.NAME_O, 1, 1);
        game.move(Player.NAME_X, 2, 2);
        game.move(Player.NAME_O, 2, 1);
        game.move(Player.NAME_X, 3, 2);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsH3() {
        game.move(Player.NAME_X, 1, 3);
        game.move(Player.NAME_O, 1, 2);
        game.move(Player.NAME_X, 2, 3);
        game.move(Player.NAME_O, 2, 2);
        game.move(Player.NAME_X, 3, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsD1() {
        game.move(Player.NAME_X, 1, 1);
        game.move(Player.NAME_O, 1, 2);
        game.move(Player.NAME_X, 2, 2);
        game.move(Player.NAME_O, 1, 3);
        game.move(Player.NAME_X, 3, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerXWinsD2() {
        game.move(Player.NAME_X, 3, 1);
        game.move(Player.NAME_O, 1, 2);
        game.move(Player.NAME_X, 2, 2);
        game.move(Player.NAME_O, 1, 1);
        game.move(Player.NAME_X, 1, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }

    @Test
    public void testPlayerOWinsH() {
        game.move(Player.NAME_X, 1, 1);
        game.move(Player.NAME_O, 2, 1);
        game.move(Player.NAME_X, 1, 2);
        game.move(Player.NAME_O, 2, 2);
        game.move(Player.NAME_X, 1, 3);
        Assertions.assertEquals(true, game.isOver());
        Assertions.assertEquals(Player.NAME_X, game.getWiner());
    }
}
