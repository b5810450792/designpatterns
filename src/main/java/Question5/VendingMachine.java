package Question5;

public class VendingMachine {
    private String gotoStation;
    private String currentStation="Bearing";
    private boolean ready,coinsReady,complete;
    private int price;
    private int currentCoin;

    public void chooseStation(String gotoStation){

        if(ready&&(!gotoStation.equals(this.gotoStation))){
            System.out.println(currentStation);
            this.gotoStation=gotoStation;
            price = 100;
            ready = false;
            System.out.println(price);
            System.out.println(gotoStation);
            coinsReady=true;
        }
        else{
            System.out.println("Try again!");
        }

    }

    public void insertCoin(int amount){
        if(coinsReady){
            this.currentCoin+=amount;
            if(this.currentCoin < price){
                System.out.println(price - this.currentCoin);

            }else if(this.currentCoin>price){
                int change=0;
                change = this.currentCoin - price;
                System.out.println(change);
                coinsReady=false;
                complete=true;
                System.out.println("Complete");

            }else{
                coinsReady=false;
                complete=true;
                System.out.println("Complete");
            }
        }

    }

    public void recieveTicket(){
        if(complete){
            System.out.println("Your ticket is here");
            System.out.println("Current Station is "+ currentStation);
            System.out.println("Destination is "+ gotoStation);
            complete=false;
            ready=true;
        }

    }

}
