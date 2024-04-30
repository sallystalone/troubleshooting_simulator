import NetworkIssues.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        while (menuChoice != 6) {
            System.out.println("Please enter your network troubleshooting scenario:\n" +
                    "1-DNS ERROR\n" +
                    "2-DHCP LEASE\n" +
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
                    handleDhcpIssue();
                    break;
                case 3:
                    handleRoutingIssue();
                    break;
                case 4:
                    handleNetworkCongestion();
                    break;
                case 5:
                    handleCombination();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    static Timestamp timestamp = new Timestamp();
    private static void handleDNSIssue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the domain name you are trying to access" + " For back to main menu press 2 ");
            String userInput = scanner.nextLine();
            if (userInput.equals("2")) {
                break;
            } else {
                DNSError dnsError = new DNSError(userInput);
                dnsError.printDomainInfo();
                timestamp.getTimestamp();
            }
        }
    }
    private static void handleRoutingIssue() {
        RoutingError routingError = new RoutingError();
        routingError.getRoutingError();
        timestamp.getTimestamp();

    }
    private static void handleDhcpIssue(){
        DHCPError dhcpError = new DHCPError();
        dhcpError.getDates();
        timestamp.getTimestamp();
    }
    private static void handleNetworkCongestion(){
        NetworkCongestion networkCongestion = new NetworkCongestion();
        networkCongestion.getNetworkCongestion();
    }
    private static void handleCombination(){
        Combination combination = new Combination();
        combination.combinationScenario();
    }
}
/*
Function DisplayMainMenu():
    Print menu options for network troubleshooting scenarios.

Function ReadUserChoice():
    Read user input for menu selection and return choice.

Function HandleMenuChoice(choice):
    Call corresponding function/method based on user choice.

Function Main():
    While user choice is not to exit:
        DisplayMainMenu()
        HandleMenuChoice(ReadUserChoice())

 */