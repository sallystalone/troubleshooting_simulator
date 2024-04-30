package NetworkIssues;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSError {
    private String domainName;
    private String newDomainName;


    public DNSError(String domainName) {
        this.domainName=domainName;


    }
    public void printDomainInfo() {
        try {
            boolean containsCom=domainName.contains(".com");
            if(containsCom==false){
               newDomainName=domainName.concat(".com");
                System.out.println(".com added! ");
                InetAddress inetHost = InetAddress.getByName(newDomainName);
                String hostName = inetHost.getHostName();
                System.out.println("The host name: " + hostName);
                System.out.println("The host's IP address is: " + inetHost.getHostAddress());
            }else{
                InetAddress inetHost = InetAddress.getByName(domainName);
                String hostName = inetHost.getHostName();
                System.out.println("The host name: " + hostName);
                System.out.println("The host's IP address is: " + inetHost.getHostAddress());

            }
        } catch (UnknownHostException e) {
            System.out.println("Failure! Host didn't find" );
        }


    }
}

/*
Function handleDNSIssue():
    // Handle DNS-related issues
    userInput = ReadInput("Enter the domain name you are trying to access (Enter '2' to go back to the main menu): ")
    If userInput == "2":
        ReturnToMainMenu()
    Else:
        dnsError = DNSError(userInput)
        dnsError.printDomainInfo()

Function printDomainInfo():
    // Print domain information after resolving DNS
    If domainName does not end with ".com":
        Append ".com" to domainName
    Try:
        inetHost = ResolveDomain(domainName)
        Print("The host name: " + inetHost.getHostName())
        Print("The host's IP address is: " + inetHost.getHostAddress())
    Catch UnknownHostException:
        Print("Failure! Host not found.")

 */

