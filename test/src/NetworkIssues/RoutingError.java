package NetworkIssues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;

public class RoutingError {
    public void getRoutingError() {
        try {
            System.out.println("Please wait. Reading the information...!");
            ProcessBuilder processBuilder = new ProcessBuilder("netstat", "-r");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Internet6:")) {
                    break;
                }
            }
            System.out.println("---To analyze the routing table for errors or inconsistencies, first, " +
                    "\n understand the meaning of each column, such as Destination, Gateway, Flags, and Netif. " +
                    "\n Check the default route to ensure it points to the correct gateway for internet access. " +
                    "\n Verify the accuracy of destination IP addresses and their associated gateways, ensuring they are " +
                    "\n within the same network. Examine the flags for status details like \"up,\" \"host,\" and \"interface.\" " +
                    "\n Identify any missing or incorrect entries, such as IP addresses without specified gateways. " +
                    "\n Review the connection status, paying attention to validity indicators like \"expire\" or \"age.\" " +
                    "\n Finally, recommend and implement any necessary corrections to address the identified issues.--- ");
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



