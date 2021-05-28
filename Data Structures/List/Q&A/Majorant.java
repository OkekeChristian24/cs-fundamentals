package list_qa;

/* Question:
    The majorant of an array of size N is a value that
    occurs in it at least N/2 + 1 times. Write a program
    that finds the majorant of a given array and prints
    it. If it does not exist, print "The majorant does not exist!"
    
*/

// Solution:

import java.util.*;


public class Majorant{

    // Method to find the majorant in a list
    public static int findMajorant(List<Integer> list) {

        int listSize = list.size(); // Get the number of elements in the list
        int majorant = (listSize / 2) + 1; // Calculate the majorant
        int count = 0;        
        
        for(int i = 0; i < listSize; i++){
            for(int j = 0; j < listSize; j++){
                if(list.get(i) == list.get(j)){
                    count++;
                    if(count >= majorant)
                        return list.get(i);
                    
                }                
                
            }

            count = 0;

        }

        return -1;
    }

    public static void main(String[] args){

        // Initialize the list
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(3, 5, 5, 2, 5, 2, 5));

        // Print out the list
        System.out.print("Printing the list: ");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        
        // Get the majorant
        int result = findMajorant(list);
        if(result == -1)
            System.out.print("The majorant does not exist!");
        else
            System.out.print("The majorant is " + result);
            
    }

}