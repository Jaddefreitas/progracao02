package Ex01;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;

public class Reservation {
    private Integer room_number;
    private LocalDate check_in;
    private LocalDate check_out;

    public Reservation(Integer room_number, LocalDate check_in, LocalDate check_out){
        this.room_number = room_number;
        this.check_in = check_in;
        this.check_out = check_out;

        if(nights() < 0){
            throw new InputMismatchException("Error in reservation: Check-out date must be after check-in date");
        }
    }

    public void setCheckIn(LocalDate check_in) {
        Period date_cont = Period.between(this.check_out, check_in);

        if (date_cont.getDays() < 0) {
            throw new InputMismatchException("Error in reservation: Reservation dates for update must be future dates");
        }

        this.check_in = check_in;
    }

    public void setCheckOut(LocalDate check_out) {
        if(nights() < 0){
            throw new InputMismatchException("Error in reservation: Check-out date must be after check-in date");
        }

        this.check_out = check_out;
    }

    public void print_reservation(){
        System.out.println("Reservation: Room "+room_number+", check-in: "+check_in+", check-out: "+check_out+", "+nights()+" nights");
    }

    private Integer nights(){
        Period date_cont = Period.between(check_in,check_out);
        return date_cont.getDays();
    }

}


