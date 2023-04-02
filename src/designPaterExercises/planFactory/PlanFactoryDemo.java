package designPaterExercises.planFactory;

public class PlanFactoryDemo {

    public static void main(String[] args){
        Plan plan = PlanFactory.planFactory(PlanType.DOMESTIC);
        plan.getRate();
        System.out.println(plan.getBill(20));

    }
}
