package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reservation reservation;
		LocalDate dateToday = LocalDate.now();

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), dtf);
		System.out.print("check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), dtf);

		if (!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} 
		else if (checkin.isBefore(dateToday) || checkout.isBefore(dateToday)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		} 
		else {
			reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), dtf);
			System.out.print("check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), dtf);

			if (!checkout.isAfter(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else if (checkin.isBefore(dateToday) || checkout.isBefore(dateToday)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} 
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			}
		}

		sc.close();
	}

}
