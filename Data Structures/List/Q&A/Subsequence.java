package list_qa;

/* Question:
    Write a method that finds the longest
    subsequence of equal numbers in a given List<Integer>
    and returns the result as new List<Integer>. Write 
    a program to test it.

*/

// Solution:

import java.util.*;

public class Subsequence{
    
List<Integer> list = new ArrayList<Integer>();

    // Method to filter out the longest subsequence in the given sequence
    public static List<Integer> longestSubsequence(List<Integer> list){

        int longestStart = 0; // Property to store the start of the current longest subsequence
        int longestLength = 1; // Property to store the length of the current longest subsequence
        int start = 0;
        int length = 1;
        int listLength = list.size();

        for(int i = 0; i < listLength - 1; i++){
            if(list.get(i) == list.get(i+1)){
                length++;
                if(length > longestLength){
                    longestLength = length;
                    longestStart = start;
                }
            }else{
                start = i + 1;
                length = 1;
            }
        }

        // Returning the longest subsequence
        return list.subList(longestStart, longestStart + longestLength);

    }

    public static void main(String[] args){

        // Initialize the sequence
        List<Integer> sequence = new ArrayList<Integer>(Arrays.asList(3, 5, 5, 5, 2, 2, 2, 2, 1));

        List<Integer> longestSubseq = longestSubsequence(sequence);

        for(int i = 0; i < longestSubseq.size(); i++){
            System.out.print(longestSubseq.get(i) + " ");
        }
    }

}