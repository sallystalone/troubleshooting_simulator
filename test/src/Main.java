import NetworkIssues.DNSError;
import NetworkIssues.NetworkIssue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String domainName;
        Scanner domainObj = new Scanner(System.in);
        System.out.println("Enter the domain name you are trying to access: ");
        domainName=domainObj.nextLine();

        DNSError dnsError= new DNSError(domainName);
        dnsError.printDomainInfo();


    }
}