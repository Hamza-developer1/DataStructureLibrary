
public class GenericQueue<T> extends GenericList<T> {

    private Node<T> tail;

    //Default Constructor
    public GenericQueue(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        setHead(newNode);
        tail = newNode;

        setLength(1);
    }
    //Default Constructor for two parameters
    public GenericQueue(T data, int code) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.code = code;
        setHead(newNode);
        tail = newNode;

        setLength(1);
    }
    //Adds the nodes in a Queue order
    public void enqueue(T data){
        add(data);
    }
    //Deletes the nodes in order
    public T dequeue(){
        return delete();
    }

    //Adds nodes in the linked list and maintains the FIFO order
    @Override
    public void add(T data){
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        if(getHead() == null && tail == null){
           setHead(newNode);
           tail = newNode;
           setLength(getLength() + 1);
        }
        else{
            tail.next = newNode;
            tail = newNode;
            setLength(getLength() + 1);
        }

    }

    //Adds nodes in the linked list and maintains the FIFO order
    public void add(T data, int code){
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.code = code;
        if(getHead() == null){
            setHead(newNode);
            tail = newNode;
            setLength(getLength() + 1);
        }
        else{
            tail.next = newNode;
            tail = newNode;
            setLength(getLength() + 1);
        }
    }
    //Deletes the nodes in linked list while maintaining FIFO order
    @Override
    public T delete(){
        Node<T> previous = getHead();
        setHead(previous.next);
        setLength(getLength()-1);
        return previous.data;
    }


}