package Contoller;

import Model.FileWriter;
import View.Dialogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Dialogue dialogue = new Dialogue();
    public void getInputData(){
        Integer monthNumber = null;
        try {
            monthNumber = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            dialogue.displayError(logger,"Unexpected choice occurred.");
            System.exit(1);
        }
        if(!(monthNumber >= 0 && monthNumber <=12)) {
            dialogue.displayError(logger, "Invalid input.");
        }
        if(monthNumber == 0) System.exit(0);
        new FileWriter().makeRapportFile(monthNumber);
    }
}
