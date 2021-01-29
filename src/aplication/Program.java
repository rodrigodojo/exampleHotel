package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		char option = 'y' ;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		do {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
				
			}else {
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation " + reservation);
				
				System.out.println();
				System.out.println("Enter to update the reservation: ");
				System.out.println("Check-in date (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				
				Date now = new Date();
				if(checkIn.before(now) || checkOut.before(now)) {
					System.out.println("Error in reservation: Resevation dates for updates must be future dates");
					System.out.println();
					System.out.println("Execute Reservation (y/n) ? ");
					option = sc.next().charAt(0);
				}else if(!checkOut.after(checkIn)){
					System.out.println("Error in reservation: Check-out date must be after check-in date");
					System.out.println();
					System.out.println("Execute Reservation (y/n) ? ");
					option = sc.next().charAt(0);
				}else {
					reservation.updateDates(checkIn, checkOut);
					System.out.println("Reservation " + reservation);
					System.out.println();
					System.out.println("Execute Reservation (y/n) ? ");
					option = sc.next().charAt(0);
				}
			}	
		}while(option != 'n');
		
		System.out.println("Ended aplication");
		
		sc.close();
	}

}
