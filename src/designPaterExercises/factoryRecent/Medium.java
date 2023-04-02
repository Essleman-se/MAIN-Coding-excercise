package designPaterExercises.factoryRecent;

public class Medium extends Car{


    public Medium() {
        super(CarType.MEDIUM);
    }

    @Override
    protected void constract() {
        System.out.println("Build Medium car");
    }
}
