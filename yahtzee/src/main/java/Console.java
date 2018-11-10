import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    Console(){

    }

    public Player createAccount()
    {
        String name = getCommandFromUser("Welcome to Yahtzee, what is your name?");
        int balance = getIntFromUser("How much money would you like to put into your account?");
        return new Player(name, balance);
    }

    public int getIntFromUser(String message){
        printMessage(message);
        try{
            int num = scanner.nextInt();
            return num;
        }catch(InputMismatchException err){
            printMessage("Please enter a number.");
            scanner.next();
        }
        return -1;
    }

    public String getCommandFromUser(String msg){
        printMessage(msg);
        String input = scanner.next();
        input.toLowerCase().trim();
        return input;
    }

    public String getLineFromUser(String msg){
        printMessage(msg);
        String input = scanner.nextLine();
        input.toLowerCase().trim();
        return input;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void printMessage(String string) {
        System.out.println(string);
    }

}
