package Question4;

import java.util.ArrayList;
import java.util.List;

public class PackageTour implements Tour {
    private String packageName;
    private int seats;
    private List<Tour> tours = new ArrayList<>();

    public PackageTour(String packageName, List<Tour> tours) {
        this.packageName = packageName;
        this.tours = tours;

        int availableSeats = 0;
        int count = 0;

        for(Tour tour:tours){
            if(count==1){
                availableSeats = Math.min(availableSeats,tour.getAvailableSeats());
            }
            else{
                availableSeats = tour.getAvailableSeats();
                count=1;
            }
            seats = availableSeats;
        }
    }

    public void reservedSeat(int Seats){
        if (this.seats > Seats){
            seats -= Seats;
        }
        else{
            System.out.println("seats have no enough");
        }
    }

    @Override
    public String getName() {
        String tourNameInPackage = "";
        for (Tour tour : tours){
            tourNameInPackage += tour.getName()+" ";
        }
        return packageName+" ( "+ tourNameInPackage+")";
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Tour tour : tours){
            total += tour.getPrice();
        }
        return total*0.9;
    }

    @Override
    public int getAvailableSeats() {
        return seats;
    }

}