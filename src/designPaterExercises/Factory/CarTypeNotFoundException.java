package designPaterExercises.Factory;

public class CarTypeNotFoundException extends RuntimeException {

    CarTypeNotFoundException(String message){

        super(message);
    }
}
