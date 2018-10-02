package Model;


import View.Dialogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.stream.IntStream;

public class FileWriter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Dialogue dialogue = null;

    private final static String PATH = "C:\\Users\\Radzio\\Desktop\\";
    private final static String RAPPORT = "RAPPORT - ";
    private final static String TXT = ".txt";

    private final static String SATURDAY = "SATURDAY";
    private final static String SUNDAY = "SUNDAY";
    private final static String NEW_LINE = "\n";

    public FileWriter(){
        dialogue = new Dialogue();
    }

    public void makeRapportFile(Integer month){
        if(dialogue.getMonth(month).isPresent()) {
            saveData(makeData(month), dialogue.getMonth(month).get().toString());
        } else dialogue.displayError(logger, "Cannot apply requested month.");
    }

    private byte[] makeData(Integer month){
        StringBuilder sb = new StringBuilder();
        Calendar calendar = TimeTools.getCalendar();
        TimeTools.setMonth(calendar, month);
        int daysInMonth = TimeTools.getDaysInMonth(calendar);

        IntStream.rangeClosed(1, daysInMonth).forEach(day -> resolveText(sb, calendar, day));
        return sb.toString().getBytes();
    }

    private void resolveText (StringBuilder sb, Calendar calendar, int day){
        TimeTools.setDay(calendar, day);
        String date = TimeTools.getFormattedDate(calendar);
        sb.append(date).append(NEW_LINE);

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SATURDAY: sb.append(SATURDAY);
                break;
            case Calendar.SUNDAY: sb.append(SUNDAY);
                break;
            default: break;
        }
        sb.append(NEW_LINE + NEW_LINE + NEW_LINE);
    }

    private void saveData(byte[] content, String month){
        try (OutputStream outputStream = new FileOutputStream(PATH + RAPPORT + month + TXT)){
            dialogue.displayInfo(logger, "Writing data...");
            outputStream.write(content);
            dialogue.displayInfo(logger, "Closing file...");
            dialogue.displayInfo(logger, "Finish");
        } catch (FileNotFoundException e) {
            dialogue.displayError(logger, "File not found.");
        } catch (IOException e) {
            dialogue.displayError(logger, "IO exception occurred.");
        }
    }
}
