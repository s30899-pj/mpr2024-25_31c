package pl.pjatk.support_system;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TicketStorage {

    private int idCounter = 1;
    private final List<Ticket> tickets = new ArrayList<>();

    public Ticket addTicket(Ticket ticket) {
        ticket.setId(idCounter++);
        tickets.add(ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketById(int id) {
        return tickets.stream().filter(ticket -> ticket.getId() == id).findFirst();
    }

    public Optional<Ticket> updateStatus(int id, Status status) {
        Optional<Ticket> ticket = getTicketById(id);
        ticket.ifPresent(t -> t.setStatus(status));
        return ticket;
    }

    public Optional<Ticket> updateAssignee(int id, String assignee) {
        Optional<Ticket> ticket = getTicketById(id);
        ticket.ifPresent(t -> t.setAssignee(assignee));
        return ticket;
    }
}