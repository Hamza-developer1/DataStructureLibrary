import java.util.ArrayList;
import java.util.Iterator;
public class MyHashMap<T> implements Iterable<T>  {
 private ArrayList<GenericQueue<T>> map;

 //Default Constructor which makes all the indices null and puts the values
 MyHashMap(String key, T value){
     map = new ArrayList<GenericQueue<T>>(10);
     for(int i = 0; i < 10; i++){
         map.add(null);
     }
     put(key, value);

 }
 //This function creates a new node if the index is null and adds on the index if it exists
 public void put(String key, T value) {

     int index = key.hashCode() & 9;
     int hashCode = key.hashCode();
     if (map.get(index) == null) {
         map.set(index, new GenericQueue<T>(value, hashCode));

     }
     else{
         map.get(index).add(value, hashCode);
     }


 }

    //This function checks to see if a key value mapping exits in the map, either returns true or false
    public boolean contains(String key){
        int index = key.hashCode() & 9;

        if (map.get(index) != null) {
            GenericQueue<T>.Node<T> currentNode = map.get(index).getHead();
            while (currentNode != null) {
                if (currentNode.code == key.hashCode()) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    //This function gets the value associated with a specific key
    public T get(String key) {
        int index = key.hashCode() & 9;
            if (map.get(index) != null) {
                GenericQueue<T>.Node<T> currentNode = map.get(index).getHead();
                while (currentNode != null) {
                    if (currentNode.code == key.hashCode()) {
                        return currentNode.data;
                    }
                    currentNode = currentNode.next;
                }
            }

        return null;
    }

    //This function returns the size of the Hashmap
    public int size() {
        int count = 0;
        for (GenericQueue<T> element : map) {
            if (element != null) {
                count += element.getLength();
            }
        }
        return count;
    }


    //This function returns true or false on whether the hashmap is empty or not
    public boolean isEmpty() {
        for (GenericQueue<T> element : map) {
            if (element.getLength() != 0) {
                return false;
            }
        }
        return true;
    }

    //This function replaces the value of a key and swaps in te
    public T replace(String key, T value){
        int index = key.hashCode() & 9;

        if (map.get(index) != null) {
            GenericQueue<T>.Node<T> currentNode = map.get(index).getHead();
            while (currentNode != null) {
                if (currentNode.code == key.hashCode()) {
                    T temp = currentNode.data;
                    currentNode.data = value;
                    return currentNode.data;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }


    //Iterates through the Hashmap
 @Override
 public Iterator<T> iterator() {

     return new HMIterator<T>(map);
 }


}
