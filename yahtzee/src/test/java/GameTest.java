import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    Game game = new Game();
    Player testPlayer = new Player("Lauren", 400);

    @Test
    public void testSetPlayer() {
        //When
        game.setPlayer(testPlayer);
        Player expected = testPlayer;
        Player actual = game.getPlayer();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSetPlaying() {
        game.setPlaying(false);
        Assert.assertFalse(game.isPlaying());

    }

    @Test
    public void testCheckBetEnoughMoney() {
        game.setPlayer(testPlayer);
        Assert.assertTrue(game.checkBet(30));


    }



}
