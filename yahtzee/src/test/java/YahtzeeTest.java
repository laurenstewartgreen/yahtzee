import org.junit.Assert;
import org.junit.Test;

public class YahtzeeTest {

    Player player = new Player("Dan", 1000);
    Yahtzee yahtzee = new Yahtzee(player);
    Game game = new Game();

    @Test
    public void testSetBidGetBid() {
        //When
        yahtzee.setBet(400);
        int expected = 400;
        int actual = yahtzee.getBet();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRollOptionsNoRoll() {
        //When
        String expected = yahtzee.getCup().cupToString();
        yahtzee.rollOptions(3, "");
        String actual = yahtzee.getCup().cupToString();

        //Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testRollOptionsRollAll() {
        //When
        String expected = yahtzee.getCup().cupToString();
        yahtzee.rollOptions(1, "");
        String actual = yahtzee.getCup().cupToString();

        //Then
        Assert.assertNotEquals(expected, actual);


    }

    @Test
    public void testReRoll() {
        //When
        int diceOneValue = yahtzee.getCup().getCupArray()[0].getValue();
        int diceTwoValue = yahtzee.getCup().getCupArray()[1].getValue();
        yahtzee.rollOptions(2, Integer.toString(diceTwoValue));
        int actual = yahtzee.getCup().getCupArray()[0].getValue();

        //Then
        Assert.assertNotEquals(diceOneValue, actual);


    }

    @Test
    public void testEmptyRowTrue() {
        Assert.assertTrue(yahtzee.checkEmptyRow(ScoreSheet.ROW.CHANCE));


    }

    @Test
    public void testEmptyRowFalse() {
        //When
        yahtzee.rollAll();
        yahtzee.getDicePlayer().getScoreSheet().setRow(ScoreSheet.ROW.CHANCE, yahtzee.getCup());

        //Then
        Assert.assertFalse(yahtzee.checkEmptyRow(ScoreSheet.ROW.CHANCE));


    }

    @Test
    public void testPayout() {
        //When
        int expected = yahtzee.getDicePlayer().getCurrentBalance();
        yahtzee.payout();
        int actual = yahtzee.getDicePlayer().getCurrentBalance();

        //Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void testSelectingRow1() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.ACES;
        ScoreSheet.ROW actual = yahtzee.selectingRow(1);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow2() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.TWOS;
        ScoreSheet.ROW actual = yahtzee.selectingRow(2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow3() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.THREES;
        ScoreSheet.ROW actual = yahtzee.selectingRow(3);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow4() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.FOURS;
        ScoreSheet.ROW actual = yahtzee.selectingRow(4);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow5() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.FIVES;
        ScoreSheet.ROW actual = yahtzee.selectingRow(5);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow6() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.SIXES;
        ScoreSheet.ROW actual = yahtzee.selectingRow(6);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow7() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.THREEOFAKIND;
        ScoreSheet.ROW actual = yahtzee.selectingRow(7);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow8() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.FOUROFAKIND;
        ScoreSheet.ROW actual = yahtzee.selectingRow(8);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow9() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.FULLHOUSE;
        ScoreSheet.ROW actual = yahtzee.selectingRow(9);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow10() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.SMALLSTRAIGHT;
        ScoreSheet.ROW actual = yahtzee.selectingRow(10);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow11() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.LARGESTRAIGHT;
        ScoreSheet.ROW actual = yahtzee.selectingRow(11);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow12() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.YAHTZEE;
        ScoreSheet.ROW actual = yahtzee.selectingRow(12);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectingRow13() {
        //When
        ScoreSheet.ROW expected = ScoreSheet.ROW.CHANCE;
        ScoreSheet.ROW actual = yahtzee.selectingRow(13);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFinalScore() {
        //Given
        String expected = "Your total balance is now: $" + yahtzee.getDicePlayer().getCurrentBalance();

        //When
        String actual = yahtzee.getDicePlayer().balanceAtEnd();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCupToString() {
        //Given
        String expected = "0 0 0 0 0 ";

        //When
        String actual = yahtzee.getCup().cupToString();

        //Then
        Assert.assertEquals(expected, actual);

    }


}
