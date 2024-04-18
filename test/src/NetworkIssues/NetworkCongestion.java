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
            if (finish.equals("2")) {
                break;
            }

            try {
                ProcessBuilder processBuilder = new ProcessBuilder("sudo", "tcpdump", "-i", "en0", "host", sourceIP, "and", "host", destinationIP);
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                int sentPackets = 0;
                int receivedPackets = 0;

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(sourceIP)) {
                        sentPackets++;
                    } else if (line.contains(destinationIP)) {
                        receivedPackets++;
                    }
                }

                int packetLoss = sentPackets - receivedPackets;
                packetLossPercentage = (double) packetLoss / sentPackets * 100;

                process.waitFor();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (packetLossPercentage == 0) {
            System.out.println("Packet loss is %0");
        } else {
            System.out.println("Packet Loss Percentage between " + sourceIP + " and " + destinationIP + ": " + packetLossPercentage + "%");
        }
    }
}
