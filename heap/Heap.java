package heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    private Heap(){
    list = new ArrayList<>();
}
private void swap (int first , int second ){
    T temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
}

private int parent(int index ){
    return(index -1) /2;

}

}

