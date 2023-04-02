package designPaterExercises;

public abstract class Car {

    // Do subclass level processing in this method
    protected abstract void construct();

    private CarType model = null;

    public Car(CarType model) {
        this.model = model;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
        System.out.println("Do one time processing here");
    }



    public CarType getModel() {

        return model;
    }

    public void setModel(CarType model) {

        this.model = model;
    }


}
