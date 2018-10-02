package View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.IntStream;

public class Dialogue {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int AMOUNT_OF_MONTHS = 12;
    private static final String[] months = new DateFormatSymbols(Locale.ENGLISH).getMonths();


    public void displayMonthChoice() {
        System.out.println("Choose one of the month:");
        IntStream.rangeClosed(0, AMOUNT_OF_MONTHS).forEach(this::displayMonths);
    }

    private void displayMonths(int i) {
        if (i == 0) System.out.println(String.valueOf(i) + ". " + "Exit");
        else if (i >= 1 && i <= 12) {
            System.out.println(String.valueOf(i) + ". " + months[i - 1]);
        } else {
            displayError(logger,"Cannot find requested month");
        }
    }

    public void displayError(Logger logger, String error) {
        logger.error(error);
        System.out.println(error);
    }

    public void displayInfo(Logger logger, String info) {
        logger.info(info);
        System.out.println(info);
    }

    public Optional getMonth(Integer i){
        try {
            return Optional.ofNullable(months[i-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}