package Question4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tour single = new SingleTour("เกาะเต่า",500.0,20);
        ((SingleTour) single).gerReservedSeats(5);
        System.out.println(single.getName());
        System.out.println(single.getPrice());
        System.out.println(single.getAvailableSeats());

        List<Tour> tours = new ArrayList<>();
        tours.add(new SingleTour("Paris",10000,50));
        tours.add(new SingleTour("Rome",8000,40));
        tours.add(new SingleTour("London",12000,40));

        PackageTour pack = new PackageTour("Travel in Europe",tours);

        System.out.println(pack.getName());
        System.out.println("Package Price : "+pack.getPrice());
        System.out.println("Available Seat : "+pack.getAvailableSeats());
        pack.reservedSeat(10);
        System.out.println("Available Seat : "+pack.getAvailableSeats());
    }
}
