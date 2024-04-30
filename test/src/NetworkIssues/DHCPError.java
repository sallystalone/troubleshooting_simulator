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
            //Passing the commands as arguments
            ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "getpacket", "en0");
            //Executing the commands
            Process process = processBuilder.start();

            //Reading the output of commands
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            long renewTime = 0;
            long leaseTime=0;

            String line;
            while ((line = reader.readLine()) != null) {
                //Finding the renew and lease keywords in the output

                if (line.contains("renew")) {
                    //Turning it to suitable format
                    String renewHex = line.split(" ")[line.split(" ").length - 1];

                    renewTime = Long.parseLong(renewHex.substring(2), 16);
                }

                 else if (line.contains("lease")) {
                     //Turning it to suitable format
                    String leaseHex=line.split(" ")[line.split(" ").length - 1];

                    leaseTime = Long.parseLong(leaseHex.substring(2), 16);

                }
            }

            process.waitFor();

            Instant startInstant = Instant.now();
            // Creates Instant objects for renewal and lease times
            Instant renewInstant = startInstant.plusSeconds(renewTime);
            Instant leaseInstant = startInstant.plusSeconds(leaseTime);
            // Converts renewal and lease times to LocalDateTime objects
            LocalDateTime renewDateTime = LocalDateTime.ofInstant(renewInstant, ZoneId.systemDefault());
            LocalDateTime leaseDateTime = LocalDateTime.ofInstant(leaseInstant, ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            //Printing obtain and expire date.
            System.out.println( "Lease obtained: " + renewDateTime.format(formatter) + " Lease expires: " + leaseDateTime.format(formatter) );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
Function handleDhcpIssue():
    // Handle DHCP lease-related issues
    dhcpError = DHCPError()
    dhcpError.getDates()

Function getDates():
    // Retrieve DHCP lease information
    ExecuteSystemCommand("ipconfig getpacket en0")
    ParseOutputAndCalculateLeaseTimes()

Function ParseOutputAndCalculateLeaseTimes():
    // Parse command output and calculate lease times
    While line in commandOutput:
        If line contains "renew":
            renewTime = ParseRenewTime(line)
        Else If line contains "lease":
            leaseTime = ParseLeaseTime(line)
    CalculateLeaseExpirationTime(renewTime, leaseTime)
 */