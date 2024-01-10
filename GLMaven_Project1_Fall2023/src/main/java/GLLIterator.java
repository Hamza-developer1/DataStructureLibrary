import java.util.Iterator;
public class GLLIterator<T> implements Iterator<T> {
    private GenericList<T>.Node<T> current;

    public GLLIterator(GenericList<T>.Node<T> head) {
        this.current = head;
    }

    //Checks if the current is null or not
    @Override
    public boolean hasNext() {
        return current != null;
    }

    //Iterates through the linked list
    @Override
    public T next() {
        GenericList<T>.Node<T> temp = null;
        if(hasNext()) {
            temp = current;
            current = current.next;

        }
        return temp.data;
    }

}
