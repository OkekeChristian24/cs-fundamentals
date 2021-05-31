// This is the implementation of Stack ADT using array

package stack;

public class MyArrayStack<T>{
    private int size = 0;
    private int capacity;
    private T[] arr;

    public MyArrayStack(){
        arr = (T[]) new Object[10];
        this.capacity = 10;
    }

    
    // Get the number of nodes in the stack
    public int size(){
        return size;
    }

    // Check if the stack empty
    public boolean isEmpty(){
        return size() == 0;
    }

    // Push an element into the stack
    public void push(T elem){
        add(elem);
    }

    // Remove an element from the top of the stack
    public T pop(){
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return removeAt(size - 1);
    }

    // Peek at the element at the top of the stack
    public T peek(){
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return arr[size - 1];
    }

    // Append a value to the stack
    private void add(T elem){
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

   
   
    // Empty the stack
    public void clear(){
        size = 0;
        for(int i = 0; i < size; i++) 
            arr[i] = null;
    }

    // Get the index position of a given value in the stack
    private int indexOf(Object obj){
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

    // Check if a value is in the stack
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    // Remove the node with the provided index
    private T removeAt(int index){
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

    //// Get the value at the given index
    public T get(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

   

    
}