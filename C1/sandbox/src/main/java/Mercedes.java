public class Mercedes extends Car implements Vehicle {

    @Override
    public void moveForward() {
        System.out.println("Moving Forward");

    }

    @Override
    public void printName() {
        throw new MercedesException("Not implemented");
    }
}
