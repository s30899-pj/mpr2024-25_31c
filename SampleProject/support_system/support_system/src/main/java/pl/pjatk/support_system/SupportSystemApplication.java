package pl.pjatk.support_system;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SupportSystemApplication {

	private final TicketService ticketService;

	public SupportSystemApplication(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostConstruct
	public void startApplication() {

		Ticket ticket1 = new Ticket("Robert Lewandowski", "Mariusz Nowak", Status.WAITING_FOR_SUPPORT);
		Ticket ticket2 = new Ticket("Ania Kowalczyk", "Jan Kowalski", Status.WAITING_FOR_SUPPORT);

		ticketService.createTicket(ticket1);
		ticketService.createTicket(ticket2);

		ticketService.printTicketDetails(1);

		Optional<Ticket> retrievedTicket = ticketService.getTicketById(1);
		retrievedTicket.ifPresent(ticket -> {
			ticket.setStatus(Status.IN_PROGRESS);
			ticketService.updateStatus(ticket.getId(), Status.IN_PROGRESS);
			System.out.println("Status zgłoszenia o ID " + ticket.getId() + " został zaktualizowany na: " + ticket.getStatus());
		});

		ticketService.updateAssignee(2, "Alex Kowal");
		System.out.println("Pracownik został przypisany do zgłoszenia o ID 2.");
	}

	public static void main(String[] args) {
		SpringApplication.run(SupportSystemApplication.class, args);
	}

}
