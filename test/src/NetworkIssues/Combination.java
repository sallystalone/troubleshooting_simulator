package NetworkIssues;

import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Combination {


    public void combinationScenario(){
        handleDNSIssue();
        handleDhcpIssue();
        handleNetworkCongestion();
        handleRoutingIssue();

    }



    private static void handleDNSIssue() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the domain name you are trying to access");
            String userInput = scanner.nextLine();
                DNSError dnsError = new DNSError(userInput);
                dnsError.printDomainInfo();
                timestamp.getTimestamp();

    }
    static Timestamp timestamp = new Timestamp();
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
}

