import java.util.ArrayList;

public class Yahtzee {

    Console console = new Console();
    Player dicePlayer;
    Cup cup = new Cup();
    int betAmount = 0;
    int totalScore = 0;

    public Yahtzee(Player player) {
        this.dicePlayer = player;
        this.totalScore = this.dicePlayer.getScoreSheet().getTotalScore();
    }

    public Cup getCup() {
        return cup;
    }

    public int getBet() {
        return betAmount;
    }

    public void setBet(int bid) {
        this.betAmount = bid;
    }

    public Player getDicePlayer() {
        return dicePlayer;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void rollAll() {
        for (Dice d : getCup().getCupArray()) {
            d.roll();
        }
        Console.printMessage("\nYou rolled:\n" + getCup().cupToString() + "\n");
    }


    public void rollOptions(int choice, String diceToRoll) {

        switch (choice) {
            case 1:
                rollAll();
                break;

            case 2:
                reRoll(diceToRoll);
                break;

            case 3:
                break;
        }
    }

    public void reRoll(String diceToRoll) {

        String[] numbersString = diceToRoll.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : numbersString) {
            numbers.add(Integer.parseInt(s));
        }

        for (Integer i : numbers) {
            for (int j = 0; j < 5; j++) {
                if (i == getCup().getCupArray()[j].getValue()) {
                    getCup().getCupArray()[j].roll();
                    break;
                }
            }
        }
        Console.printMessage("\nYou rolled:\n" + getCup().cupToString() + "\n");

    }

    public ScoreSheet.ROW selectingRow(int choice) {

        ScoreSheet.ROW row = ScoreSheet.ROW.CHANCE;

            switch (choice) {
                case 1:
                    row = ScoreSheet.ROW.ACES;
                    break;
                case 2:
                    row = ScoreSheet.ROW.TWOS;
                    break;
                case 3:
                    row = ScoreSheet.ROW.THREES;
                    break;
                case 4:
                    row = ScoreSheet.ROW.FOURS;
                    break;
                case 5:
                    row = ScoreSheet.ROW.FIVES;
                    break;
                case 6:
                    row = ScoreSheet.ROW.SIXES;
                    break;
                case 7:
                    row = ScoreSheet.ROW.THREEOFAKIND;
                    break;
                case 8:
                    row = ScoreSheet.ROW.FOUROFAKIND;
                    break;
                case 9:
                    row = ScoreSheet.ROW.FULLHOUSE;
                    break;
                case 10:
                    row = ScoreSheet.ROW.SMALLSTRAIGHT;
                    break;
                case 11:
                    row = ScoreSheet.ROW.LARGESTRAIGHT;
                    break;
                case 12:
                    row = ScoreSheet.ROW.YAHTZEE;
                    break;
                case 13:
                    row = ScoreSheet.ROW.CHANCE;
                    break;
            }

            return row;

        }

        public boolean checkEmptyRow(ScoreSheet.ROW row) {
            if (dicePlayer.getScoreSheet().getScore(row) == null) {
                return true;
            } else {
                Console.printMessage("Error, you have already filled that row");
                return false;
            }
        }

    public void payout(){
        int score = getTotalScore();
        int payOut = 0;
        if (score == 1575) {
            payOut = getBet() * 100;
        } else if (score > 500) {
            payOut = getBet() * 10;
        } else if (score > 200) {
            payOut = getBet() * 2;
        } else {
            payOut = 0;
        }
        dicePlayer.changeBalance(payOut);
        Console.printMessage("You won $" + payOut);
    }

}