import java.util.ArrayList;
import java.util.Collections;

public class Cup {

    Dice[] cup = new Dice[5];

    public Cup() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();

        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
    }

    public Dice[] getCupArray() {
        return cup;
    }

    public void setCup(Dice[] cup) {
        this.cup = cup;
    }

    public ArrayList<Integer> getCupSortedArray() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Dice d : cup) {
            numbers.add(d.getValue());
        }
        Collections.sort(numbers);

        return numbers;
    }

    public String cupToString() {

        String cupString = "";

        for(Dice d : cup) {
            cupString += (d.getValue() + " ");
        }
        return cupString;
    }
}
