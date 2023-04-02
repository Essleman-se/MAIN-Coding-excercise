package designPaterExercises.Factory;

public class CarFactoryDemo {



    public static void main(String[] args){
        //CarFactory carFactory =  new CarFactory();
        Car car = CarFactory.getCarType(CarType.SMALL);

        System.out.println(car.buildCar());
    }


}
