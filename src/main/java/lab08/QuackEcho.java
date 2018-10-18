public class QuackEcho implements Quackable {
    Quackable duck;
    public QuackEcho(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        System.out.print("Echo : ");
        duck.quack();
    }
}
