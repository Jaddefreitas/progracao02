package Ex01;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Room number:");
        Integer room_number = Integer.valueOf(scanner.nextLine());
        System.out.print("Check-in date (dd/MM/yyyy):");
        LocalDate date_initial = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Check-out date (dd/MM/yyyy):");
        LocalDate date_final = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Reservation reservation1;
        
        try{
            reservation1 = new Reservation(room_number,date_initial,date_final);
        }
        catch(InputMismatchException exception){
            System.out.println(exception.getMessage());
            scanner.close();
            return;
        }

        reservation1.print_reservation();
        
        System.out.println();
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy):");
        LocalDate new_date_initial = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Check-out date (dd/MM/yyyy):");
        LocalDate new_date_final = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            reservation1.setCheckIn(new_date_initial);
            reservation1.setCheckOut(new_date_final);
        }
        catch(InputMismatchException exception){
            System.out.println(exception.getMessage());
            scanner.close();
            return;
        }

        reservation1.print_reservation();

        scanner.close();
    }
}

