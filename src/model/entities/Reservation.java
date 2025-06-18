package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	private DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public long duration() {
		return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();	
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.now();
		
		if (!checkout.isAfter(checkin)) {
			return "Error in reservation: Check-out date must be after check-in date";
		} 
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation: Room "
				+getRoomNumber()
				+", Check-in: "
				+getCheckin().format(dtm)
				+", Check-out: "
				+getCheckout().format(dtm)
				+", "+duration()
				+" nights";
		
				
				
	}
	
	
}
