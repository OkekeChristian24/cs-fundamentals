// MyNodeStack Implementation Test

package stack;

public class MyNodeStackTest{

    public static void printIntegerStack(MyNodeStack<Integer> stack){

        if(stack.isEmpty()){
            System.out.println("This stack is empty");
        }else{
            for(int i = stack.size() - 1; i >= 0; i--){
                System.out.println(stack.get(i));
            }
            
        }
        System.out.println();
        System.out.println();
        
    }

    public static void main(String[] args){
        
        MyNodeStack<Integer> scores = new MyNodeStack<Integer>();

        scores.push(50);
        scores.push(72);
        scores.push(43);
        scores.push(49);
        scores.push(89);
        scores.push(66);
        scores.push(95);

        System.out.println("Initialised stack of numbers:");
        printIntegerStack(scores);

        System.out.println("Pop the number at the top:");
        scores.pop();
        printIntegerStack(scores);

        System.out.println("Pop the number at the top, again:");
        scores.pop();
        printIntegerStack(scores);

        System.out.println("Push 100 to the top of the stack:");
        scores.push(100);
        printIntegerStack(scores);

        System.out.println("Peek at the top number of the stack: " + scores.peek());


    }
}