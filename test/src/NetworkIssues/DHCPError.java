package NetworkIssues;

public class DHCPError extends NetworkIssue{
    private String ipAddress;
    private int errorCode;

    public DHCPError(String ipAddress, int errorCode,String description){
        super("DHCP issue!",description,false);
        this.ipAddress=ipAddress;
        this.errorCode=errorCode;
    }

}
