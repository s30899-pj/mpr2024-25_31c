package pl.pjatk.support_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@SpringBootTest
class TicketServiceTestIT {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketStorage ticketStorage;

    @BeforeEach
    void setUp() {
        ticketStorage = new TicketStorage();
    }

    @Test
    void createTicket_ShouldReturnTicket_WhenDataIsValid() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);

        // When
        Ticket createdTicket = ticketService.createTicket(ticket);

        // Then
        assertNotNull(createdTicket);
        assertEquals("Robert Lewandowski", createdTicket.getReporter());
        assertEquals("Mariusz Nowak", createdTicket.getAssignee());
        assertEquals(Status.WAITING_FOR_SUPPORT, createdTicket.getStatus());
    }

    @Test
    void createTicket_ShouldThrowException_WhenReporterIsNull() {
        // Given
        Ticket ticket = new Ticket(null, "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.createTicket(ticket);
        });
        assertEquals("Reporter cannot be null or empty.", exception.getMessage());
    }

    @Test
    void createTicket_ShouldThrowException_WhenAssigneeIsNull() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", null, Status.WAITING_FOR_SUPPORT);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.createTicket(ticket);
        });
        assertEquals("Assignee cannot be null or empty.", exception.getMessage());
    }

    @Test
    void createTicket_ShouldThrowException_WhenStatusIsNull() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", null);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.createTicket(ticket);
        });
        assertEquals("Status cannot be null.", exception.getMessage());
    }

    @Test
    void getTicketById_ShouldReturnTicket_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketService.createTicket(ticket);

        // When
        Optional<Ticket> foundTicket = ticketService.getTicketById(1);

        // Then
        assertTrue(foundTicket.isPresent());
        assertEquals("Robert Lewandowski", foundTicket.get().getReporter());
    }

    @Test
    void getTicketById_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given

        // When
        Optional<Ticket> foundTicket = ticketService.getTicketById(999);

        // Then
        assertFalse(foundTicket.isPresent());
    }

    @Test
    void updateStatus_ShouldUpdateStatus_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketService.createTicket(ticket);

        // When
        Optional<Ticket> updatedTicket = ticketService.updateStatus(1, Status.IN_PROGRESS);

        // Then
        assertTrue(updatedTicket.isPresent());
        assertEquals(Status.IN_PROGRESS, updatedTicket.get().getStatus());
    }

    @Test
    void updateStatus_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given

        // When
        Optional<Ticket> updatedTicket = ticketService.updateStatus(999, Status.IN_PROGRESS);

        // Then
        assertFalse(updatedTicket.isPresent());
    }

    @Test
    void updateAssignee_ShouldUpdateAssignee_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketService.createTicket(ticket);

        // When
        Optional<Ticket> updatedTicket = ticketService.updateAssignee(1, "Jan Kowalski");

        // Then
        assertTrue(updatedTicket.isPresent());
        assertEquals("Jan Kowalski", updatedTicket.get().getAssignee());
    }

    @Test
    void updateAssignee_ShouldThrowException_WhenAssigneeIsNull() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketService.createTicket(ticket);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.updateAssignee(1, null);
        });
        assertEquals("Assignee cannot be null or empty.", exception.getMessage());
    }

    @Test
    void updateAssignee_ShouldThrowException_WhenTicketDoesNotExist() {
        // Given

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.updateAssignee(999, "Jan Kowalski");
        });
        assertEquals("Ticket with ID 999 not found.", exception.getMessage());
    }

    @Test
    void printTicketDetails_ShouldPrintTicketDetails_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketService.createTicket(ticket);

        // When / Then
        ticketService.printTicketDetails(1);
    }

    @Test
    void printTicketDetails_ShouldPrintNotFoundMessage_WhenTicketDoesNotExist() {
        // Given

        // When / Then
        ticketService.printTicketDetails(999);
    }
}