// MyArrayList Implementation Test

package list;


public class MyLinkedListTest{

    static void printStringList(MyLinkedList<String> list){

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
        MyLinkedList<String> countries = new MyLinkedList<String>();
        
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

        countries.set(0, "Norway");
        System.out.println("Inserted element at index 0:");
        printStringList(countries);

        System.out.println("The index of Nigeria is " + countries.indexOf("Nigeria"));
        System.out.println("Is there Canada in the list? " + countries.contains("Canada"));
        
        System.out.println();
        System.out.println("Removed the element at index 3: ");
        countries.removeAt(3);
        printStringList(countries);
        
        System.out.println("Clearing up the list:");
        countries.clear();
        printStringList(countries);


    }
}