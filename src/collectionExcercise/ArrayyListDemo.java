package collectionExcercise;

public class ArrayyListDemo {

    public static void main(String[] args) {
        MyArrayList<Integer> ints = new MyArrayList<>();

        ints.add(2);
        ints.add(3);
        ints.add(9);
        ints.add(10);
        ints.add(20);
        ints.add(30);
        ints.add(90);
        ints.add(100);

        for (int i=0; i < ints.Size(); i++){
            System.out.print(ints.get(i) + "  ");
        }
    }
}
