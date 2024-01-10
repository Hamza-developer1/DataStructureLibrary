import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<T> implements Iterator<T> {
    private GenericQueue<T>.Node<T> current;
    private ArrayList<GenericQueue<T>> map2;
    private Iterator<GenericQueue<T>> mapIter;

    //Constructor
    public HMIterator(ArrayList<GenericQueue<T>> map) {
        mapIter = map.iterator();
        if (mapIter.hasNext()) {
            GenericQueue<T> queue = mapIter.next();
            current = queue.getHead();
        }
        map2 = map;
    }

    //Checks if the current node is null or not
    @Override
    public boolean hasNext() {
        return current != null;
    }

    //Iterates through the hashmap
    @Override
    public T next() {

        T temp = current.data;
        current = current.next;

        if (current == null && mapIter.hasNext()) {
            GenericQueue<T> queue = mapIter.next();
            if (queue != null) {
                current = queue.getHead();
            }
        }

        return temp;
    }
}
