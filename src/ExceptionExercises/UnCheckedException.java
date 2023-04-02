package ExceptionExercises;

import com.sun.rmi.rmid.ExecPermission;

public class UnCheckedException {

    public void method1(){

        int num = 20/0;

    }

    public void method2(){

        method1();

    }

    public void method3(){

        try {

            method2();

        }catch (Exception e){
            System.out.println("HAndled");
        }
    }

    public static void main(String[] args){

        UnCheckedException unChExc= new UnCheckedException();

        unChExc.method3();
        System.out.println("Normal flow");
    }
}
