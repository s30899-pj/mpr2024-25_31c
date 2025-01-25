package pl.pjatk.support_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("unit")
class TicketServiceTest {

    @Mock
    private TicketStorage ticketStorage;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTicket_ShouldReturnTicket_WhenDataIsValid() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        when(ticketStorage.addTicket(ticket)).thenReturn(ticket);

        // When
        Ticket createdTicket = ticketService.createTicket(ticket);

        // Then
        assertNotNull(createdTicket);
        assertEquals("Robert Lewandowski", createdTicket.getReporter());
        assertEquals("Mariusz Nowak", createdTicket.getAssignee());
        assertEquals(Status.WAITING_FOR_SUPPORT, createdTicket.getStatus());
        verify(ticketStorage, times(1)).addTicket(ticket);
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
        verify(ticketStorage, never()).addTicket(ticket);
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
        verify(ticketStorage, never()).addTicket(ticket);
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
        verify(ticketStorage, never()).addTicket(ticket);
    }

    @Test
    void getTicketById_ShouldReturnTicket_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        when(ticketStorage.getTicketById(1)).thenReturn(Optional.of(ticket));

        // When
        Optional<Ticket> foundTicket = ticketService.getTicketById(1);

        // Then
        assertTrue(foundTicket.isPresent());
        assertEquals("Robert Lewandowski", foundTicket.get().getReporter());
        verify(ticketStorage, times(1)).getTicketById(1);
    }

    @Test
    void getTicketById_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given
        when(ticketStorage.getTicketById(999)).thenReturn(Optional.empty());

        // When
        Optional<Ticket> foundTicket = ticketService.getTicketById(999);

        // Then
        assertFalse(foundTicket.isPresent());
        verify(ticketStorage, times(1)).getTicketById(999);
    }

    @Test
    void updateStatus_ShouldUpdateStatus_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        when(ticketStorage.updateStatus(1, Status.IN_PROGRESS)).thenAnswer(invocation -> {
            ticket.setStatus(Status.IN_PROGRESS);
            return Optional.of(ticket);
        });

        // When
        Optional<Ticket> updatedTicket = ticketService.updateStatus(1, Status.IN_PROGRESS);

        // Then
        assertTrue(updatedTicket.isPresent());
        assertEquals(Status.IN_PROGRESS, updatedTicket.get().getStatus());
        verify(ticketStorage, times(1)).updateStatus(1, Status.IN_PROGRESS);
    }

    @Test
    void updateStatus_ShouldReturnEmptyOptional_WhenTicketDoesNotExist() {
        // Given
        when(ticketStorage.updateStatus(999, Status.IN_PROGRESS)).thenReturn(Optional.empty());

        // When
        Optional<Ticket> updatedTicket = ticketService.updateStatus(999, Status.IN_PROGRESS);

        // Then
        assertFalse(updatedTicket.isPresent());
        verify(ticketStorage, times(1)).updateStatus(999, Status.IN_PROGRESS);
    }

    @Test
    void updateAssignee_ShouldUpdateAssignee_WhenTicketExists() {
        // Given
        Ticket ticket = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
        ticket.setId(1);
        when(ticketStorage.getTicketById(1)).thenReturn(Optional.of(ticket));
        when(ticketStorage.updateAssignee(1, "Jan Kowalski")).thenAnswer(invocation -> {
            ticket.setAssignee("Jan Kowalski");
            return Optional.of(ticket);
        });

        // When
        Optional<Ticket> updatedTicket = ticketService.updateAssignee(1, "Jan Kowalski");

        // Then
        assertTrue(updatedTicket.isPresent(), "Ticket should be present after update");
        assertEquals("Jan Kowalski", updatedTicket.get().getAssignee(), "Assignee should be updated to Jan Kowalski");
        verify(ticketStorage, times(1)).getTicketById(1);
        verify(ticketStorage, times(1)).updateAssignee(1, "Jan Kowalski");
    }

    @Test
    void updateAssignee_ShouldThrowException_WhenAssigneeIsNull() {
        // Given

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.updateAssignee(1, null);
        });
        assertEquals("Assignee cannot be null or empty.", exception.getMessage());
        verify(ticketStorage, never()).updateAssignee(anyInt(), anyString());
    }

    @Test
    void updateAssignee_ShouldThrowException_WhenTicketDoesNotExist() {
        // Given
        when(ticketStorage.getTicketById(999)).thenReturn(Optional.empty());

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketService.updateAssignee(999, "Jan Kowalski");
        });
        assertEquals("Ticket with ID 999 not found.", exception.getMessage());
        verify(ticketStorage, times(1)).getTicketById(999);
        verify(ticketStorage, never()).updateAssignee(999, "Jan Kowalski");
    }
}