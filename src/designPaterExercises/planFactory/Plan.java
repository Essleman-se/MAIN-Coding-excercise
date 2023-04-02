package designPaterExercises.planFactory;

public abstract class Plan {
    protected double rate;
    public abstract void getRate();

    public double getBill(int unit){
        return rate * unit;
    }


}
