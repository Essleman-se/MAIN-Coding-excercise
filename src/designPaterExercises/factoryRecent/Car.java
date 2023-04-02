package designPaterExercises.factoryRecent;



public abstract class Car {

    protected abstract void constract();

    private CarType model = null;

    public Car(CarType model){
        this.model = model;
        constract();
    }
}
