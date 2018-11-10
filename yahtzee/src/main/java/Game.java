import java.util.ArrayList;

public class Game {

    public boolean playing = true;
    private Console console = new Console();
    private Player player;

    public Game() {

    }

    public static void main(String[] args){
        Game game = new Game();
        game.setPlayer(game.getConsole().createAccount());
        game.play();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void play()
    {
        while(playing) {

            Yahtzee yahtzee = new Yahtzee(player);
            takingBet(yahtzee);
            for (int i = 0; i < ScoreSheet.getSize(); i++){
                playRound(yahtzee);
                if (playing == false) {
                    break;
                }
                score(yahtzee);
            }

            Console.printMessage("You scored " + yahtzee.getDicePlayer().getScoreSheet().getTotalScore() + " points.");
            yahtzee.payout();
            Console.printMessage(yahtzee.getDicePlayer().balanceAtEnd() + "\n");

            quit();

        }
    }

    public void quit() {
        String response = console.getCommandFromUser("Type 'quit' to leave the game, otherwise type 'play' to play again.");
        if(response.equalsIgnoreCase("quit")) {
            Console.printMessage("Thanks for playing Yahtzee!  Come back soon!");
            setPlaying(false);
        } else {
            setPlaying(true);
        }
    }

    public void takingBet(Yahtzee game) {
        boolean enoughMoney = false;
        int betAmount = 0;
        while (!enoughMoney) {
            betAmount = console.getIntFromUser("How much would you like to bet on this game?");
            enoughMoney = checkBet(betAmount);
        }
            game.setBet(betAmount);
            player.changeBalance(betAmount * -1);
    }


    public boolean checkBet(int betAmount) {
        while(betAmount > player.getCurrentBalance()) {
            Console.printMessage("You do not have that much money in your account.");
            String command = console.getCommandFromUser("Would you like to put more money into your account? Y or N");
            if(command.equalsIgnoreCase("n")) {
                return false;
            } else {
                addToAccountBalance();
            }
        }
            return true;

    }

    public void addToAccountBalance() {
        int deposit = console.getIntFromUser("How much would you like to add?");
        player.changeBalance(deposit);
    }

    public void playRound(Yahtzee game) {

            game.rollAll();
            for(int j = 0; j < 2; j++) {
                int rollChoice = console.getIntFromUser("Would you like to:\n1. Roll all dice again.\n2. Roll some dice again.\n3. Stop rolling and score.\n4. Quit Game \nNumber of Selection: ");
                String diceToRoll = "";
                if(rollChoice == 2) {
                    getConsole();
                    diceToRoll = console.getLineFromUser("Which numbers would you like to reroll? List the numbers separated by spaces.");
                } else if (rollChoice == 4) {
                    setPlaying(false);
                    break;
                }
                game.rollOptions(rollChoice, diceToRoll); }

    }

    public void score(Yahtzee game) {
        boolean validEntry = false;
        ScoreSheet.ROW row = ScoreSheet.ROW.CHANCE;
        while (!validEntry) {
            Console.printMessage(game.getDicePlayer().getScoreSheet().scoreCardToString());

            int rowChoice = console.getIntFromUser("Which row would you like to apply your turn to on the scoresheet?.\n" +
                    "Remember you can only use each row once!");

            row = game.selectingRow(rowChoice);
            validEntry = game.checkEmptyRow(row);
        }
        game.getDicePlayer().getScoreSheet().setRow(row, game.getCup());
        Console.printMessage("\n" + game.getDicePlayer().getScoreSheet().scoreCardToString());
    }

    public Console getConsole() {
        return console;
    }
}
