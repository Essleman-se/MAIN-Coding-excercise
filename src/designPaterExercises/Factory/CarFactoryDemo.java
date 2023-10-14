package designPaterExercises.Factory;

public class CarFactoryDemo {



    public static void main(String[] args){
        //CarFactory carFactory =  new CarFactory();
        Car car = CarFactory.getCarType(CarType.BIG);

        System.out.println(car.buildCar());
    }


}
