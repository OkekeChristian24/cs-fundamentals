package stack_qa;

/**
    Question:
    Write a method that removes from all negative numbers from an array of numbers.
    E.g. Array of integers = [3, 19, -25, 8, -1, 10] => [3, 19, 8, 10]

 */

import java.util.*;


 public class RemoveNumbers{

     // Print array
     public static void printArray(int[] arr){

         System.out.print("[");
         for(int i = 0; i < arr.length; i++){
             if(i == (arr.length - 1)){
                System.out.print(arr[i]);
             }else{
                System.out.print(arr[i] + ", ");
             }
         }
         System.out.print("]");

     }
     
     // Remove negative numbers
     public static Stack<Integer> removeNumbers(int[] arr){
         Stack<Integer> stack = new Stack<Integer>();

         for(int i = 0; i < arr.length; i++){
             if(arr[i] > 0){
                 stack.push(arr[i]);
             }
         }

         return stack;
     }

     public static void main(String[] args){
         int[] myArray = {43, -14, 5, 19, -8, 61, 77, -31};
         System.out.print("The array: ");
         printArray(myArray);
         System.out.println();
         System.out.println("The new array: " + removeNumbers(myArray));
     }
 }