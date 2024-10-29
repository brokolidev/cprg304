package exercise1;

import java.util.ArrayList;
import java.util.Iterator;

public class MyAList<E> implements Iterable<E> {

    private ArrayList<E> list;

    // Constructor
    public MyAList() {
        this.list = new ArrayList<>();
    }

    // Adds a single item to the list
    public void add(E item) {
        list.add(item);
    }

    // Adds all items from another MyAList to this list
    public void addAll(MyAList<E> items) {
        for (E item : items) {
            list.add(item);
        }
    }

    // Returns the item at the specified index
    public E get(int index) {
        return list.get(index);
    }

    // Removes the item at the specified index
    public void remove(int index) {
        list.remove(index);
    }

    // Replaces the item at the specified index with a new item
    public void set(int index, E item) {
        list.set(index, item);
    }

    // Returns the size of the list
    public int size() {
        return list.size();
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Converts the list to an array
    public Object[] toArray() {
        return list.toArray();
    }

    // Clears the list
    public void clear() {
        list.clear();
    }

    // Returns an iterator for the list
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}