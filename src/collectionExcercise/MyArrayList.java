package collectionExcercise;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 4;
    private Object elements[];

    public MyArrayList(){

        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e){
        if (size == elements.length)
            resizeCapacity();

        elements[size++] = e;
    }

    private void resizeCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int index){

        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index:  " + index + "' Size" + index);

        return (E)elements[index];
    }

    public int Size() {

        return size;
    }
}
