package designPaterExercises.planFactory;

public class PlanFactory {

    public static Plan planFactory(PlanType type){
        Plan plan = null;

        switch (type){
            case DOMESTIC:
                plan = new DomesticPlan();
                break;
            case INTERNATIONAL:
                plan = new InternationalPlan();
                break;
            default:
                System.out.println("type not found exception");

        }


        return plan;
    }
}
