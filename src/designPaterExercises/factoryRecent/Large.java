package designPaterExercises.factoryRecent;

public class Large extends Car {
    public Large() {
        super(CarType.LARGE);
    }

    @Override
    protected void constract() {
        System.out.println("Build Large car");
    }
}
