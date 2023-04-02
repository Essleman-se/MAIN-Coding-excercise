package designPaterExercises.factoryRecent;

public class Small extends Car {

    public Small() {
        super(CarType.SMALL);
    }

    @Override
    protected void constract() {
        System.out.println("Build Small car");
    }
}
