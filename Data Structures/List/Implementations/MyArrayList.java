// This is the implementation of List ADT using array

package list;

public class MyArrayList<T>{
    private int size = 0;
    private int capacity;
    private T[] arr;

    public MyArrayList(int capacity){
        if(capacity < 0) throw new IllegalArgumentException(capacity + " must NOT be negative");
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public MyArrayList(){
        this(10);
    }

    // Get the number of nodes in the list
    public int size(){
        return size;
    }

    // Check if the list empty
    public boolean isEmpty(){
        return size() == 0;
    }

    // Append a value to the list
    public void add(T elem){
        if(size + 1 >= capacity){
            capacity = capacity * 2;
            T[] new_arr = (T[]) new Object[capacity];
            for(int i=0; i<size; i++){
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }

        arr[size] = elem;
        size++;
    }

    // Insert the value at the index
    public void insert(int index, T elem){
        if(index >= this.size || index < 0) throw new IndexOutOfBoundsException();

        arr[index] = elem;
    }

    //// Get the value at the given index
    public T get(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    // Empty the list
    public void clear(){
        size = 0;
        for(int i = 0; i < size; i++) 
            arr[i] = null;
    }

    // Get the index position of a given value in the list
    public int indexOf(Object obj){
        if(obj == null){
            for(int i = 0; i < size; i++){
                if(arr[i] == null) return i;
            }
        }else{
            for(int i = 0; i < size; i++){
                if(obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    // Check if a value is in the list
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    // Remove the node with the provided index
    public T removeAt(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        T value = arr[index];
        T[] new_arr = (T[]) new Object[size - 1];
        for(int i = 0, j = 0; i < size; i++, j++){
            if(i == index)
                j--;
            else{
                new_arr[j] = arr[i];
            }
        }
        
        arr = new_arr;
        capacity = --size;
        return value;

    }

    // Remove the given value from the list
    public boolean remove(Object obj){
        int index = indexOf(obj);
        if(index == -1)
            return false;
        
        removeAt(index);
        return true;
    }


    
}