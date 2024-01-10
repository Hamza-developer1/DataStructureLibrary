import java.util.ArrayList;
import java.util.Iterator;
public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head;
    private int length;
    //Default Constructor
    public class Node<T>{
        T data;
        int code;
        Node<T> next;

    }


    //Prints the nodes in the linked list and when it's empty returns "Empty List"
    public void print(){

        if(head == null){
            System.out.println("Empty List");
        }
        else {
            Node<T> current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public abstract void add(T data);
    public abstract T delete();

    //Adds the data of the linked list into an Array
    public ArrayList<T> dumpList(){
        ArrayList<T> list = new ArrayList<>();
        Node<T> current = head;

        while(current != null){
            list.add(current.data);
            current = current.next;
        }
        return list;

    }

    //This function gets the value of a linked list at a given index and returns null if the index is out of bounds
    public T get( int index){
        Node<T> current = head;
        if(index < 0 || index >= length){
            return null;
        }
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
    //Sets the data of a node of a liknked list the value that is passed into the function
    public T set(int index, T element){
        Node<T> current = head;
        if(index < 0 || index >= length){
            return null;
        }
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        T temp = current.data;
        current.data = element;
        return temp;
    }
    //Returns the length
    public int getLength() {
        return length;
    }
    //Sets the length
    public void setLength(int length) {
        this.length = length;
    }
    //Returns head
    public Node<T> getHead() {
        return head;
    }
    //Sets the head
    public void setHead(Node<T> head) {
        this.head = head;
    }
    //Iterates the linked list in reverse order
    public Iterator<T> descendingIterator(){
        return new ReverseGLLIterator<>(head);
    }
    //Iterates through the linked list
    public Iterator<T> iterator(){
        return new GLLIterator<T>(head);
    }


}
