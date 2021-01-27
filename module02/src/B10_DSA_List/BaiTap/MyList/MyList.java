package B10_DSA_List.BaiTap.MyList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 20;
    private Object elements[];

    public int getSize() {
        return size;
    }

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }


    public void ensureCapacity(int minCapacity){
        elements = Arrays.copyOf(elements, minCapacity);
    }
    public void add(int index, E element){

        if (size == elements.length) {
            ensureCapacity(DEFAULT_CAPACITY*2);
        }

        for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

//    public E remove(int index){
//        for(int i = index; i < size; i++){
//            elements[i] = elements[i + 1];
//        }
//
//        return elements;
//    }
}
