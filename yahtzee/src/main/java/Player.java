public class Player {
    private int currentBalance;
    private String name;
    ScoreSheet scoreSheet = new ScoreSheet();

    Player(String name, int initialBalance){
        this.name = name;
        this.currentBalance = initialBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void changeBalance(int addOrSubtract) {
        this.currentBalance += addOrSubtract;
    }

    public String getName() {
        return name;
    }

    public ScoreSheet getScoreSheet() {
        return scoreSheet;
    }

    public String balanceAtEnd() {
        return "Your total balance is now: $" + getCurrentBalance();
    }

}
