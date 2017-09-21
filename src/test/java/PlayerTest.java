import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * created on 13.09.2017
 */
public class PlayerTest {

    @Test
    public void createPlayerXTest() {
        Player player = new Player(Player.NAME_X);
        Assertions.assertEquals("X", player.getName());
    }

    @Test
    public void createPlayerOTest() {
        Player player = new Player(Player.NAME_O);
        Assertions.assertEquals("O", player.getName());
    }

    @Test
    public void createPlayerYTest() {
        Player player = new Player("Y");
        Assertions.assertNotEquals("Y", player.getName());
    }
}
