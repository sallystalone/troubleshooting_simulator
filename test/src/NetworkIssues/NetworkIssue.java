package NetworkIssues;

public class NetworkIssue {
    private String type;
    private String description;
    private boolean status;
    Timestamp timestamp = new Timestamp();

    public NetworkIssue(String type, String description, boolean status){
                this.type=type;
                this.description=description;
                this.status=status;
                timestamp.getTimestamp();
    }

}
