import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//I panic-wrote this code because I was planning on doing it Thursday night and completely forgot I 
//had a club meeting. I planned createList and isWord out before, drawing from week 12 and some searching 
//on how linkedLists worked. I  googled how to reverse an array list and found some inspiration there.
public class LinkedListMethods2 {
    public static Node<String> createListFromInput(Scanner in) {

        if (!(in.hasNext())) { //checks if empty
            return null;
        }
        Node<String> first = new Node<String>(in.nextLine()); //first word in the line
        Node<String> current = first; 

        while (in.hasNextLine()) {
            Node<String> end = new Node<String>(in.nextLine());
            current.next = end;
            current = current.next; //sets current to next so the loop continues until it's over
        }
        return first;
    }

    public static boolean isWord(Node<Character> head, Scanner dictionary) { 
        if (head == null) { //checks if head is empty
            return false;
        }
        String word = ""; //word we need to find
        Node<Character> current = head; //setting a reference for editing later

        while (current != null) { //fills word
            word = word + current.value; //creates the word we need to find
            current = current.next; //sets current to next so the loop continues until it's over
        }
        while(dictionary.hasNext()) { //checks if dict. contains word
            if(dictionary.nextLine().contains(word)) { //if dict contains the word
                return true;
            }
        }
        return false;
    }

    public static void reverse(Node<Integer> head, File output) {
        try {
            PrintWriter out = new PrintWriter(output);
            //Node<Integer> super = new Node(head.value, head.next);
            Node<Integer> current = head; //set the reference
            Node<Integer> before = null; //keep track of previous and next items
            Node<Integer> after = null;

            //super confusing, but it works, so yeah
            while(current != null) { //runs through the loop to reverse
                after = current.next; //sets the next item to the one after it
                current.next = before; //sets the previous item to the one before it
                before = current;       //sets the previous item to current
                current = after;         //sets the current item to the item after it
            }
            current = before;
            while (current != null) { //printing everything out
                out.println(current.value);
                current = current.next; //keeps the loop running
            }
            out.close(); //almost forgot this part
        }
        catch (IOException e) {               //it says in the readme that we needed to
            System.out.print(e.getMessage()); //import IOExcpetion, but it works so far

        }
    }
}
