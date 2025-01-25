package pl.pjatk.support_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
class TicketStorageTest {
    private TicketStorage ticketStorage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTicket_ShouldAssignIdAndAddTicket() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);

        // When
        Ticket addedTicket = ticketStorage.addTicket(ticket);

        // Then
        assertNotNull(addedTicket);
        assertEquals(1, addedTicket.getId());
        assertEquals("Robert Lewandowski", addedTicket.getReporter());
        assertEquals("Mariusz Nowak", addedTicket.getAssignee());
        assertEquals(Status.WAITING_FOR_SUPPORT, addedTicket.getStatus());
    }

    @Test
    void getTicketById_ShouldReturnTicket_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketStorage.addTicket(ticket);

        // When
        Optional<Ticket> foundTicket = ticketStorage.getTicketById(1);

        // Then
        assertTrue(foundTicket.isPresent());
        assertEquals(1, foundTicket.get().getId());
    }

    @Test
    void getTicketById_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given

        // When
        Optional<Ticket> foundTicket = ticketStorage.getTicketById(999);

        // Then
        assertFalse(foundTicket.isPresent());
    }

    @Test
    void updateStatus_ShouldUpdateStatus_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketStorage.addTicket(ticket);

        // When
        Optional<Ticket> updatedTicket = ticketStorage.updateStatus(1, Status.IN_PROGRESS);

        // Then
        assertTrue(updatedTicket.isPresent());
        assertEquals(Status.IN_PROGRESS, updatedTicket.get().getStatus());
    }

    @Test
    void updateStatus_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given

        // When
        Optional<Ticket> updatedTicket = ticketStorage.updateStatus(999, Status.IN_PROGRESS);

        // Then
        assertFalse(updatedTicket.isPresent());
    }

    @Test
    void updateAssignee_ShouldUpdateAssignee_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticketStorage.addTicket(ticket);

        // When
        Optional<Ticket> updatedTicket = ticketStorage.updateAssignee(1, "Jan Kowalski");

        // Then
        assertTrue(updatedTicket.isPresent());
        assertEquals("Jan Kowalski", updatedTicket.get().getAssignee());
    }

    @Test
    void updateAssignee_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given

        // When
        Optional<Ticket> updatedTicket = ticketStorage.updateAssignee(999, "Jan Kowalski");

        // Then
        assertFalse(updatedTicket.isPresent());
    }
}