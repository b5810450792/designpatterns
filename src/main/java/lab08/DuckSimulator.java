public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }
    void simulate() {
        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable mallardDuck1 = new QuackEcho(new QuackCounter(new MallardDuck()));

        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck()); //ใช้สำหรับ polymorphism
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Pigeon pigeon = new Pigeon();

        System.out.println("\nDuck Simulator");
        simulate(mallardDuck);
        simulate(mallardDuck1);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        pigeon.coo(); //coo
        pigeon.coo(); //Quack

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() +  " times");
    }
    void simulate(AbstractDuckFactory duckFactory) {
        //3
        Quackable mallardDuck = new QuackCounter(new QuackEcho(duckFactory.createMallardDuck()));
        Quackable redheadDuck = new QuackEcho(new QuackCounter(duckFactory.createRedheadDuck()));
        //2
        Quackable duckCall = new QuackCounter(duckFactory.createDuckCall());
        //1
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        System.out.println("\nDuck Simulator:With Abstract Factory");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() +" times");


        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);
        System.out.println("\nThe ducks quacked " +
                QuackCounter.getQuacks() +" times");
    }
    void simulate(Quackable duck) { //polymorphism
        duck.quack();
    }

}
