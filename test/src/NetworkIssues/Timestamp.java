package NetworkIssues;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp{
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String formattedTime = dateTime.format(formatter);

    public void getTimestamp() {
        System.out.println("Time: " + formattedTime);
    }

}
