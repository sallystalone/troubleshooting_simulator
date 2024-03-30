package NetworkIssues;

public class RoutingError extends NetworkIssue {
    private String sourceIpAddress;
    private int sourcePort;
    private String destinationIpAddress;
    private int destinationPort;
    private int errorCode;

    public RoutingError(String sourceIpAddress, int sourcePort, String destinationIpAddress, int destinationPort,int errorCode,String description){
        super("Routing error!",description,false);
        this.sourceIpAddress=sourceIpAddress;
        this.sourcePort=sourcePort;
        this.destinationPort=destinationPort;
        this.errorCode=errorCode;

    }
}
