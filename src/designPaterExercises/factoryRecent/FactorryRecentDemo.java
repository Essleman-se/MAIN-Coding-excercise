package designPaterExercises.factoryRecent;

public class FactorryRecentDemo {

    public static void main(String[] args){
        System.out.println(CarFactory.carFactory(CarType.SMALL));
        System.out.println(CarFactory.carFactory(CarType.MEDIUM));
        System.out.println(CarFactory.carFactory(CarType.LARGE));
    }
}
