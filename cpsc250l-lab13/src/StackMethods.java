import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * 
 * @author Avery Logue
 * 4/18/18
 */
public class StackMethods {
    public static Stack<Integer> getEvenNumbers(Stack<Integer> stack) {

        Stack<Integer> copy = new Stack<Integer>(); //Stack to pull from
        Stack<Integer> evens = new Stack<Integer>(); //Stack to return
        Integer num = 0; //Placeholder for checking if even

        while (!stack.isEmpty()) { //Copies the original stack
            copy.push(stack.pop());
        }

        while (!copy.isEmpty()) { //
            num = copy.pop(); //Gets the int for comparing
            if (num % 2 == 0) { //Checks if even
                evens.push(num); //If even, put into Stack to return
            }
            stack.push(num); //Fill original Stack
        }
        return evens;

    }
    public static boolean checkParentheses(String input) {
        Stack<Character> copy = new Stack<Character>(); //Stack to push to when a parentheses is encountered

        for (int i = 0; i < input.length(); i ++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') { //checks for open parentheses
                copy.push(input.charAt(i));
            }
            if ((input.charAt(i) == ')' || input.charAt(i) == ']'|| input.charAt(i) == '}') && copy.isEmpty()) { //checks for a single parentheses
                return false;
            }
            //if something is added in the first if statement, then it's appropriate type of parenthesis should be caught in
            //these ifs and should check if there is a pair
            if (input.charAt(i) == ')') { //if there is a closed parenthesis and copy isn't empty
                if ('(' != copy.pop()) { //checks to see if the brackets match up ie ()
                    return false;
                }
            }
            if (input.charAt(i) == ']') { //if there is a closed parenthesis and copy isn't empty
                if ('[' != copy.pop()) { //checks to see if the brackets match up ie []
                    return false;
                }
            }
            if (input.charAt(i) == '}') { //if there is a closed parenthesis and copy isn't empty
                if ('{' != copy.pop()) { //checks to see if the brackets match up ie {}
                    return false;
                }
            }
        }
        if(!copy.isEmpty()) { //if there are no parenthesis in input
            return false;
        }
        return true; //return true if all matches up
    }
    public static void reverse(Node<Integer> reverseMe, File out) {
        try {
            PrintWriter fout = new PrintWriter(out); //need a PrintWriter to print to out
            Stack<Integer> copy = new Stack<Integer>(); //needed to easily reverse
            Node<Integer> current = reverseMe; //copy of the reverseMe

            while (current != null) { //copies the node into the stack
                copy.push(current.value); //copies the current value to copy
                current = current.next; //sets current to the next value
            }

            while (!copy.isEmpty()) { //loop to print
                fout.println(copy.pop()); //prints copy in reverse
            }
            fout.close(); //need to close the PW
        }
        catch (IOException e) { //catches any exceptions
            System.out.println(e.getMessage()); //prints generic message
        }
    }

}
