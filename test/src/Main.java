import NetworkIssues.DNSError;
import NetworkIssues.NetworkIssue;
import NetworkIssues.Timestamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        while (menuChoice != 6) {
            System.out.println("Please enter your network troubleshooting scenario:\n" +
                    "1-DNS ERROR\n" +
                    "2-DHCP ISSUE\n" +
                    "3-ROUTING ERROR\n" +
                    "4-NETWORK CONGESTION\n" +
                    "5-COMBINATION SCENARIO\n" +
                    "6-EXIT"
            );

            menuChoice = Integer.parseInt(scanner.nextLine());

            switch (menuChoice) {
                case 1:
                    handleDNSIssue();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public static Timestamp timestamp = new Timestamp();
    private static void handleDNSIssue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the domain name you are trying to access" + "For back to main menu press 2 ");
            String userInput = scanner.nextLine();
            if (userInput.equals("2")) {
                break;
            } else {
                DNSError dnsError = new DNSError(userInput);
                dnsError.printDomainInfo();
                timestamp.getTimestamp();
            }
        }
    }}