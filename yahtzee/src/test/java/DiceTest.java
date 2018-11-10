import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void testDiceOutcomeRange() {
        //Given
        Dice dice = new Dice();
        dice.roll();
        boolean expected = true;

        //When
        boolean actual = false;
        actual = dice.getValue() <= 6 && dice.getValue() >= 1;

        //Then
        Assert.assertEquals(expected, actual);

    }





}