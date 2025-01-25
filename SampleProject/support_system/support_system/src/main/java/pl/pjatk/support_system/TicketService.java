package pl.pjatk.support_system;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketStorage ticketStorage;

    public TicketService(TicketStorage ticketStorage) {
        this.ticketStorage = ticketStorage;
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket.getReporter() == null || ticket.getReporter().isEmpty()) {
            throw new IllegalArgumentException("Reporter cannot be null or empty.");
        }
        if (ticket.getAssignee() == null || ticket.getAssignee().isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be null or empty.");
        }
        if (ticket.getStatus() == null) {
            throw new IllegalArgumentException("Status cannot be null.");
        }
        return ticketStorage.addTicket(ticket);
    }

    public Optional<Ticket> getTicketById(int id) {
        return ticketStorage.getTicketById(id);
    }

    public Optional<Ticket> updateStatus(int id, Status status) {
        return ticketStorage.updateStatus(id, status);
    }

    public Optional<Ticket> updateAssignee(int id, String assignee) {
        if (assignee == null || assignee.isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be null or empty.");
        }
        Optional<Ticket> ticket = ticketStorage.getTicketById(id);
        if (ticket.isEmpty()) {
            throw new IllegalArgumentException("Ticket with ID " + id + " not found.");
        }
        return ticketStorage.updateAssignee(id, assignee);
    }

    public void printTicketDetails(int id) {
        Optional<Ticket> ticket = ticketStorage.getTicketById(id);
        ticket.ifPresentOrElse(
                t -> System.out.println("Ticket ID: " + t.getId() + ", Reporter: " + t.getReporter() + ", Assignee: " + t.getAssignee() + ", Status: " + t.getStatus()),
                () -> System.out.println("Ticket with ID " + id + " not found.")
        );
    }
}
