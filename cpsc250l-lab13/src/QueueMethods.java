import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class QueueMethods {
    public static Queue<Candy> getCandyOrder(Queue<Candy> dispenser, int day) {

        Queue<Candy> eaten = new Queue<Candy>();
        if (dispenser.isEmpty()) {
            return dispenser;
        }
        if (day == 0) { //Monday
            return dispenser; //it's the same order (?)
        }
        if (day == 1) { //Tuesday
            while (!dispenser.isEmpty()) { // empties the dispenser
                eaten.enqueue(dispenser.dequeue()); // eats one
                if (!dispenser.isEmpty()) { //another check 
                    dispenser.enqueue(dispenser.dequeue()); //adds the first candy to the last spot
                }
            }
            return eaten;
        }
        if (day == 2) { //Wednesday
            while (!dispenser.isEmpty()) { //runs until the dispenser is empty
                eaten.enqueue(dispenser.dequeue()); //eats one
                if (!dispenser.isEmpty()) { //another check

                    dispenser.enqueue(dispenser.dequeue()); //first candy to go to the back
                }
                if (!dispenser.isEmpty()) { //yet another check
                    dispenser.enqueue(dispenser.dequeue()); //second candy to add to the back
                }
            }
            return eaten;
        }
        if (day == 3) { //Thursday
            while (!dispenser.isEmpty()) { //runs until the dispenser is empty
                eaten.enqueue(dispenser.dequeue()); //eats one
                if (!dispenser.isEmpty()) { //another check
                    dispenser.enqueue(dispenser.dequeue()); //first candy to go to the back
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                }
            }
            return eaten;
        }
        if (day == 4) { //Friday
            while (!dispenser.isEmpty()) { //runs until the dispenser is empty
                eaten.enqueue(dispenser.dequeue()); //eats one
                if (!dispenser.isEmpty()) { //another check
                    dispenser.enqueue(dispenser.dequeue()); //first candy to go to the back
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                }
            }
            return eaten;
        }
        if (day == 5) { //Saturday
            while (!dispenser.isEmpty()) { //runs until the dispenser is empty
                eaten.enqueue(dispenser.dequeue()); //eats one
                if (!dispenser.isEmpty()) { //another check
                    dispenser.enqueue(dispenser.dequeue()); //first candy to go to the back
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                }
            }
            return eaten;
        }

        if (day == 6) { //Sunday
            while (!dispenser.isEmpty()) { //runs until the dispenser is empty
                eaten.enqueue(dispenser.dequeue()); //eats one
                if (!dispenser.isEmpty()) { //another check
                    dispenser.enqueue(dispenser.dequeue()); //first candy to go to the back
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                    dispenser.enqueue(dispenser.dequeue());
                }
            }
            return eaten;
        }
        return dispenser;

    }

    public static void getRemainingCandy(Queue<Candy> dispenser, Candy Piece) {
        Queue<Candy> temp = new Queue<Candy>(); //Used for comparing

        while (!dispenser.isEmpty()) { //loop to create first copy
            temp.enqueue(dispenser.dequeue()); //copies dispenser to temp
        }

        while (!temp.isEmpty()) { //runs all the way through
            Candy current = temp.dequeue(); //sets a variable for the current piece and removes it
            if (!(current.equals(Piece))) //if it's not equal, the piece gets added back to the empty dispenser, putting it back in order
                dispenser.enqueue(current); //if it is equal, then the piece still gets removed and the rest of the loop fills the dispenser
        }
    }
}
