// This is the implementation of Stack ADT using classes as nodes

package stack;

public class MyNodeStack<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
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
        addLast(elem);
    }

    // Remove an element from the top of the stack
    public T pop(){
        return removeLast();
    }

    // Peek at the element at the top of the stack
    public T peek(){
        return peekLast();
    }

    
    // Add a value at the end of the node
    private void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }

        size++;
    }

    
    // Check the last value from the head
    private T peekLast(){
        if(isEmpty()) throw new RuntimeException("The stack is empty!");
        return tail.data;
    }

    // Get the index position of a given value in the stack
    private int indexOf(Object obj){
        Node<T> trav = head;
        int index = 0;
        while(trav != null){
            if(obj == null){
                if(trav.data == null) return index;
            }else{
                if(obj.equals(trav.data)) return index;
            }
            trav = trav.next;
            index++;
        }
        return -1;
    }

    // Check if a value is in the stack
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

   
    // Remove the value from the tail of the node
    private T removeLast(){
        if(isEmpty()) throw new RuntimeException("This Stack is empty!");
        T value = tail.data;
        tail = tail.prev;
        size--;

        if(isEmpty()){
            head = null;
        }else{
            tail.next = null;
        }
        return value;

    }

   
   
   
    // Empty the Stack
    public void clear(){
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav = trav.next = trav.prev = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // Returns the node with the provided index
    public T get(int index){
        if(index >= size || index < 0) throw new IllegalArgumentException();

        Node<T> trav = head;
        for(int i = 0; i != index; i++){
            trav = trav.next;
        }

        return trav.data;
    }



}