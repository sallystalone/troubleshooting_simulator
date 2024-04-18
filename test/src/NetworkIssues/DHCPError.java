package NetworkIssues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DHCPError {

    public void getDates() {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "getpacket", "en0");
            Process process = processBuilder.start();


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            long renewTime = 0;
            long rebindTime = 0;
            long leaseTime=0;

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.contains("renew")) {
                    String renewHex = line.split(" ")[line.split(" ").length - 1];

                    renewTime = Long.parseLong(renewHex.substring(2), 16);
                }

                 else if (line.contains("lease")) {
                    String leaseHex=line.split(" ")[line.split(" ").length - 1];

                    leaseTime = Long.parseLong(leaseHex.substring(2), 16);

                }
            }

            process.waitFor();

            Instant startInstant = Instant.now();

            Instant renewInstant = startInstant.plusSeconds(renewTime);
            Instant leaseInstant = startInstant.plusSeconds(leaseTime);

            LocalDateTime renewDateTime = LocalDateTime.ofInstant(renewInstant, ZoneId.systemDefault());
            LocalDateTime leaseDateTime = LocalDateTime.ofInstant(leaseInstant, ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


            System.out.println("Lease obtained: " + leaseDateTime.format(formatter) + " Lease expires:" + renewDateTime.format(formatter));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
