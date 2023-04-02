package designPaterExercises.factoryRecent;

public class CarTyepeNotFoundException extends RuntimeException {
    private String message;
    public CarTyepeNotFoundException(String message){
        this.message = message;
    }
}
