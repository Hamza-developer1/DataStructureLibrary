import java.util.Iterator;
import java.util.Stack;

public class ReverseGLLIterator<T> implements Iterator<T> {
    private GenericList<T>.Node<T> current;
    private Stack<T> stack;

    //Constructor
    public ReverseGLLIterator(GenericList<T>.Node<T> head) {
        current = head;
        stack = new Stack<>();
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
    }

    // Check if the stack is empty or not
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //Reverses the linked list
    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop();
    }
}