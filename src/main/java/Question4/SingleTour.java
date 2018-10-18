package Question4;

public class SingleTour implements Tour {
    private String name;
    private double price;
    private int allSeats;
    private int reservedSeats;

    public SingleTour(String name, double price, int allSeats) {
        this.name = name;
        this.price = price;
        this.allSeats = allSeats;
        this.reservedSeats = 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getAvailableSeats() {
        return this.reservedSeats;
    }

    public void gerReservedSeats(int reservedSeats){
        this.reservedSeats = reservedSeats;
        if (this.allSeats > reservedSeats){
            this.allSeats -= reservedSeats;
        }
    }

}