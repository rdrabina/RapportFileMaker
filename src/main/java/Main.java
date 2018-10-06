import Contoller.InputData;
import View.Dialogue;


public class Main {
    public static void main(String[] args) {
        new Dialogue().displayMonthChoice();
        new InputData().getInputData();
    }
}