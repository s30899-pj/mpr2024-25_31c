package pl.pjatk.support_system;

public class Ticket {
    private int id;
    private String reporter;
    private String assignee;
    private Status status;

    public Ticket(){}

    public Ticket(String reporter, String assignee, Status status) {
        this.reporter = reporter;
        this.assignee = assignee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getReporter() {
        return reporter;
    }

    public String getAssignee() {
        return assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
