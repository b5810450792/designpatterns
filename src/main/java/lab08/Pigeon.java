public class Pigeon {

    private int count;

    public Pigeon() {
        this.count = 0;
    }

    public void coo(){
        this.count++;
        if(this.count==2){
            System.out.println("Quack");
        }
        else {
            System.out.println("Coo");
        }

    }
}
