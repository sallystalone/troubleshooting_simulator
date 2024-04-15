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

