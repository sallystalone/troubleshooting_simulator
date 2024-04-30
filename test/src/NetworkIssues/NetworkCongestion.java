package NetworkIssues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NetworkCongestion {
    public void getNetworkCongestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Source IP! ");
        String sourceIP = scanner.nextLine();
        System.out.println("Please enter the destination IP! ");
        String destinationIP = scanner.nextLine();
        System.out.println("Tracking the traffic. To finish, press 2!");

        double packetLossPercentage = 0;

        while (true) {
            String finish = scanner.nextLine();
            // If the user enters '2', exit the loop
            if (finish.equals("2")) {
                break;
            }

            try {
                // Execute tcpdump command to track network traffic
                ProcessBuilder processBuilder = new ProcessBuilder("sudo", "tcpdump", "-i", "en0", "host", sourceIP, "and", "host", destinationIP);
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                int sentPackets = 0;
                int receivedPackets = 0;

                String line;
                // Read each line of the tcpdump output
                while ((line = reader.readLine()) != null) {
                    // Count the number of packets sent and received
                    if (line.contains(sourceIP)) {
                        sentPackets++;
                    } else if (line.contains(destinationIP)) {
                        receivedPackets++;
                    }
                }
                // Calculate packet loss percentage
                int packetLoss = sentPackets - receivedPackets;
                packetLossPercentage = (double) packetLoss / sentPackets * 100;

                process.waitFor();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Print the packet loss percentage
        if (packetLossPercentage == 0) {
            System.out.println("Packet loss is %0");
        } else {
            System.out.println("Packet Loss Percentage between " + sourceIP + " and " + destinationIP + ": " + packetLossPercentage + "%");
        }
    }
}

/*
Function handleNetworkCongestion():
    // Handle network congestion issues
    networkCongestion = NetworkCongestion()
    networkCongestion.getNetworkCongestion()

Function getNetworkCongestion():
    // Monitor network traffic and calculate packet loss percentage
    sourceIP = ReadInput("Please enter the source IP: ")
    destinationIP = ReadInput("Please enter the destination IP: ")
    MonitorTrafficAndCalculatePacketLoss(sourceIP, destinationIP)

Function MonitorTrafficAndCalculatePacketLoss(sourceIP, destinationIP):
    // Monitor traffic between source and destination IPs
    ExecuteSystemCommand("sudo tcpdump -i en0 host " + sourceIP + " and host " + destinationIP)
    // Monitor traffic and calculate packet loss percentage

 */
