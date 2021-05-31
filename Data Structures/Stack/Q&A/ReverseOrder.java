package stack_qa;

import java.util.*;

public class ReverseOrder{

    public static void main(String[] args){
        
        Scanner numScore = new Scanner(System.in);
        Stack<Integer> scores = new Stack<Integer>();

        System.out.print("Enter the number of scores to print: ");
        int num = numScore.nextInt();

        System.out.println();

        System.out.println("Enter " + num + " scores:");

        Scanner score = new Scanner(System.in);
        for(int i = 0; i < num; i++){
            System.out.print((i + 1) + " - ");
            scores.push(score.nextInt());
        }

        System.out.println();
        // Print in reverse order
        System.out.println("Printing the scores in reverse order");
        for(int i = 0; i < num; i++){
            System.out.print((i + 1) + " - ");
            System.out.println(scores.pop());
        }
        
    }
}