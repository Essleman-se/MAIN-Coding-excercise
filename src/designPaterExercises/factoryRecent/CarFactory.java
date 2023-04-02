package designPaterExercises.factoryRecent;



public class CarFactory {

    public static Car carFactory(CarType model){

        Car car = null;

        switch (model){
            case SMALL:
                car = new Small();
                break;
            case MEDIUM:
                car = new Medium();
                break;
            case LARGE:
                car = new Large();
                break;
            default:
                throw new CarTyepeNotFoundException("Car type is not found");

        }

        return car;
    }
}
