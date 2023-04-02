package designPaterExercises.Factory;

public class CarFactory {

    private static Car car;

    private CarFactory(){

    }

    public static Car getCarType(CarType model){

        if(car == null) {
            synchronized (CarFactory.class) {
                if (car == null) {
                    switch (model) {
                        case SMALL:
                            car = new SmallCar();
                            break;
                        case MEDIUM:
                            car = new MediumCar();
                            break;
                        case LARGE:
                            car = new LargeCar();
                            break;
                        default:
                            throw new CarTypeNotFoundException("Here is the exception of car type");

                            //System.out.println("Car type is not available");

                    }
                }
            }
        }

        return car;
    }


}
