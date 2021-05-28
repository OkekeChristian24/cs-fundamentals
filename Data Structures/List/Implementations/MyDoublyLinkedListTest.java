// MyArrayList Implementation Test

package list;


public class MyDoublyLinkedListTest{

    static void printStringList(MyDoublyLinkedList<String> list){

        if(list.isEmpty()){
            System.out.println("This list is empty");
        }else{
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            
        }
        System.out.println();
        System.out.println();
        
    }
    
    public static void main(String[] args){
        MyDoublyLinkedList<String> countries = new MyDoublyLinkedList<String>();
        
        // Add some elements
        countries.add("Nigeria");
        countries.add("USA");
        countries.add("Ghana");
        countries.add("Canada");
        countries.add("Switzerland");

        // Print the elements
        printStringList(countries);

        countries.removeAt(2);

        System.out.println("Removed element at index 2:");
        printStringList(countries);

        System.out.println("Inserted element at the head:");
        countries.addFirst("Norway");
        printStringList(countries);

        System.out.println("The index of Nigeria is " + countries.indexOf("Nigeria"));
        System.out.println("Is there Canada in the list? " + countries.contains("Canada"));
        System.out.println("Peek at the last element: " + countries.peekLast());
        System.out.println();
        System.out.println("Removed the first element: ");
        countries.removeFirst();
        printStringList(countries);
        
        System.out.println("Clearing up the list:");
        countries.clear();
        printStringList(countries);


    }
}