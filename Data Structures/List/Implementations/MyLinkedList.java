// This is the implementation of List ADT using classes as nodes

package list;

public class MyLinkedList<T>{
    
    private Node<T> head = null; // The head of the list
    private Node<T> tail = null; // The tail of the list
    private int size = 0;

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
        public Node(T data, Node<T> prev){
            this.data = data;
            prev.next = this;
        }
    }

    // Append a value to the list
    public void add(T elem){
        
        if(head == null){
            tail = head = new Node<T>(elem);   
        }else{
            Node<T> new_node = new Node<T>(elem, tail);
            tail = new_node;
        }
        size++;
    }

    // Private method to remove a node from the list
    private void remove(Node<T> node, Node<T> prev){
        size--;
        if(size == 0){
            head = null;
            tail = null;
        }else if(prev == null){
            head = node.next;
        }else{
            prev.next = node.next;
        }

        if(node == tail){
            tail = prev;
        }
    }

    // Empty the list
    public void clear() {
    Node<T> trav = head;
    while (trav != null) {
      Node<T> next = trav.next;
      trav.next = null;
      trav.data = null;
      trav = next;
    }
    head = tail = trav = null;
    size = 0;
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

    // Remove the node with the provided index
    public T removeAt(int index){
        if(index >= size || index < 0) throw new IllegalArgumentException();
        int currentIndex = 0;
        Node<T> trav = head;
        Node<T> prev = null;

        while(currentIndex < index){
            prev = trav;
            trav = trav.next;
            currentIndex++;
        }

        remove(trav, prev);
        return trav.data;

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

    // Get the number of nodes in the list
    public int size(){
        return size;
    }

    // Check if the list empty
    public boolean isEmpty(){
        return size() == 0;
    }

    // Set the value at the index
    public void set(int index, T elem){
        if(index >= size || index < 0) throw new IllegalArgumentException();
        Node<T> trav = head;
        for(int i = 0; i < index; i++){
            trav = trav.next;
        }
        
        trav.data = elem;
    }

    // Returns the value at the given index
    public T get(int index){
        if(index >= size || index < 0) throw new IllegalArgumentException();
        Node<T> trav = head;
        for(int i = 0; i < index; i++){
            trav = trav.next;
        }
        return trav.data;
    }


}