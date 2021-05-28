// This is the implementation of List ADT using classes as nodes

package list;

public class MyDoublyLinkedList<T>{
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

    // Get the number of nodes in the list
    public int size(){
        return size;
    }

    // Check if the list empty
    public boolean isEmpty(){
        return size() == 0;
    }

    // Add a value at the start of the list
    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }

        size++;
    }

    // Add a value at the end of the list
    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }

        size++;
    }

    // Append a value to the list
    public void add(T elem){
        addLast(elem);
    }
    
    // Check the first value from the head
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("The list is empty!");
        return head.data;
    }

    // Check the last value from the head
    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("The List is empty!");
        return tail.data;
    }

    // Get the index position of a given value in the list
    public int indexOf(Object obj){
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

    // Check if a value is in the list
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    // Remove the first value from the head of the list
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("The list is empty!");
        T value = head.data;
        head = head.next;
        size--;

        if(isEmpty()){
            tail = null;
        }else{
            head.prev = null;
        }
        return value;
    }

    // Remove the value from the tail of the list
    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("This list is empty!");
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

    // Private method to remove a node from the list
    private T remove(Node<T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();
        T value = node.data;

        node.data = null;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node = node.prev = node.next = null;

        size--;
        return value;

    }

    // Remove the node with the provided index
    public T removeAt(int index){
        if(index >= size || index < 0) throw new IllegalArgumentException();

        Node<T> trav = head;
        for(int i = 0; i != index; i++){
            trav = trav.next;
        }

        return remove(trav);
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

    // Remove the given value from the list
    public boolean remove(Object obj){
        int index = indexOf(obj);
        if(index == -1) return false;
        else{
            removeAt(index);
            return true;
        }
    }

    // Empty the list
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



}