package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		char option = 'y' ;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		do {
			try {
				System.out.println("Room number: ");
				int number = sc.nextInt();
				System.out.println("Check-in date (dd/MM/yyyy): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy): ");
				Date checkOut = sdf.parse(sc.next());
			
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation " + reservation);
				
				System.out.println();
				System.out.println("Enter to update the reservation: ");
				System.out.println("Check-in date (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation " + reservation);
				
				System.out.println();
				System.out.println("Execute Reservation (y/n) ? ");
				option = sc.next().charAt(0);
				
			}
			catch(ParseException e) {
				System.out.println("Invalid date format");
			}
			catch(IllegalArgumentException e) {
				System.out.println("Error in resevation: " + e.getMessage());
			}
		}while(option != 'n');
		
		sc.close();
	}

}
