package ExceptionExercises;

import java.io.IOException;

public class CheckedExceptionExam {

    public void method1() throws IOException {

        throw new IOException("Here is the exception");

    }

    public void method2() throws IOException{

        method1();

    }

    public void method3() {

        try {

            method2();

        }catch (Exception e){
            System.out.println("Exception handled checked one ");
        }

    }

    public static void main(String[] args){

        CheckedExceptionExam chEx = new CheckedExceptionExam();

        chEx.method3();
        System.out.println("Normal flow here ");
    }
}
