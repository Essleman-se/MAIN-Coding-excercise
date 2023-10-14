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
                            throw new CarTypeNotFoundException("The Car Model Is not Exist");
                    }
                }
            }
        }

        return car;
    }


}
